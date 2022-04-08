package de.hsos.aud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Basisklasse zur Verwaltung eines Feldes von zu sortierenden Objekten.
 * 
 * @author heikerli
 */
public class Sequence {
    public int n = 16;
    public int a[];
      
    public Sequence(int size) {
        n = size;
        a = new int [n+1];
        a[0] = n; /* speichert Laenge */
        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }
    }
    
    /**
     * Ctor. 
     * Generiert Sequence aus dem Inhalt einer Datei.
     * @param fileName Datei mit zu sortierenden Daten. 
     */
    public Sequence(String fileName) {
        /* Sequenz für Datei 'fileName' anlegen */
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
            BufferedReader in = new BufferedReader(fr);
            String line;
            /* Anzahl Elemente einlesen */
            if ((line = in.readLine()) == null) {
                System.err.println("Datei '" + fileName + "' falsch formatiert.");
            }
            if ((n = Integer.parseInt(line)) <= 1) {
                System.err.println("Datei '" + fileName + "' falsch formatiert.");
            }
            /* Feld erzeugen */
            a = new int[n + 1];
            a[0] = n;
            /* Feld fuellen: es werden nur n Zeilen gelesen */
            for (int i = 1; i <= n; i++) {
                line = in.readLine();
                int val = Integer.parseInt(line);
                a[i] = val;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Datei '" + fileName + "' nicht gefunden.");
        } catch (IOException ex) {
            System.out.println("Fehler beim Lesen von '" + fileName + "'.");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception ex) {
            }
        }
    }
    
    /**
     * Test, ob Sequenz sortiert ist.
     * @return true falls Sortierung vorliegt.
     */
    public boolean check_sorted () {
        for (int i = 2; i <= n; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    public void swap(int i, int j) {
        int h = a[i]; a[i] = a[j]; a[j] = h;
    }

    /**
     * Speichern der Sequenz in einer Datei.
     * @param fname     Name der Datei
     * @param postfix   Wird in Dateinamen vor der Dateiendung eingefuegt
     */
    public void backup(String fname, String postfix) {
        int ext_idx = fname.lastIndexOf("."); 

        String newFName = fname.substring(0, ext_idx);
        newFName = newFName.concat (postfix);
        newFName = newFName.concat (fname.substring (ext_idx, fname.length()));
  
        PrintWriter out = null;
        try {
            out = new PrintWriter(newFName);
            out.println (n);
            for (int i = 1; i <= n; i++) {
                out.println (a[i]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (out != null){
                out.flush();
                out.close();
            }
        } 
        System.out.println ("Sequenz unter: " + newFName + " gespeichert.");
    }
    
    public void print() {
        /* toString() ist Java-spezifisch */
        for (int i = 1; i <= n; i++) {
            System.out.print (a[i] + " ");
        }
        System.out.print ("\n");
    }
    
    /**
     * Permutierung einer Sequenz. 
     * @param rounds Anzahl der Runden zur Permutierung
     */
    public void permute(int rounds) {
        Random rand = new Random();
        int i = 1;
        for (int r = 0; r < rounds; r++) {
            /* Felder beginnen bei 1 und enden bei n, deshalb ... */
            i %= n; // Math.abs(rand.nextInt()) % n; 
            i++;
            int j = Math.abs(rand.nextInt()) % n; 
            j++;
            this.swap(i, j);
        }
    } 
}
