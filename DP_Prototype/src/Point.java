public class Point implements Cloneable {
    protected int x;
    protected  int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point){
        int a= point.x-this.x;
        int b=point.y-this.y;
        return Math.sqrt(a*a+b*b);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public Point clone() throws CloneNotSupportedException {
        return (Point) super.clone();
    }
}
