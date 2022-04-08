package de.hsos.aud;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Random;

/**
 * Test der Heap-Funktionen.
 * @author heikerli
 */
public class PQTests {
    final static int[] TEST_SIZES_1 = {10000, 50000, 100000, 500000, 
        1000000, 2000000, 3000000, 4000000,
        5000000, 6000000};
    
    final static int[] TEST_SIZES_2 = {20000, 30000, 40000, 50000, 
        60000, 70000, 80000, 90000,
        100000, 110000, 120000 };    
    
    /**
     * Test der Priority Queue.
     * Laufzeiten werden ermittelt und ausgegeben.
     * Ausserdem wird die Sortierung ueberprueft.
     * @param size Groesse der zu sortierenden Sequenz 
     */
    public static void run_pq_test (int size) {
        /* Zufaellige Sequenz erzeugen */
        Sequence seq = new Sequence(size);
        seq.permute (2*size);
        
        /* Zeitmessung starten */
        ThreadMXBean thb = ManagementFactory.getThreadMXBean();
        long start_usr = System.currentTimeMillis();
        long start_cpu = thb.getCurrentThreadCpuTime();

        /* Elemente in PQ eintragen */
        PriorityQueue<Integer> pq = new PriorityQueue(seq.n);
        for (int i = 1; i <= seq.n; i++) {
            PQElement<Integer> e = new PQElement (i, i);
            pq.insert (e);
        }
        
        /* Elemente der Reihe nach Entnehmen */
        PQElement<Integer> e; 
        int i = seq.n;
        while ((e = pq.extract_max()) != null) {
            seq.a[i--] = (int) e.priority();
        }
        
        long end_usr = System.currentTimeMillis();
        long end_cpu = thb.getCurrentThreadCpuTime();

        long time_usr = end_usr - start_usr;
        long time_cpu = end_cpu - start_cpu;

        if (!seq.check_sorted()) {
            System.err.println("Datei ist nicht sortiert.");
        }
        
        /* Datei mit sortierten Schlüsseln speichern */
        // seq.backup ("seq_" +  size + ".txt", "");
        
        System.out.println("size = " + size + " ("
                + "user time = " + time_usr
                + " ms, cpu time = " + time_cpu / 1000000 + " ms)");
    }
    
     /**
     * Test der Priority Queue fuer update() / remove().
     * Laufzeiten werden ermittelt und ausgegeben.
     * @param pq Testobjekt
     */
    public static void run_pq_update_remove_test (PriorityQueue<Integer> pq) {
        /* Zufaellige Sequenz erzeugen */
        Sequence seq = new Sequence(pq.max_size);
        seq.permute (2 * seq.n);
        
        /* Elemente in PQ eintragen: Zeit wird nicht gemessen */
        for (int i = 1; i <= seq.n; i++) {
            PQElement<Integer> e = new PQElement (i, i);
            pq.insert (e);
        }
        
        /* Zeitmessung starten */
        ThreadMXBean thb = ManagementFactory.getThreadMXBean();
        long start_usr = System.currentTimeMillis();
        long start_cpu = thb.getCurrentThreadCpuTime();

        /* Elemente der Reihe nach Entnehmen */
        Random rand = new Random();        
        for (int i = 1; i <= seq.n; i++) {
            if (i % 2 == 0) {
                pq.remove(i);
            } else {
                int j = Math.abs(rand.nextInt()) % seq.n; 
                j++;
                pq.update(i, j / 2);
            }
        }
        
        long end_usr = System.currentTimeMillis();
        long end_cpu = thb.getCurrentThreadCpuTime();

        long time_usr = end_usr - start_usr;
        long time_cpu = end_cpu - start_cpu;

        System.out.println("max size = " + pq.max_size + " ("
                + "user time = " + time_usr
                + " ms, cpu time = " + time_cpu / 1000000 + " ms)");
    }
    
    public static void run() {
        System.out.println("Test der PQ von insert/extract_max :");
        for (int i : TEST_SIZES_1) {
            run_pq_test(i);
        }

        System.out.println("Test der PQ von update/remove mit sequentieller Suche:");
        for (int i : TEST_SIZES_2) {
            /* Ggf. ein- / auskommentieren */
            PriorityQueue<Integer> pq = new PriorityQueue(i);
            run_pq_update_remove_test(pq);
        }

        System.out.println("Test der PQ von update/remove der PQ mit Index-Tabelle:");
        for (int i : TEST_SIZES_2) {
            /* Ggf. ein- / auskommentieren */
            PriorityQueueIndexed<Integer> pq = new PriorityQueueIndexed(i);
            run_pq_update_remove_test(pq);
        }
    }
}
