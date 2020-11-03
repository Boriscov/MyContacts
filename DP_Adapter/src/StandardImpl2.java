public class StandardImpl2 implements Standard{

    @Override
    public void operation(int n1, int n2) {
        double res=n1+n2;
        System.out.println("***************");
        System.out.println("Implementation standard 2");
        System.out.println("****** Res= "+res);
        System.out.println("*****************");
    }
}
