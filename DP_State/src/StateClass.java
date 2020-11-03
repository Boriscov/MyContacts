public class StateClass {

    private State state;

    public void setState(State state) {
        this.state = state;
        state.setStateClass(this);
    }

    public void operationA() {
        state.operationA();
    }

    public void operationB() {
        state.operationB();
    }

    public void operationC() {
        state.operationC();
    }

    public void doAction() {
        state.doAction();
    }

    //Aggregation
    /*public StateClass(State stateManager){
        super();
        this.state =stateManager;
        //Bidirectional relation
        stateManager.setStateClass(this);
    }*/


    //Composition to set StateA as default state
    public StateClass(){
        this.state=new StateA();
        //Bidirectional relation
        state.setStateClass(this);
    }
}
