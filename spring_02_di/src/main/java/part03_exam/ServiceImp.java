package part03_exam;

//추가 가능
public class ServiceImp implements Service{
	private User user;
	
	public ServiceImp() {
		
	}
	
	public ServiceImp(User user) {
		this.user = user;
	}

	@Override
	public void prn() {
		System.out.println(user.getId() + " " + user.getPass());
	}

}
