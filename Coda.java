//Implementare qui la classe Coda
import java.util.NoSuchElementException;


public class Coda<T> {
    private Nodo<T> head;
    private Nodo<T> tail;

    public Coda(){
        this.head = null;
        this.tail = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }

    public void enqueue(T dato){
        Nodo<T> nuovoNodo = new Nodo<T>(dato);

        if(isEmpty()){
            head = nuovoNodo;
            tail = nuovoNodo;
            return;
        }

        tail.next = nuovoNodo;
        tail = nuovoNodo;
    }

    public T dequeue(){
        if(this.isEmpty()){
            throw new NoSuchElementException("La coda è vuota!");
        }

        T dato = head.dato;
        head = head.next;

        if(head == null){
            tail = null;
        }

        return dato;
    }

    public T peek(){
        if(this.isEmpty()){
            throw new NoSuchElementException("La coda è vuota!");
        }

        return head.dato;
    }

    public int size(){
        Nodo<T> attuale = head;

        int size = 0;
        while(attuale != null){
            ++size;
            attuale = attuale.next;
        }

        return size;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        Nodo<T> attuale = head;

        str.append("[Inzio]");

        while(attuale != null){
            str.append(attuale.dato);
            str.append(" --> ");

            attuale = attuale.next;
        }

        str.append("[Fine]");

        return str.toString();
    }  
}