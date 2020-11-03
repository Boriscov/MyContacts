public class Singleton {
    private int counter;
    private static Singleton singleton = new Singleton();
    /*private static final Singleton singleton;
    static {
        singleton=new Singleton();
    }*/
    private Singleton(){
        System.out.println("Instanciation du singleton");
    }

    public static Singleton getInstance(){
        return singleton;
    }

    public void treat(String taskName){
        System.out.println("...Traitement de la tache "+taskName);
        for (int i=1; i<5; i++){
            synchronized (this) {
                ++counter;
            }
            System.out.println(".. "+counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fin du traitement de la tache" +
                taskName + "Compteur="+counter);
    }
}
