public class Client {
    private Standard standard;

    public void process(int n1, int n2){
        standard.operation(n1, n2);
    }

    public void setStandard(Standard standard){
        this.standard = standard;
    }
}
