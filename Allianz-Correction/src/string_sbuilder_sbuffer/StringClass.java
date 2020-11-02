package string_sbuilder_sbuffer;

public class StringClass {

	public void concatString0(String s1, String s2) {
		s1 = s1+" "+s2;
		System.out.println(s1);
		System.out.println("------------");
	}
	
	public String concatString1(String s1, String s2) {
		String s = s1.concat(" " + s2);;
		return s;
	}
	
	public String concatString2(String s) {
		String s1 = s + " Kamdem";
		return s1;
	}
	
	public void concatStringBuilder(StringBuilder sBuilder) {
		sBuilder = sBuilder.append(" Kamdem");
	}
	
	public void concatStringBuffer(StringBuffer sBuffer) {
		sBuffer = sBuffer.append(" Kamdem");
	}
}
