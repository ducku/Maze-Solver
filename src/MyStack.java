import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyStack<T> implements Agenda<T>{
    private ArrayList<T> stack;

    public MyStack(){
        stack = new ArrayList<T>();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size(){
        return stack.size();
    }


	public void add(T t){
        stack.add(t);
    }

    public void remove(){
        if(stack.size() > 0){
            stack.remove(stack.size() - 1);
        }
    }

    public T peek(){
        if(stack.size() > 0){
            return stack.get(stack.size() - 1);
        }
        throw new NoSuchElementException();
    }

}