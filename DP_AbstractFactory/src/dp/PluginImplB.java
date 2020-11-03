package dp;

import dp.AbstractPlugin;

public class PluginImplB implements AbstractPlugin {
    @Override
    public void treatment() {
        System.out.println("Traitement du plugin B...");
    }
}
