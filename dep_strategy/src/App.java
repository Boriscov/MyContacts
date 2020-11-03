import strategy.IStrategy;
import strategy.StrategyImpl1;
import strategy.StrategyImpl2;
import strategy.StrategyImpl3;

import java.util.Scanner;

public class App {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Context context=new Context();

        //evolution statique
        context.process();
        System.out.println("..........");
        context.setStrategy(new StrategyImpl1());
        context.process();
        System.out.println("..........");
        context.setStrategy(new StrategyImpl2());
        context.process();
        System.out.println("..........");
        context.setStrategy(new StrategyImpl3());
        context.process();

        boolean fin=false;
        Scanner scanner=new Scanner(System.in);

        //evolution dynamique
        while (!fin){
            System.out.println("Donner la strategie");
            String strategyClassName=scanner.nextLine();
            //Comme mon app connait juste les instances et ne connait pas les classes, alors
            //il faut charger dynamiquement la classe en memoire et apres il faut l instancier
            IStrategy istrategy = (IStrategy) Class.forName(strategyClassName).newInstance();
            context.setStrategy(istrategy);
            System.out.println("..........");
            context.process();
        }
    }
}
