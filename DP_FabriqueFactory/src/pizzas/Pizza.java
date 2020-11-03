package pizzas;

public abstract class Pizza {
    String description;

    public String getDescription() {
        return description;
    }

    public abstract void cook();
    public abstract void pack();
    public abstract void prepare();
    public abstract void cut();

}
