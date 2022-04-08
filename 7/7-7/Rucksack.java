import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Rucksack {

    ArrayList<Integer> A = new ArrayList<Integer>();
    ArrayList<Integer> W = new ArrayList<Integer>();

    
    int[] a;
    int[] w;


    public Rucksack einlesen(String file, int anzahl) throws FileNotFoundException {
        File entries = new File(file);
        Scanner scan = new Scanner(entries);


        while (scan.hasNextInt()) {
            int anzahlPakete = scan.nextInt();
            int anzahlKnaller = scan.nextInt();
            int durchmesserKnaller = scan.nextInt();
            int preisPaket = scan.nextInt();

            for (int i = 0; i < anzahlPakete; i++) {
                A.add(preisPaket);
                W.add(durchmesserKnaller*anzahlKnaller);
            }
        }
        a = new int[A.size()];
        w = new int[W.size()];

        for (int i = 0; i < A.size();i++) {
            a[i] = A.get(i);
            w[i] = W.get(i);
        }

        scan.close();
        return this;
    }

    public ArrayList<Integer> rucksack(int n, int a[], int w[], int G) {
        
        int[][] W = new int[n + 1][G + 1];
        String[][] R = new String[n + 1][G + 1];
        for (int i = 0; i <= G; i++) {
            W[0][i] = 0;
            R[0][i] = "";
        }

        for (int k = 1; k <= n-1; k++) {
            for (int j = 0; j <= G; j++) {
                if (a[k] <= j && W[k - 1][j - a[k]] + w[k] > W[k - 1][j]) {
                    R[k][j] = R[k - 1][j - a[k]] + "," + k;
                    W[k][j] = W[k - 1][j - a[k]] + w[k];
                } else {
                    R[k][j] = R[k - 1][j];
                    W[k][j] = W[k - 1][j];
                }
            }
        }
        
        return null;
    }


}

// Anzahl der noch vorhandenen Pakete - Anzahl Knaller pro Paket - Durchmesser
// eines Knallers - Preis pro Paket

// mm Durchmesser * Anzahl der Knaller im Päckchen = wert

//
// G = maximaler Preis
// a[] = Preis pro Paket
// w[] = Krach pro Paket
// n = Anzahl verschiedener Pakete