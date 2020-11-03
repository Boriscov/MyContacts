public class StateB extends State {
    @Override
    public void operationA() {
        System.out.println("Impossible de passer de l etat B vers A");
    }

    @Override
    public void operationB() {
        System.out.println("Je suis deja dans l'etat B");
    }

    @Override
    public void operationC() {
        System.out.println("Passage de l'etat B vers l'etat C");
        stateClass.setState(new StateC());
    }

    @Override
    public void doAction() {
        System.out.println("Je suis dans l'etat B");
    }
}
