public abstract class Figure implements Cloneable{
    protected Point point1;
    protected Point point2;

    public Figure(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public Figure clone() throws CloneNotSupportedException {
        Figure figure = (Figure) super.clone();
        figure.point1=point1.clone();
        figure.point2=point2.clone();
        return figure;
    }

    public abstract double surface();

    @Override
    public String toString() {
        return "Figure{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                '}';
    }
}
