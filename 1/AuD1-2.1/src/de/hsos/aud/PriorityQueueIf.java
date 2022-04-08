package de.hsos.aud;

/**
 * Schnittstelle der Vorrangwarteschlange.
 * 
 * @author heikerli
 * @param <E>  Generischer Datentyp
 */
public interface PriorityQueueIf<E> {

    public PQElement<E> maximum();

    public PQElement<E> extract_max();

    public void insert(PQElement<E> e);
}
