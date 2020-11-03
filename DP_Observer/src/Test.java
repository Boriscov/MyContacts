public class Test {
    public static void main(String[] args) {
        ObservableImpl observableImpl=new ObservableImpl();
        Observer observer1 = new ObserverImpl1();
        Observer observer2 = new ObserverImpl2();
        Observer observer3 = new ObserverImpl1();

        observableImpl.subscribe(observer1);
        observableImpl.subscribe(observer2);
        observableImpl.subscribe(observer3);


        observableImpl.setState(50);
        observableImpl.setState(30);
        observableImpl.unsubscribe(observer3);

        //programmation evenementielle
        observableImpl.subscribe(new Observer() {
            @Override
            public void update(Observable observable) {
                System.out.println("Observateur anonyme ===> ");
            }
            public void update(int state) {
                System.out.println("Observateur anonyme ===> ");
            }
        });


        //C est l'equivalent de la methode precedente avec la syntaxe lambda de java 8
        //observableImpl.subscribe(observable -> System.out.println("Observateur anonyme ===> "));


        observableImpl.setState(1033);
    }
}
