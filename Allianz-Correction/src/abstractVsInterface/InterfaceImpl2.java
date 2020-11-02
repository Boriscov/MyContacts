package abstractVsInterface;


//Implementation of a non static method + method reference
public class InterfaceImpl2 {
	
	
	public void playFootball() {
		System.out.println("Li la tatom djap");
	}
	
	public static void main(String[] args) {
		
		InterfaceImpl2 mr = new InterfaceImpl2();
		
		InterfaceA ia = mr::playFootball;
		ia.play();
		
		InterfaceA ia2 =  new InterfaceImpl2()::playFootball;
		ia2.play();
		//System.out.println(ia);
	}
	
	
	
	

}
