public abstract class Component {
    protected String name;
    protected int level;

    public Component(String name) {
        this.name = name;
    }

    public abstract void view();

    public String indentation(){
        String string="";
        for(int i = 0; i < level; i++){
            string+="\t";
        }
        return string;
    }

}
