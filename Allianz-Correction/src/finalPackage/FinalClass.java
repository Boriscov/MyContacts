package finalPackage;

//If this class is final, the FinalChildClass will an error
public class FinalClass {
	
	protected int i = 5;
	public int j = 5;
	
	public void m1() {
		int i = 10;
		int result = i*10;
	}
	
	
	public final void m2() {
		int i = 10;
		int result = i*10;
	}

}
