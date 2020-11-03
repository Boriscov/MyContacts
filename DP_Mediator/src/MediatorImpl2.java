import java.util.ArrayList;
import java.util.List;

public class MediatorImpl2 extends Mediator {

    //Mediator stateless.
    @Override
    public void transmitMessage(Message message) {
        System.out.println("--------------");
        System.out.println("MediateurImpl2....");
        System.out.println("Transmission du message: ");
        System.out.println("De: "+ message.getSender());
        System.out.println("Vers: "+ message.getReceiver());
        System.out.println("Contenu: "+ message.getContain());
        Colleague receiver = colleagueMap.get(message.getReceiver());
        receiver.receiveMessage(message);
    }

}
