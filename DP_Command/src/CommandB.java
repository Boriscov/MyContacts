public class CommandB implements Command {
    private ReceiverImpl1 receiverImpl1;

    public CommandB(ReceiverImpl1 receiverImpl1) {
        this.receiverImpl1 = receiverImpl1;
    }

    @Override
    public void execute() {
        receiverImpl1.action2();
    }
}
