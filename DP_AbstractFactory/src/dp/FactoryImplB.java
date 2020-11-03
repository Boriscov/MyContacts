package dp;

import dp.AbstractFactory;

public class FactoryImplB implements AbstractFactory {

    @Override
    public AbstractPlugin getInstance() {
        return new PluginImplB();
    }
}
