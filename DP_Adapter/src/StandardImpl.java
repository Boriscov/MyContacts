public class StandardImpl implements Standard{

    @Override
    public void operation(int n1, int n2) {
        double res=n1*n2;
        System.out.println("***************");
        System.out.println("****** Res= "+res);
        System.out.println("Implementation standard 1");
        System.out.println("*****************");
    }
}
