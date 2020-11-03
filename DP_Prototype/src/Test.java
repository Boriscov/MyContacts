public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Figure figure1=new Circle(new Point(10, 10), new Point(20,20));
        Figure figure2=new Rectangle(new Point(30,30), new Point(40,40));

        System.out.println("Surface de " +figure1+ "est "+ figure1.surface() );
        System.out.println("Surface de " +figure2+ "est "+ figure2.surface() );

        Figure figure3=figure1.clone();
        System.out.println("Surface de " +figure3+ "est "+ figure3.surface() );

        Figure figure4=figure2.clone();
        System.out.println("Surface de " +figure4+ "est "+ figure4.surface() );

        figure1.point1.x=60;
        System.out.println(figure1);
        System.out.println(figure3);
    }
}
