public abstract class Template {

    public int templateMethod(){
        int a = operation1();
        int summe = 0;
        for (int i=0; i<a; i++){
            int b = operation2();
            summe=summe+b;
        }
        return summe;
    }

    protected abstract int operation1();
    protected abstract int operation2();
}
