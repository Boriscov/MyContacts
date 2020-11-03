public class CommandC implements Command {
    private ReceiverImpl2 receiverImpl2;

    public CommandC(ReceiverImpl2 receiverImpl2) {
        this.receiverImpl2 = receiverImpl2;
    }

    @Override
    public void execute() {
        receiverImpl2.action3();
    }
}
