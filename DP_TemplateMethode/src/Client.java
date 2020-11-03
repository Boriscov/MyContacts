public class Client {

    public static void main(String[] args) {
        Template template = new TemplateImpl1();
        System.out.println(template.templateMethod());
        template=new TemplateImpl2();
        System.out.println(template.templateMethod());
    }
}
