package Jason_test0713;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class test021_NIO_client {
	/*标识数字*/
	private static int flag = 0;
	/*缓冲区大小*/
	private static int BLOCK = 4096;
	/*接受缓冲区数据*/
	private static ByteBuffer sendbuffer =ByteBuffer.allocate(BLOCK);
	private static ByteBuffer receivebuffer =ByteBuffer.allocate(BLOCK);
	/*服务器地址*/
	private final static InetSocketAddress SERVER_ADDRESS = new InetSocketAddress("localhost", 8888);
	
	public static void main(String[] args) throws IOException {
		//打开Socket通道
		SocketChannel socketchannel = SocketChannel.open();
		//设置为非阻塞方式
		socketchannel.configureBlocking(false);
		//打开选择器
		Selector selector = Selector.open();
		//注册连接服务端socket动作,等待连接
		socketchannel.register(selector, SelectionKey.OP_ACCEPT);
		//连接
		socketchannel.connect(SERVER_ADDRESS);
		
		Set<SelectionKey> selectionkeys;
		Iterator<SelectionKey> iterator;
		SelectionKey selectionkey;
		SocketChannel client;
		String receiveText;
		String sendText;
		int count = 0;
		
		while(true){
			//选择一组键，其相应的通道已为I/O操作准备就绪。
			//此方法执行于阻塞模式的选择操作
			selector.select();
			//返回此选择器的已选择键集
			selectionkeys = selector.selectedKeys();
			iterator = selectionkeys.iterator();
			while (iterator.hasNext()) {
				selectionkey = iterator.next();
				if (selectionkey.isConnectable()) {
					System.out.println("client connect");
					client = (SocketChannel)selectionkey.channel();
					//判断此通道上是否正在进行连接操作
					//完成套接字通道的连接过程
					if (client.isConnectionPending()) {
						client.finishConnect();
						System.out.println("完成连接");
						sendbuffer.clear();
						sendbuffer.put("hello,server!".getBytes());
						sendbuffer.flip();
						client.write(sendbuffer);
					}
					//注册连接服务端socket动作,等待连接
					client.register(selector, SelectionKey.OP_ACCEPT);
				} else if(selectionkey.isReadable()) {
						client = (SocketChannel) selectionkey.channel();
						//将缓冲区清空以备下次数据读取
						receivebuffer.clear();
						//读取服务器发过来的数据到缓冲区中
						count = client.read(receivebuffer);
						if (count > 0) {
							receiveText = new String(receivebuffer.array(), 0, count);
							System.out.println("客户端接受服务器端数据--："+receiveText);
							//注册连接服务端socket动作,等待连接
							client.register(selector, SelectionKey.OP_ACCEPT);
						}
				}else if(selectionkey.isWritable()){
					sendbuffer.clear();
					client = (SocketChannel) selectionkey.channel();
					sendText = "message from client--"+ flag++;
					sendbuffer.flip();
					client.write(sendbuffer);
					System.out.println("客户端向服务器发送数据--："+sendText);
					client.register(selector, SelectionKey.OP_ACCEPT);
				}
			}
			selectionkeys.clear();
		}
	}
	
}





























