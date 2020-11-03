public class StateC extends State {
    @Override
    public void operationA() {
        System.out.println("Passage de l'etat C vers l'etat A");
        stateClass.setState(new StateA());
    }

    @Override
    public void operationB() {
        System.out.println("Passage de l'etat C vers l'etat B");
        stateClass.setState(new StateB());
    }

    @Override
    public void operationC() {
        System.out.println("Je suis deja dans l'etat C");
        stateClass.setState(new StateC());
    }

    @Override
    public void doAction() {
        System.out.println("Je suis dans l'etat C");
    }
}
