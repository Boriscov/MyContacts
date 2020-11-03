import java.util.Random;

public class Proxy implements Standard {

    private StandardImpl target;

    @Override
    public void process() {
        System.out.println("Verification du parametre du context de securite");
        boolean b= new Random().nextBoolean();
        if (b){
            System.out.println("Avant l'appel");
            target = new StandardImpl();
            target.process();
            System.out.println("Apres l'appel");
        }
        else {
            throw new RuntimeException("Forbidden 403");
        }
    }
}
