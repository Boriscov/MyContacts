public class Test {
    public static void main(String[] args) {
        ReceiverImpl1 receiverImpl1 = new ReceiverImpl1();
        ReceiverImpl2 receiverImpl2 = new ReceiverImpl2();

        Command commandA = new CommandA(receiverImpl1);
        Command commandB = new CommandB(receiverImpl1);
        Command commandc = new CommandC(receiverImpl2);

        Invoker invoker = new Invoker();

        invoker.addNewcommand("A", commandA);
        invoker.addNewcommand("B", commandB);
        invoker.addNewcommand("C", commandc);

        invoker.invoke("A");
        invoker.invoke("B");

        invoker.invoke("D");
    }
}
