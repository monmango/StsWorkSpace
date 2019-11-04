package part01_basic;

public class oracleImp implements Service{

	public oracleImp() {
		System.out.println("oracle constructor");
	}
	
	@Override
	public void prn() {
		System.out.println("oracle prn");
	}

}
