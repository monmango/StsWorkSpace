package part01_template;

public class MemDTO {
	
	private String loc;
	private String name;
	private int age;
	private int num;
	
	public MemDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public MemDTO(int num, String name) {
		this.name = name;
		this.num = num;
	}

	public MemDTO(String loc, String name, int age) {
		super();
		this.loc = loc;
		this.name = name;
		this.age = age;
	}

	public MemDTO(String loc, String name, int age, int num) {
		this.loc = loc;
		this.name = name;
		this.age = age;
		this.num = num;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
}
