import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
class Rucksack {

    ArrayList<Integer> A = new ArrayList<>();
    ArrayList<Integer> W = new ArrayList<>();
    ArrayList<Integer> allePakete = new ArrayList<>();
    ArrayList<Integer> krachPaket = new ArrayList<>();
    HashMap<Integer, Integer> preisProItem = new HashMap<>();

    int b[];
    int v[];

    public Rucksack einlesen(String file) throws FileNotFoundException {


        int itemIndex = 1;

        File entries = new File(file);
        Scanner scan = new Scanner(entries);
        while (scan.hasNextInt()) {
            int anzahlPakete = scan.nextInt();
            int anzahlKnaller = scan.nextInt();
            int durchmesserKnaller = scan.nextInt();
            int preisPaket = scan.nextInt();

            for (int i = 1; i <= anzahlPakete; i++) {
                A.add(preisPaket);
                W.add(anzahlKnaller * durchmesserKnaller);
                preisProItem.put(preisPaket, itemIndex);
            }
            krachPaket.add(anzahlKnaller * durchmesserKnaller);
            allePakete.add(anzahlPakete);
            itemIndex++;
        }
        scan.close();

        
        int a[] = new int[A.size() + 1];
        int w[] = new int[W.size() + 1];
        for (int i = 1; i <= A.size(); i++) {

            a[i] = A.get(i - 1);
            w[i] = W.get(i - 1);
        }

        b = a;
        v = w;
        return this;
    }

    public ArrayList<Integer> rucksack(int n, int a[], int w[], int G) {
        int[][] W = new int[n + 1][G + 1];
        String[][] R = new String[n + 1][G + 1];
        for (int i = 0; i <= G; i++) {
            W[0][i] = 0;
            R[0][i] = "";
        }

        for (int k = 1; k <= n; k++) {
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

        System.out.println("Alle Pakete:" + R[n][G] + "\n");


        List<String> liste = Arrays.asList(R[n][G].split(","));
        ArrayList<Integer> einkaufsliste = new ArrayList<>();
        for (int q = 1; q < liste.size(); q++) {
            einkaufsliste.add(Integer.parseInt(liste.get(q)));
        }


        int anzahl[] = new int[15];
        int gesamtKrach = 0;
        int gesamtPreis = 0;
        for (int index : einkaufsliste) {
            gesamtPreis += a[index];
            anzahl[preisProItem.get(a[index])]++;
        }

        for (int i = 1; i < anzahl.length; i++) {
            if (anzahl[i] != 0) {
                System.out.println(anzahl[i] + "x Artikel " + i);
                gesamtKrach += anzahl[i] * krachPaket.get(i - 1);
            }
        }
        System.out.println("\nGesamtpreis: " + gesamtPreis + "€");
        System.out.println("Gesamtkrach: " + gesamtKrach);

        return einkaufsliste; 



    }

}


// Anzahl der noch vorhandenen Pakete - Anzahl Knaller pro Paket - Durchmesser eines Knallers - Preis pro Paket

// mm Durchmesser * Anzahl der Knaller im Päckchen = wert

//
// G = maximaler Preis
// a[] = Preis pro Paket
// w[] = Krach pro Paket
// n = Anzahl verschiedener Pakete