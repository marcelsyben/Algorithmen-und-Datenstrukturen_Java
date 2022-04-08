import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        final int BUDGET = 1000;
        rucksack(BUDGET);
    }

    static public ArrayList<Integer> rucksack(int n, int a[], int w[], int G) {
        return null;
    }

    static private void rucksack(int BUDGET) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> W = new ArrayList<>();
        ArrayList<Integer> amountsVec = new ArrayList<>();
        ArrayList<Integer> bangValues = new ArrayList<>();
        HashMap<Integer, Integer> priceToItem = new HashMap<>();

        // Einlesen der Datei
        int itemIndex = 1;
        try {
            File file = new File("knaller.dat");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                int available = Integer.parseInt(scanner.next());
                int amount = Integer.parseInt(scanner.next());
                int diameter = Integer.parseInt(scanner.next());
                int price = Integer.parseInt(scanner.next());

                /*int tmp = available;
                available = amount;
                amount = available;*/

                for (int i = 1; i <= available; i++) {
                    A.add(price);
                    W.add(amount * diameter);
                    priceToItem.put(price, itemIndex);
                }
                bangValues.add(amount * diameter);
                amountsVec.add(available);
                itemIndex++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Umschreiben der Vektoren
        int a[] = new int[A.size() + 1];
        int w[] = new int[W.size() + 1];
        for (int i = 1; i <= A.size(); i++) {
            //System.out.println(A.get(i) + " Euro for " + W.get(i) + "mm");
            a[i] = A.get(i - 1);
            w[i] = W.get(i - 1);
        }

        ArrayList<Integer> backpackResult = rucksack(BUDGET, a.length - 1, a, w);

        int[] amounts = new int[15];
        int priceTotal = 0;
        int bangTotal = 0;
        for (int index : backpackResult) {
            priceTotal += a[index];
            //System.out.println(current + " + " + a[index] + " = " + (current+a[index]));
            amounts[priceToItem.get(a[index])]++;
            //System.out.println("Artikel Nr." + priceToItem.get(a[index]));
        }

        for (int i = 1; i < amounts.length; i++) {
            if (amounts[i] != 0) {
                System.out.print("Artikel Nr." + (i) + " (Zeile " + i + ") braucht man " + amounts[i] + "x ");
                System.out.println(" [noch " + amountsVec.get(i - 1) + " - " + amounts[i] + " = " +
                        (amountsVec.get(i - 1) - amounts[i]) + " über im Geschäft]");
                bangTotal += amounts[i] * bangValues.get(i-1);
            }
        }
        System.out.println("Knallstärke per Neukalkulation: " + bangTotal);
        System.out.println("\nGesamtpreis: " + priceTotal + " Euro");
    }

    private static ArrayList<Integer> rucksack(int g, int n, int[] a, int[] w) {
        int[][] W = new int[n + 1][g + 1];
        String[][] R = new String[n + 1][g + 1];
        for (int i = 0; i <= g; i++) {
            W[0][i] = 0;
            R[0][i] = "";
        }

        for (int k = 1; k <= n; k++) { // Schleife ueber die Objekte - [1;268] Objekte
            for (int j = 0; j <= g; j++) { // Schleife ueber die Kapazitaet des Rucksackes
                if (a[k] <= j && W[k - 1][j - a[k]] + w[k] > W[k - 1][j]) {
                    R[k][j] = R[k - 1][j - a[k]] + "," + k;
                    W[k][j] = W[k - 1][j - a[k]] + w[k];
                } else {
                    R[k][j] = R[k - 1][j];
                    W[k][j] = W[k - 1][j];
                }
            }
        }

        //https://programmerwiki.com/article/44756059/
        ArrayList<Integer> shoppingList = new ArrayList<>();
        int i = n;
        int j = g;
        while (i > 0) {
            if (W[i][j] != W[i - 1][j]) {
                shoppingList.add(i);
                //System.out.println("Added: " + shoppingList.get(shoppingList.size()-1));
                j -= a[i];
            }
            i--;
        }

        System.out.println("Indexliste der Knaller:" + R[n][g]);
        System.out.println("Knallstärke: " + W[n][g] + "\n");

        // Alternative mittels R[n][g]
        List<String> indexList = Arrays.asList(R[n][g].split(","));
        ArrayList<Integer> shoppingListAlternative = new ArrayList<>();
        for (int q = 1; q < indexList.size(); q++) {
            shoppingListAlternative.add(Integer.parseInt(indexList.get(q)));
        }

        return shoppingListAlternative; //shoppingListAlternative
    }
}

