import java.util.ArrayList;
import java.util.List;

public class FolderComposite extends Component {

    private List<Component> components=new ArrayList<>();

    public FolderComposite(String name) {
        super(name);
    }

    @Override
    public void view() {
        String tab = indentation();
        System.out.println(tab+"Folder:"+name);
        for (Component component:components){
            component.view();
        }
    }

    public Component addComponent(Component component){
        component.level=this.level+1;
        this.components.add(component);

        return component;
    }

    public Component getComponent(String name){
        for (Component component: components){
            if (component.name.equals(name)) return component;
        }
        return null;
    }
}
