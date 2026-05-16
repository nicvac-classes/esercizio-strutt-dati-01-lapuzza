//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.List;
import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {
    // Il programma parte con una chiamata a main().
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        Lista<String> guardie = new Lista<>();

        String guardia;
        int count = 1;
        do {
            System.out.print("Inserire il nome della " + count + "° guardia (inserire x per smettere di inserire): ");
            guardia = in.nextLine();

            if (!guardia.equalsIgnoreCase("x")) {
                ++count;
                guardie.aggiungiInCoda(guardia);
            }
        } while (!guardia.equalsIgnoreCase("x"));

        Pila<String> pila = new Pila<>();
        for (int i = 0; i < guardie.size(); ++i) {
            pila.push(guardie.leggiInPosizione(i));
        }

        Coda<String> autos = new Coda<>();

        String auto;
        count = 1;
        do{
            System.out.print("Inserire la " + count + "° macchina (inserire x per smettere di inserire): " );
            auto = in.nextLine();

            if(!auto.equalsIgnoreCase("x")){
                ++count;
                autos.enqueue(auto);
            }
        }while(!auto.equalsIgnoreCase("x"));

        System.out.println("Fuga in corso...");
        int numeroVeicolo = 1;

        while(!autos.isEmpty()){
            String autoDequeued = autos.dequeue();

            System.out.println("Veicolo " + numeroVeicolo + ": " + autoDequeued);

            int caricati = 0;
            System.out.print("Caricata: ");
            for(int i = 0; i < 3 && !pila.isEmpty(); ++i){
                String guardiaPop = pila.pop();
                System.out.print(guardiaPop + " ");
                ++caricati;
            }

            System.out.println();

            System.out.println("Auto parita con " + caricati + " guardie!");

            ++numeroVeicolo;
        }

        if(pila.isEmpty()){
            System.out.println("Fuga riuscita con successo!! Guardie ammanettate restanti: 0");
        }else{
            System.out.println("Fuga fallita!! Guardie ammanettate rimaste: " + pila.size());
        }
    }
}

// LEGGERE LE ISTRUZIONI NEL FILE README.md