package simple03;

public class MessageBeanKorea implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("안녕 " + name + " !!!");
	}

}
