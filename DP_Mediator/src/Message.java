public class Message {
    private String contain;
    private String sender;
    private String receiver;

    public Message(){

    }

    public Message(String contain, String receiver) {
        this.contain = contain;
        this.receiver = receiver;
    }

    public Message(String contain, String sender, String receiver) {
        this.contain = contain;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Message{" +
                "contain='" + contain + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                '}';
    }
}
