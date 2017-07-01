package Jason_test0701;


public class test006<T> {
	T field;
	public T getField() {
		return field;
	}
	public void setField(T field) {
		this.field = field;
	}
	public void whatIsT(){
		System.out.println(field.getClass().getName());
	}


	public static void main(String[] args) {
		test006<String> t06 = new test006<String>();
		t06.setField("this is my practice.");
		t06.whatIsT();
	}
	

}


