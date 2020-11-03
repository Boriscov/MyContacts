import dp.AbstractFactory;
import dp.AbstractPlugin;
import dp.FactoryImplA;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Instanciation statique
        AbstractFactory factory=new FactoryImplA();
        AbstractPlugin plugin=factory.getInstance();
        plugin.treatment();

        //Instanciation statique
        AbstractFactory factory2= (AbstractFactory) Class.forName("dp.FactoryImplB").newInstance();
        AbstractPlugin plugin2=factory2.getInstance();
        plugin2.treatment();
    }
}
