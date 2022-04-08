package de.hsos.aud;

import java.lang.reflect.Array;

/**
 * Vorrangwarteschlange mit Index-Tabelle zur Zuordnung von 
 * IDs zu Indizes im Heap. Zugriff auf Element per ID damit in konstanter Zeit
 * moeglich.
 * 
 * @author heikerli
 * @param <E>  Generischer Datentyp
 */
public class PriorityQueue<E> implements PriorityQueueIf<E> {
    protected int n;          /* aktuelle Laenge */
    protected int max_size;   /* max. Laenge */

    protected int max_id = 0; /* letzte vergebene ID */
    
    protected final PQElement<E>[] a;  /* Feld zur Speicherung */
    
    public PriorityQueue (int size, PQElement<E> ... dummy) {
        max_size = size;
        n = 0;
        /* Ansonsten gibt es einen Generic Array Creation Fehler */
        if (dummy.length > 0) {
            throw new IllegalArgumentException("Falscher Datentyp.");
        }
        Class<?> c = dummy.getClass().getComponentType();
        /* Wg. der einfacheren Indexrechnung allokieren wir ein Element mehr */
        a = (PQElement<E>[]) Array.newInstance(c, size + 1);
    }
    
    protected void swap(PQElement<E> a[], int i, int j) {
        PQElement<E> h = a[i];
        a[i] = a[j];
        a[j] = h;
    }
    
    public PQElement<E> maximum() { 
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
        return null;
    }    
    
    /* Hilfsfunktion */
    protected void down_heap(PQElement<E> a[], int idx) {
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
    }

    /* Hilfsfunktion */
    protected void up_heap(PQElement<E> h[], int idx) {
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
    }
    
    public PQElement<E> extract_max()  { 
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
        return null;
    }
    
    public void insert(PQElement<E> e) { 
        if (n >= max_size ) {
            System.err.println("PriorityQueue::insert(): zu viele Elemente!");
            return;
        }
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN     
    }
    
    public void update(int id, int delta) {
        if (n < 1) {
            return;
        }
        if ((id < 1) || (id > this.max_id)) {
            System.err.println("PriorityQueue.insert(): id inkorrekt!");
            return;
        }
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
    }

    public void remove(int id) {
        if (n < 1) {
            return;
        }
        if ((id < 1) || (id > this.max_id)) {
            System.err.println("PriorityQueue.insert(): id inkorrekt!");
            return;
        }
        // ACHTUNG SCHABLONE: HIER EIGENEN CODE REALISIEREN 
    }
}
