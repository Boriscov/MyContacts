import strategy.IStrategy;

public class DefaultStrategyImpl implements IStrategy {
    @Override
    public void applyStrategy() {
        System.out.println("Strategie par defaut");
    }
}
