public class Circle extends Figure {


    public Circle(Point point1, Point point2) {
        super(point1, point2);
    }

    @Override
    public double surface() {
        double r=point1.distance(point2);
        return Math.PI*r*r;
    }

    @Override
    public String toString() {
        return "Cercle{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                '}';
    }


}
