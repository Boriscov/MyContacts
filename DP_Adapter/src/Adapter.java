public class Adapter extends OldImpl implements Standard{
    private OldImpl old= new OldImpl();

    @Override
    public void operation(int n1, int n2) {
        //composition
        double res = old.calculate(n1,n2);

        //heritage
        double res2 = super.calculate(n1,n2);
        double res3 = this.calculate(n1,n2);
        old.print(res);
        old.print(res2);
        old.print(res3);
    }
}
