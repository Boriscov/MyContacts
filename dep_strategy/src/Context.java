import strategy.IStrategy;

public class Context {

    private IStrategy strategy;

    public Context() {
        this.strategy = new DefaultStrategyImpl();
    }

    //code ouvert a la modification et non a l evolution
    public void process(){
        strategy.applyStrategy();
    }

    //on affecte a la variable strategy un element qui implemente cette interface
    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }
}
