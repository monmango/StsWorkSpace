package simple03;

/*
 * factory을 이용하면 결합도는 인터페이스보다는 낮지만 factory가 정확히 구현되여 있지 않으면 참조하는 객체에 영향이 간다.
 */
public class HelloSpring {
	public static void main(String[] args) {
		MessageBean bean = MessageFactory.getInstance("en");
		bean.sayHello("Spring");
		
		bean = MessageFactory.getInstance("ko");
		bean.sayHello("스프링");
	}
}
