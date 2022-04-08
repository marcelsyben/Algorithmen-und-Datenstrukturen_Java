import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
class Rucksack {

    int[] anzahlPakete, anzahlKnaller, durchmesserKnaller, preisPaket, krachPaket;

    int[][] W;

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

    public int[][] rucksack(int n, int a[], int w[], int G) {

        W = new int[n + 1][G + 1];

        ArrayList<Integer> list = new ArrayList<Integer>();

        

        for (int j = 0; j <= G; j++) {
            W[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= G; j++) {
                if (w[i - 1] > j) {
                    W[i][j] = W[i - 1][j];
                } else {
                    W[i][j] = Math.max(W[i - 1][j], W[i - 1][j - w[i - 1]] + a[i - 1]);
                }
                //list.add(i, W[i][j]);
            }
        }
        return W;
    }


}


// Anzahl der noch vorhandenen Pakete - Anzahl Knaller pro Paket - Durchmesser eines Knallers - Preis pro Paket

// mm Durchmesser * Anzahl der Knaller im Päckchen = wert

//
// G = maximaler Preis
// a[] = Preis pro Paket
// w[] = Krach pro Paket
// n = Anzahl verschiedener Pakete