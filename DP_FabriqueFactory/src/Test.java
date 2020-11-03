import fabriques.FabriqueBaham;
import pizzas.Pizza;

public class Test {

    public static void main(String[] args) {
        Pizzeria pizzeria=new Pizzeria(new FabriqueBaham());
        Pizza pizza=pizzeria.bookPizza("fromage");
        System.out.println(pizza.getDescription());
    }
}
