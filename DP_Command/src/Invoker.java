import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private Map<String, Command> commandMap = new HashMap<String, Command>();

    public void addNewcommand(String ref, Command command){
        commandMap.put(ref, command);
    }

    public void invoke(String ref){
        Command command = commandMap.get(ref);
        if (command!=null) command.execute();
    }
}
