import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
class Rucksack {

    int[] anzahlPakete, anzahlKnaller, durchmesserKnaller, preisPaket, krachPaket;
    int[] preisPaketMehrzahl, krachPaketMehrzahl;

    int[][] W;
    String[][] R;

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

        
        for (int i = 0; i<anzahl; i++) {
            for (int j=0; j<anzahlPakete[i];j++) {
                
            }
        }

        return this;
    }

    public ArrayList<Integer> rucksack(int n, int a[], int w[], int G) {

        W = new int[n + 1][G + 1];
        R = new String[n+1][G+1];

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int j = 0; j <= G; j++) {
            W[0][j] = 0;
            R[0][j] = "";
        }

        for (int k = 1; k <= n; k++) { // Schleife ueber die Objekte - [1;268] Objekte
            for (int j = 0; j <= G; j++) { // Schleife ueber die Kapazitaet des Rucksackes
                if (a[k] <= j && W[k - 1][j - a[k]] + w[k] > W[k - 1][j]) {
                    R[k][j] = R[k - 1][j - a[k]] + "," + k;
                    W[k][j] = W[k - 1][j - a[k]] + w[k];
                } else {
                    R[k][j] = R[k - 1][j];
                    W[k][j] = W[k - 1][j];
                }
            }
        }
    } 

}


// Anzahl der noch vorhandenen Pakete - Anzahl Knaller pro Paket - Durchmesser eines Knallers - Preis pro Paket

// mm Durchmesser * Anzahl der Knaller im Päckchen = wert

//
// G = maximaler Preis
// a[] = Preis pro Paket
// w[] = Krach pro Paket
// n = Anzahl verschiedener Pakete