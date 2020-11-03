import java.util.HashMap;
import java.util.Map;

public abstract class Mediator {

    protected Map<String, Colleague> colleagueMap = new HashMap<String, Colleague>();

    public void addCollegue(String ref, Colleague colleague){
        colleagueMap.put(ref, colleague);
    }

    public abstract void transmitMessage(Message message);
}
