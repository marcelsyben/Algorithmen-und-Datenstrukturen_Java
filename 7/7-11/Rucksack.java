import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    //https://www.geeksforgeeks.org/printing-items-01-knapsack/
    public ArrayList<Integer> rucksack(int n, int wt[], int val[], int W) {

        int i, w; 
        int K[][] = new int[n + 1][W + 1]; 
  
        // Build table K[][] in bottom up manner 
        for (i = 0; i <= n; i++) { 
            for (w = 0; w <= W; w++) { 
                if (i == 0 || w == 0) 
                    K[i][w] = 0; 
                else if (wt[i - 1] <= w) 
                    K[i][w] = Math.max(val[i - 1] +  
                              K[i - 1][w - wt[i - 1]], K[i - 1][w]); 
                else
                    K[i][w] = K[i - 1][w]; 
            } 
        } 
  
        // stores the result of Knapsack 
        int res = K[n][W]; 
        System.out.println("Gesamtkrach: " + res); 

        ArrayList<Integer> artikel = new ArrayList<Integer>();
  
        w = W; 
        for (i = n; i > 0 && res > 0; i--) { 
  
            // either the result comes from the top 
            // (K[i-1][w]) or from (val[i-1] + K[i-1] 
            // [w-wt[i-1]]) as in Knapsack table. If 
            // it comes from the latter one/ it means 
            // the item is included. 
            if (res == K[i - 1][w]) 
                continue; 
            else { 
  
                // This item is included. 
                System.out.print(wt[i - 1] + " "); 
                
                artikel.add(preisProItem.get(wt[i-1]));



                // Since this weight is included its 
                // value is deducted 
                res = res - val[i - 1]; 
                w = w - wt[i - 1]; 
            } 

        }   

        System.out.println("\n");

        int counter[] = new int[14];

        for (int q : artikel) {
            counter[q]++;
        }

        for (int q=0; q < counter.length; q++) {
            if (counter[q] != 0)
            System.out.println(counter[q] + "x Artikel " + q);
        }

        


        return null;
    }

}


// Anzahl der noch vorhandenen Pakete - Anzahl Knaller pro Paket - Durchmesser eines Knallers - Preis pro Paket

// mm Durchmesser * Anzahl der Knaller im Päckchen = wert

//
// G = maximaler Preis
// a[] = Preis pro Paket
// w[] = Krach pro Paket
// n = Anzahl verschiedener Pakete