package boissons;

import decorator.Caramel;
import decorator.Chocolat;

public class Test {

    public static void main(String[] args){
        Boisson boisson = new Espresso();
        System.out.println("***************");
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("***************");
        boisson = new Chocolat(boisson);
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
        System.out.println("***************");
        boisson = new Caramel(boisson);
        System.out.println(boisson.getDescription());
        System.out.println(boisson.cout());
    }
}
