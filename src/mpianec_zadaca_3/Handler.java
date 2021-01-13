package mpianec_zadaca_3;


public interface Handler {
    void calculate(int broj);
    public void setNext(Handler handler);
}
