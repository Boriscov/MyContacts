package decorator;

import boissons.Boisson;

public abstract class AbstractDecorator extends Boisson {
    protected Boisson boisson;

    //constructeur avec parametre symbolisant l aggregation
    public AbstractDecorator(Boisson boisson){
        super();
        this.boisson = boisson;
    }

    public abstract String getDescription();
}
