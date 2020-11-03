package dp;

import dp.AbstractFactory;

public class FactoryImplA implements AbstractFactory {
    @Override
    public AbstractPlugin getInstance() {
        return new PluginImplA();
    }
}
