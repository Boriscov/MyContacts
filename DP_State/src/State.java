public abstract class State {
    protected StateClass stateClass;
    public abstract void operationA();
    public abstract void operationB();
    public abstract void operationC();
    public abstract void doAction();

    public void setStateClass(StateClass stateClass) {
        this.stateClass = stateClass;
    }
}
