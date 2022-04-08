package de.hsos.aud;

/**
 * Vorrangwarteschlange mit Index-Tabelle zur Zuordnung von 
 * IDs zu Indizes im Heap. Zugriff auf Element damit in konstanter Zeit
 * moeglich.
 * 
 * @author heikerli
 * @param <E>  Generischer Datentyp
 */
final public class PriorityQueueIndexed<E> extends PriorityQueue<E> {
    // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
 
    public PriorityQueueIndexed (int len, PQElement<E> ... dummy) {
        super (len, dummy);
        /* IDs beginnen bei 1, also array [1,....,n] */
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
    }
    
    @Override
    public void swap(PQElement<E> a[], int i, int j) {
        PQElement<E> h = a[i]; 
        a[i] = a[j];
        a[j] = h;
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
    }
   
    @Override
    public PQElement<E> extract_max()  { 
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
        return null;
    }
    
    @Override
    public void insert (PQElement<E> e) { 
        if (n >= max_size ) {
            System.err.println("PriorityQueueIndexed.insert(): zu viele Elemente!");
            return;
        }
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN     
    }
    
    @Override
    public void update(int id, int delta) {
        if (n < 1) {
            return;
        }
        if ((id < 1) || (id > this.max_id)) {
            System.err.println("PriorityQueueIndexed.remove(): id inkorrekt!");
            return;
        }
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
    }

    @Override
    public void remove(int id) {
        if (n < 1) {
            return;
        }
        if ((id < 1) || (id > this.max_id)) {
            System.err.println("PriorityQueueIndexed.remove(): id inkorrekt!");
            return;
        }
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
    }
}

