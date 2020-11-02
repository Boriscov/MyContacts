package algorithm;

public class MyClass {
    private int num = Integer.MAX_VALUE;

    public void add() {
        num += 1;
    }
    public int getNum() {
        return num;
    }

    public static void main(String args[]) {
        MyClass mc = new MyClass();
        mc.add();
        long l = mc.getNum();
        System.out.println(l);
        
        String abc = "";
        abc.concat("abc");
        abc.concat("def");
        System.out.print(abc);
    }
}