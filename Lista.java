//Implementa qui la classe Lista
import java.util.NoSuchElementException;

public class Lista<T>{
    private Nodo<T> head;

    public Lista(){
        this.head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void aggiungiInTesta(T dato){
        Nodo<T> nuovoNodo = new Nodo<>(dato);

        nuovoNodo.next = head;
        head = nuovoNodo;
    }

    public void aggiungiInCoda(T dato){
        Nodo<T> nuovoNodo = new Nodo<>(dato);

        if(head == null){
            head = nuovoNodo;
        }else{
            Nodo<T> attuale = head;
            while(attuale.next != null){
                attuale = attuale.next;
            }
            attuale.next = nuovoNodo;
        }
    }

    public void aggiungiInPosizione(T dato, int posizione){

        if(posizione < 0){
            throw new IndexOutOfBoundsException("La posizione è negativa");
        }

        if(posizione == 0){
            aggiungiInTesta(dato);
        }else{
            Nodo<T> attuale = head;
            int i = 0;

            while(attuale != null && i < posizione - 1){
                attuale = attuale.next;
                ++i;
            }

            if(attuale == null){
                throw new IndexOutOfBoundsException("La posizione supera la dimensione della lista!");
            }

            Nodo<T> nuovoNodo = new Nodo<>(dato);
            nuovoNodo.next = attuale.next;
            attuale = nuovoNodo; 
        }
    }

    public T leggiTesta(){
        if(head == null){
            throw new NoSuchElementException("Lista vuota!");
        }

        return head.dato;
    }

    public T leggiCoda(){
        if(head == null){
            throw new NoSuchElementException("Lista vuota!");
        }

        Nodo<T> attuale = head;
        while(attuale.next != null){
            attuale = attuale.next;
        }

        return attuale.dato;
    }

    public T leggiInPosizione(int posizione){
        if(posizione < 0){
            throw new IndexOutOfBoundsException("La posizione è negativa!");
        }

        Nodo<T> attuale = head;
        int i = 0;

        while(attuale != null && i < posizione){
            attuale = attuale.next;
            ++i;
        }

        if(attuale == null){
            throw new IndexOutOfBoundsException("La posizione supera la dimensione della lista!");
        }

        return attuale.dato;
    }

    public int size(){
        Nodo<T> attuale = head;

        int c = 0;

        while(attuale != null){
            attuale = attuale.next;
            ++c;
        }

        return c;
    }

    public boolean contiene(T dato){
        Nodo<T> attuale = head;

        while(attuale != null){
            if(attuale.dato.equals(dato)){
                return true;
            }

            attuale = attuale.next;
        }

        return false;
    }

    public int indiceDi(T dato){
        Nodo<T> attuale = head;
        int indx = 0;

        while(attuale != null){
            if(attuale.dato.equals(dato)){
                return indx;
            }

            ++indx;
            attuale = attuale.next;
        }

        return -1;
    }

    public boolean cancella(T dato){
        if(head == null){
            return false;
        }

        if(head.dato.equals(dato)){
            head = head.next;
            return true;
        }

        Nodo<T> precedente = head;
        Nodo<T> attuale = head.next;

        while(attuale != null){
            if(attuale.dato.equals(dato)){
                precedente.next = attuale.next;
                
                return true;
            }

            precedente = attuale;
            attuale = attuale.next;
        }

        return false;
    }

    public T cancellaInPosizione(int posizione){
        if(posizione < 0){
            throw new IndexOutOfBoundsException("La posizione è negativa!");
        }

        if(head == null){
            throw new NoSuchElementException("Lista vuota!");
        }

        if(posizione == 0){
            T dato = head.dato;
            head = head.next;

            return dato;
        }

        Nodo<T> precedente = head;
        int i = 0;

        while(precedente.next != null && i < posizione - 1){
            precedente = precedente.next;
            ++i;
        }

        if(precedente.next == null){
            throw new IndexOutOfBoundsException("Posizione troppo grande!");
        }

        T dato = precedente.next.dato;
        precedente.next = precedente.next.next;
        return dato;
    }

    public void concatena(Lista<T> secondaLista){
        if(secondaLista == null || secondaLista.head == null){
            throw new NoSuchElementException("La seconda lista non esiste");
        }

        if(head == null){
            head = secondaLista.head;
        }

        Nodo<T> attuale = head;

        while(attuale.next != null){
            attuale = attuale.next;
        }

        attuale.next = secondaLista.head;
    }

    public String toString(){
        StringBuilder stringbuilder = new StringBuilder();

        Nodo<T> attuale = head;
        while(attuale != null){
            stringbuilder.append(attuale.dato);
            stringbuilder.append(" --- ");
            attuale = attuale.next;
        }

        stringbuilder.append("NULL");

        return stringbuilder.toString();
    }
}