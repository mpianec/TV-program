package mpianec_zadaca_3;

/**
 *
 * @author Matija
 * @param <T>
 */
public interface Iterator<T> {
    public boolean hasNext();
    public T getNext();
    public void remove(T emisija);
}
