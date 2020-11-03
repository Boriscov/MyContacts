public class Test {

    public static void main(String[] args) {
        MediatorImpl1 mediatorImpl1 = new MediatorImpl1();
        Colleague colleague1 = new ColleagueImpl2("A", mediatorImpl1);
        Colleague colleague2 = new ColleagueImpl2("B", mediatorImpl1);
        Colleague colleague3 = new ColleagueImpl1("C", mediatorImpl1);

        colleague1.sendMessage(new Message("XXXX", "B"));
        colleague1.sendMessage(new Message("AAAA", "C"));
        colleague2.sendMessage(new Message("BBBB", "A"));

        System.out.println("----------");
        System.out.println("Analyser la conversation");
        mediatorImpl1.analyseConversation();
    }
}
