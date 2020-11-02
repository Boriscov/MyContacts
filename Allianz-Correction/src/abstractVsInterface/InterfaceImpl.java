package abstractVsInterface;


//Implementation of a static method + method reference
public class InterfaceImpl {
	
	
	public static void playFootball() {
		System.out.println("Mieu tam Ballon");
	}
	
	public static void main(String[] args) {
		
		InterfaceA ia = InterfaceImpl::playFootball;
		ia.play();
		System.out.println(ia);
	}
	
	
	
	

}
