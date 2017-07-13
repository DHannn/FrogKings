package Jason_test0713;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class test021_NIO_server {
	
	private int Flag = 0;
	private int BLOCK = 4096;
	//send & receive buffer: allacate(4096)
	private ByteBuffer senddata = ByteBuffer.allocate(BLOCK);
	private ByteBuffer receivedata = ByteBuffer.allocate(BLOCK);
	
	private Selector selector;
	
	public test021_NIO_server(int port) throws IOException{
		//打开服务器socket套接字通道
		ServerSocketChannel serversocketchannel = ServerSocketChannel.open();
		//服务器配置为非阻塞
		serversocketchannel.configureBlocking(false);
		//检索与此通道相关关联的服务器套接字
		ServerSocket serversocket = serversocketchannel.socket();
		//服务器绑定
		serversocket.bind(new InetSocketAddress(port));
		//通过open方法找到selector
		selector = Selector.open();
		//注册到selector，等待连接
		serversocketchannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("server start----8888:");
	}
	
	private void listen() throws IOException{
		while (true) {
			//选择一组键，并且相应的通道一经打开
			selector.select();
			//返回此选择器的已选择键集
			Set<SelectionKey> selectionkeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionkeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				iterator.remove();
				handleKey(selectionKey);
			}
		}
	}

	//处理请求
	private void handleKey(SelectionKey selectionKey) throws IOException {
		// TODO Auto-generated method stub
		ServerSocketChannel server = null;
		SocketChannel client = null;
		String receiveText;
		String sendText;
		int count = 0;
		
		//测试此键的通道是否已准备好接受新额套接字连接
		if (selectionKey.isAcceptable()) {
			//返回之前为之创建的此键的通道
			server = (ServerSocketChannel)selectionKey.channel();
			//接收到此通道套接字的连接
			//此方法返回 的谭杰子通道（IF EXISTS）将处于受阻模式
			client = server.accept();
			//配置为非阻塞
			client.configureBlocking(false);
			//注册到selector，等待连接
			client.register(selector, SelectionKey.OP_ACCEPT);
			//将缓冲器清空等待下一次数据的读取
			receivedata.clear();
			//读取服务器发送过来的数据到缓冲区
			count = client.read(receivedata);
			if (count > 0) {
				receiveText = new String(receivedata.array(),0,count);
				System.out.println("服务器端接受客户端数据--："+receiveText);
				client.register(selector, SelectionKey.OP_ACCEPT);
			}
		} else if(selectionKey.isWritable()) {
			//将缓冲器清空以备下次写入
			senddata.clear();
			//返回之前为此创建的此键的通道
			client = (SocketChannel) selectionKey.channel();
			sendText = "message from server--"+ Flag++;
			//向缓冲区中输入数据
			senddata.put(sendText.getBytes());
			//将缓冲区各标志复位：因为相里面put了数据，标志被改变，要想从中读取数据发向服务器，就需要复位
			senddata.flip();
			//输出到通道
			client.write(senddata);
			System.out.println("服务区端向客户端发送数据--："+sendText);
			//注册到selector，等待连接
			client.register(selector, SelectionKey.OP_ACCEPT);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		int port = 8888;
		test021_NIO_server NIOsercer = new test021_NIO_server(port);
		NIOsercer.listen();
	}

}
