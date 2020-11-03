public class StateA extends State {
    @Override
    public void operationA() {
        System.out.println("Je suis deja dans l'etat A");
    }

    @Override
    public void operationB() {
        System.out.println("Passage de l'etat A vers l'etat B");
        stateClass.setState(new StateB());
    }

    @Override
    public void operationC() {
        System.out.println("Impossible de passer de l etat A vers C");
    }

    @Override
    public void doAction() {
        System.out.println("Je suis dans l'etat A");
    }
}
