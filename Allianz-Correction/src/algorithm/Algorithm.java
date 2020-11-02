package algorithm;

public class Algorithm {
	
	public static char me(String string) {
		char[] s = string.toCharArray();
		char c = ' ';
		int i, j;
		for (i=0; i < s.length-1;  i++) {
			for (j=i+1; j<s.length; j++) {
				if (s[i] == s[j]) {
					c = s[i];
					break;
				}
			}
			if (c == s[i]) {
				break;
			}	
		}
		
		return c;
	}
	
	
	
	
	public static void main(String[] args) {
		
		char a = me("zfoja");
		System.out.println(a);
		
	}

}
