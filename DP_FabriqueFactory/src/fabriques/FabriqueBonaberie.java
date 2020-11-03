package fabriques;

import pizzas.Pizza;
import pizzas.PizzaCheese;
import pizzas.PizzaSeaFood;
import pizzas.PizzaDesBoys;

public class FabriqueBonaberie implements FabriquePizza {

    @Override
    public Pizza createPizza(String typ) {
        Pizza pizza = null;
        if (typ.equals("fromage")){
            pizza=new PizzaCheese();
        }
        else if (typ.equals("fruits")){
            pizza = new PizzaSeaFood();
        }
        else if (typ.equals("bonaberie")){
            pizza = new PizzaDesBoys();
        }
        return pizza;
    }
}
