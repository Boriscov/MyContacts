public class ObserverImpl2 implements Observer {

    public void update(Observable observable){

        int state= ((ObservableImpl)observable).getState();
        double res=state*state+9;
        System.out.println("******ObserverImpl2********");
        System.out.println("Nouvelle mise a jour: state=" + state);
        System.out.println("Le Resultat de calcul est: " + res);
        System.out.println("*********************");
    }


    //push
    public void update(int state){

        //plus besoin de faire un pop
        //int state= ((ObservableImpl)observable).getState();
        double res=state*state+9;
        System.out.println("******ObserverImpl2********");
        System.out.println("Nouvelle mise a jour: state=" + state);
        System.out.println("Le Resultat de calcul est: " + res);
        System.out.println("*********************");
    }
}
