import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MyQueue<T> implements Agenda<T>{
    private PriorityQueue<T> queue;

    public MyQueue(){
        queue = new PriorityQueue<T>();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int size(){
        return queue.size();
    }

    public void add(T t){
        queue.add(t);
    }

    public void remove(){
        if(queue.size() > 0){
            queue.remove();
        }
    }

    public T peek(){
        if(queue.size() > 0){
            return queue.peek();
        }
        throw new NoSuchElementException();
    }
    

}