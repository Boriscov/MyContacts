package finalPackage;

public class FinalChildClass extends FinalClass{
	
	public void m1() {
		String s = "Allow";
	}
	
	//This method can't be call, since it is declared final in the upper class
	/*public void m2() {
		String s = "Forbidden";
	}*/
	
	public final double PI = 3.14159; //3.14159 can't be changed
	public final double[] l = {50.2, 60.8}; //l can't be changed, but it contain can be

    public void me3(final double[] l) {
        l[0] = 99; // Is possible, since l the refence
        System.out.println(l); //reference which can't be changed
    }

}
