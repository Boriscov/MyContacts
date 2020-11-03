package pizzas;

public class PizzaDesBoys extends Pizza {

    public PizzaDesBoys() {
        description=".Pizza des Dons mans";
    }

    @Override
    public void cook() {
        System.out.println("Cuire en 10min");
    }

    @Override
    public void pack() {
        System.out.println("Emballage simple");
    }

    @Override
    public void prepare() {
        System.out.println("Preparation a 6min");
    }

    @Override
    public void cut() {
        System.out.println("Decouper en 6 morceaux");
    }
}
