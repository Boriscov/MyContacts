import finalPackage.FinalChildClass;
import string_sbuilder_sbuffer.StringClass;

public class Test {
	
	public static void main(String[] args) {
		StringClass sc = new StringClass();
		
		String s0 = "Boris";
		String s1 = "Boris";
		String s11 = "Boris";
		StringBuilder s2 = new StringBuilder("Boris");
		StringBuffer s3 = new StringBuffer("Boris");
		
		
	
		
		sc.concatString0(s0,s1);
		String s = sc.concatString1(s11,s11);
		sc.concatString2(s1);
		sc.concatStringBuilder(s2);
		sc.concatStringBuffer(s3);
		
		System.out.println("String: " + s0);
		System.out.println("------------");
		System.out.println("String: " + s11);
		System.out.println("------------");
		System.out.println("String: " + s1);
		System.out.println("------------");
		System.out.println("StringBuilder: " + s2);
		System.out.println("------------");
		System.out.println("StringBuffer: "+ s3);
		System.out.println("------------");
		
		FinalChildClass f = new FinalChildClass();
		final double[] l = {50.2, 60.8};
		f.me3(l);
		System.out.println(l); //referenz which can't be changed
		System.out.println(l[0]);
	}
		
}
