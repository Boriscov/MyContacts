public interface Observer {

    public void update(Observable observable);
    //avec push
    public void update(int state);
}
