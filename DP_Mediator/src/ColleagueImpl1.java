public class ColleagueImpl1 extends Colleague {

    public ColleagueImpl1(){
        super();
    }

    public ColleagueImpl1(String name, Mediator mediator) {
        super(name, mediator);
    }

    public ColleagueImpl1(String name) {
        super(name);
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("CollegueImpl1 Nom= "+ name);
        System.out.println("Envoi du message vers "+ message.getReceiver());
        message.setSender(this.name);
        mediator.transmitMessage(message);
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.println("CollegueImpl1 Nom= "+ name);
        System.out.println("Reception du message ");
        System.out.println(message.getContain() + "eeeeeeee");
        System.out.println("Contenu: "+ message.getContain());
        System.out.println("Exp: "+message.getSender());
    }
}
