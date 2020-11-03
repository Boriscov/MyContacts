package decorator;

import boissons.Boisson;

public class Caramel extends AbstractDecorator {


    public Caramel(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + "Au Caramel";
    }

    @Override
    public double cout() {
        return 0.4+boisson.cout();
    }
}
