package pizzas;

public class PizzaSeaFood extends Pizza {

    public PizzaSeaFood() {
        description="pizzas.Pizza au fruit de mer";
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
