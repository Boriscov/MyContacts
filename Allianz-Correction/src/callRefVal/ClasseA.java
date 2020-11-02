package callRefVal;

public class ClasseA {
	
	public String[] s = {"toto", "tata"};
	public String s1 = "Daren";
	
	
	
	
	public void me1 (String[] l, String s1) {
		
		l[0] = "Boris";
		s1 = "Brad";
	}
	
	public void me2 () {
		
		System.out.println(s);
		System.out.println(s[0]);
		System.out.println(s1);
		
		System.out.println("------after the method call----------");
		
		me1(s,s1);
		System.out.println(s);
		System.out.println(s[0]);
		System.out.println(s1);
	}
	
	public static void main(String[] agrs) {
		ClasseA a = new ClasseA();
		a.me2();
	}

}
