package lambda_xxx;

public class ClassB7 {	
	public void doSomething() {
		ClassA.useAPI(new API() {

			@Override
			public boolean checkSomething(String parameter) {
				// TODO Auto-generated method stub
				return parameter.contains("e");
			}
		});
	}
}
