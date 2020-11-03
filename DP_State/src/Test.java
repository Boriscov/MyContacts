public class Test {

    public static void main(String[] args) {
        StateClass stateClass = new StateClass();
        stateClass.doAction();
        stateClass.operationA();
        System.out.println("---------");
        stateClass.operationB();
        //stateClass.doAction();
    }
}
