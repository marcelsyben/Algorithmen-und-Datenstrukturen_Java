package de.hsos.aud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Konfiguration aus Ausfuehrung von Laufzeittest.
 * Aufruf der Klassen erfolgt ueber statische Methoden. 
 *
 * @author heikerli
 */
public class Call_Wrapper {
    public static void main(String[] args) {
        /* Laufzeit-Tests der PQ */
        PQTests.run();
    }
}
