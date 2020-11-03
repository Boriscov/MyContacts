package fabriques;

import pizzas.Pizza;
import pizzas.PizzaCheese;
import pizzas.PizzaSeaFood;

public class FabriqueBaham implements FabriquePizza {

    @Override
    public Pizza createPizza(String typ) {
        Pizza pizza = null;
        if (typ.equals("fromage")){
            pizza=new PizzaCheese();
        }
        else if (typ.equals("fruits")){
            pizza = new PizzaSeaFood();
        }
        return pizza;
    }
}
