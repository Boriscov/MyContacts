package pizzas;

public class PizzaCheese extends Pizza {

    public PizzaCheese() {
        description="pizzas.Pizza au fromage";
    }

    @Override
    public void cook() {
        System.out.println("Cuire en 5min");
    }

    @Override
    public void pack() {
        System.out.println("Emballage simple");
    }

    @Override
    public void prepare() {
        System.out.println("Preparation a 4min");
    }

    @Override
    public void cut() {
        System.out.println("Decouper en 4 morceaux");
    }
}
