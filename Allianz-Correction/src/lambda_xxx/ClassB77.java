package lambda_xxx;

public class ClassB77 {
	
	public void doSomething() {
		API a = parameter -> {return parameter.contains("5");};
		ClassA.useAPI(a);
	}
}
