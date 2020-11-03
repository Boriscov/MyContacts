public class Test {
    public static void main(String[] args) {
        FolderComposite root = new FolderComposite("Root");
        FolderComposite f1 = new FolderComposite("Java");
        FolderComposite f2 = new FolderComposite("Design Pattern");
        FolderComposite f3 = new FolderComposite("Structure");
        root.addComponent(f1);
        root.addComponent(f2);
        root.addComponent(f3);

        f1.addComponent(new File("Composite"));
        f1.addComponent(new File("Decorator"));

        f2.addComponent(new File("Strategy"));

        f3.addComponent(new File("Singleton"));
        f3.addComponent(new File("Builder"));

        f1.addComponent(new FolderComposite("st1"));
        FolderComposite fc1 = (FolderComposite) f1.getComponent("st1");
        fc1.addComponent(new File("Composite version 2"));
        root.view();
    }


}
