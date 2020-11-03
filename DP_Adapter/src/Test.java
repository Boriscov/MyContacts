public class Test {
    private Standard standard;

    public static void main(String[] args) {
        Client client=new Client();
        client.setStandard(new StandardImpl());
        client.process(4,3);
        client.setStandard(new StandardImpl2());
        client.process(4,5);
        client.setStandard(new Adapter());
        client.process(4,5);
    }
}
