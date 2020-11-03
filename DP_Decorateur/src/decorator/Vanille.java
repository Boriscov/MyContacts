package decorator;

import boissons.Boisson;

public class Vanille extends AbstractDecorator {


    public Vanille(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + "A la Vanille";
    }

    @Override
    public double cout() {
        return 0.9+boisson.cout();
    }
}
