public class ObserverImpl1 implements Observer {

    private int counter;

    public void update(Observable observable){

        int state= ((ObservableImpl)observable).getState();
        if(state%2==0) ++counter;
        System.out.println("******ObserverImpl1********");
        System.out.println("Nouvelle mise a jour: state=" + state);
        System.out.println("Resultat de calcul: "+ ((state%2)==0? "Pair":"Impair"));
        System.out.println("Le compteur est: " + counter);
        System.out.println("*********************");
    }

    //push
    public void update(int state){

        //plus besoin de fsire un pod
        //int state= ((ObservableImpl)observable).getState();
        if(state%2==0) ++counter;
        System.out.println("******ObserverImpl1********");
        System.out.println("Nouvelle mise a jour: state=" + state);
        System.out.println("Resultat de calcul: "+ ((state%2)==0? "Pair":"Impair"));
        System.out.println("Le compteur est: " + counter);
        System.out.println("*********************");
    }
}
