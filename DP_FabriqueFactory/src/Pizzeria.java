import fabriques.FabriquePizza;
import pizzas.Pizza;

public class Pizzeria {
    private FabriquePizza fabriquePizza;

    public Pizzeria(FabriquePizza fabriquePizza) {
        this.fabriquePizza = fabriquePizza;
    }

    public Pizza bookPizza(String type){
        Pizza pizza=fabriquePizza.createPizza(type);
        pizza.prepare();
        pizza.cook();
        pizza.cut();
        pizza.pack();
        return pizza;
    }
}
