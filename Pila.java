//Implementare qui la classe Pila
import java.util.NoSuchElementException;

class Pila<T>{
    private Nodo<T> top;

    public Pila(){
        this.top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(T dato){
        Nodo<T> nuovoNodo = new Nodo<>(dato);

        nuovoNodo.next = top;
        top = nuovoNodo;
    }

    public T pop(){
        if(top == null){
            throw new NoSuchElementException("La pila è vuota!");
        }

        T dato = top.dato;
        top = top.next;

        return dato;
    }

    public T peek(){
        if(top == null){
            throw new NoSuchElementException("La pila è vuota!");
        }

        return top.dato;
    }

    public int size(){
        int c = 0;
        Nodo<T> attuale = top;

        while(attuale != null){
            ++c;
            attuale = attuale.next;
        }

        return c;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        str.append("top ---> ");

        Nodo<T> attuale = top;

        while(attuale != null){
            str.append(attuale.dato + " ---> ");
        }

        str.append("null");

        return str.toString();
    }
}