public class Rectangle extends Figure {


    public Rectangle(Point point1, Point point2) {
        super(point1, point2);
    }

    @Override
    public double surface() {
        int L=Math.abs(point1.x-point2.x);
        int H=Math.abs(point1.y-point2.y);
        return L*H;
    }

    @Override
    public String toString() {
        return "rectangle{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                '}';
    }

    
}
