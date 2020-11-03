public class ColleagueImpl2 extends Colleague {

    public ColleagueImpl2(){
        super();
    }

    public ColleagueImpl2(String name, Mediator mediator) {
        super(name, mediator);
    }

    public ColleagueImpl2(String name) {
        super(name);
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("CollegueImpl2 Nom= "+ name);
        System.out.println("Envoi du message vers "+ message.getReceiver());
        message.setSender(this.getName());
        mediator.transmitMessage(message);
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.println("CollegueImpl2 Nom= "+ name);
        System.out.println("Reception du message ");
        System.out.println("Contenu: "+ message.getContain());
        System.out.println("Exp: "+message.getSender());
    }
}
