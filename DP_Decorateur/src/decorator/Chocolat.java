package decorator;

import boissons.Boisson;

public class Chocolat extends AbstractDecorator {


    public Chocolat(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + "Au chocolat";
    }

    @Override
    public double cout() {
        return 0.7+boisson.cout();
    }
}
