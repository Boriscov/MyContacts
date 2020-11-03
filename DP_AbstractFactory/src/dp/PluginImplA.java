package dp;

import dp.AbstractPlugin;

public class PluginImplA implements AbstractPlugin {
    @Override
    public void treatment() {
        System.out.println("Traitement du plugin A...");
    }
}
