public interface Agenda<T> {

    boolean isEmpty();
    int size();
    void add(T t);
    void remove();
    T peek();
}
