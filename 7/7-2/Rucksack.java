import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
class Rucksack {

    int[] anzahlPakete, anzahlKnaller, durchmesserKnaller, preisPaket, krachPaket;

    int[][] m;

    public Rucksack einlesen(String file, int anzahl) throws FileNotFoundException {
        File entries = new File(file);
        Scanner scan = new Scanner(entries);

        anzahlPakete = new int[anzahl];
        anzahlKnaller = new int[anzahl];
        durchmesserKnaller = new int[anzahl];
        preisPaket = new int[anzahl];
        krachPaket = new int[anzahl];

        for (int i = 0; scan.hasNextLine(); i++) {
            if (!scan.hasNextInt())
                break;
            anzahlPakete[i] = scan.nextInt();
            anzahlKnaller[i] = scan.nextInt();
            durchmesserKnaller[i] = scan.nextInt();
            preisPaket[i] = scan.nextInt();
        }
        scan.close();

        for (int i = 0; i < anzahl; i++) {
            krachPaket[i] = anzahlKnaller[i] * durchmesserKnaller[i];
        }

        return this;
    }

    public int[][] rucksack(int n, int a[], int w[], int G) throws NumberFormatException, IOException {
        /*
         * int[][] W = new int[n][G]; int[][] R = new int[n][G];
         * 
         * 
         * for (int k=1;k<n;k++) { for (int j=0;j<G;j++) { if (a[k] <= j &&
         * W[k-1][j-a[k]] + w[k] > W[k-1][j]) { R[k][j] = R[k-1][j-a[k]]; //oder k?
         * W[k][j] = W[k-1][j-a[k]] + w[k]; } else { R[k][j] = R[k-1][j]; W[k][j] =
         * W[k-1][j]; } } }
         * 
         * 
         * return R[n][G];
         */

        m = new int[n + 1][G + 1];

        for (int j = 0; j <= G; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= G; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i - 1]] + a[i - 1]);
                }
            }
        }
        return m;
    }


}


// Anzahl der noch vorhandenen Pakete - Anzahl Knaller pro Paket - Durchmesser
// eines Knallers - Preis pro Paket

// mm Durchmesser * Anzahl der Knaller im Päckchen = wert

