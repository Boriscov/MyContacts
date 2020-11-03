import java.util.ArrayList;
import java.util.List;

public class MediatorImpl1 extends Mediator {
    private List<Message> conversation = new ArrayList<>();

    @Override
    public void transmitMessage(Message message) {
        System.out.println("--------------");
        System.out.println("MediateurImpl1....");
        System.out.println("Transmission du message: ");
        System.out.println("De: "+ message.getSender());
        System.out.println("Vers: "+ message.getReceiver());
        System.out.println("Contenu: "+ message.getContain());
        Colleague receiver = colleagueMap.get(message.getReceiver());
        receiver.receiveMessage(message);
        conversation.add(message);
    }

    public void analyseConversation(){
        for(Message message:conversation){
            System.out.println(message.toString());
        }
    }
}
