package lambda_xxx;

public class ClassA {
	
	public static void useAPI (API apiImplementation) {
		
		String parameter = new String("test");
		boolean b = apiImplementation.checkSomething(parameter);
		System.out.println(b);
	}

}
