import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Rucksackproblem {
	
	static HashMap<Integer, Integer> zeileArtikel = new HashMap<>();
	
	public static void main(String[] args) throws FileNotFoundException {
        print();
    }
	
	public static void print() throws FileNotFoundException {
		ArrayList<Integer> backpackResult = rucksack(1000, 268 - 1, preisPaket(), krach());

        int[] amounts = new int[15];
        int priceTotal = 0;
        int bangTotal = 0;
        for (int index : backpackResult) {
            priceTotal += preisPaket()[index];
            amounts[zeileArtikel.get(preisPaket()[index])]++;
        }

        for (int i = 1; i < amounts.length; i++) {
            if (amounts[i] != 0) {
				//System.out.print("Artikel Nr." + (i) + ") braucht man " + amounts[i] + "x ");
				System.out.println(amounts[i] + "x Artikel Nr." + i);
                bangTotal += amounts[i] * krach()[i-1];
            }
        }
        System.out.println("Knallst�rke per Neukalkulation: " + bangTotal);
        System.out.println("\nGesamtpreis: " + priceTotal + " Euro");
    }
	
	public static int[][] auslesen(String file) throws FileNotFoundException {
		File entries = new File(file);
		Scanner scan = new Scanner(entries);
		int[][] auslese = new int[14][4];
		int zeile = 1;

		while (scan.hasNext()) {
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 4; j++) {
					if (scan.hasNextInt()) {
						auslese[i][j] = scan.nextInt();
					}
				}
				zeileArtikel.put(auslese[i][3],zeile);
				zeile++;
			}
		}

		int[][] fertig = new int[14][3];
		for (int i = 0; i < 14; i++) {
			fertig[i][0] = auslese[i][0];
			fertig[i][1] = auslese[i][1] * auslese[i][2];
			fertig[i][2] = auslese[i][3];
		}
		scan.close();
		return fertig;
	}
	
	public static int[] krach() throws FileNotFoundException {
		int[][] tmp = auslesen("knaller.dat");
		int[] krach = new int[268];
		int current = 0;
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < tmp[i][0]; j++) {
				krach[current] = tmp[i][1];
				current = current + 1;
			}
		}

		return krach;
	}
	
	public static int[] preisPaket() throws FileNotFoundException {
		int[][] tmp = auslesen("knaller.dat");
		int[] preise = new int[268];
		int current = 0;
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < tmp[i][0]; j++) {
				preise[current] = tmp[i][2];
				current = current + 1;
			}

		}
		return preise;
	}
	
	private static ArrayList<Integer> rucksack(int g, int n, int[] a, int[] w) {
        int[][] W = new int[n + 1][g + 1];
        String[][] R = new String[n + 1][g + 1];
        for (int i = 0; i <= g; i++) {
            W[0][i] = 0;
            R[0][i] = "";
        }

        for (int k = 1; k <= n; k++) { 
            for (int j = 0; j <= g; j++) {
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
        System.out.println("Knallst�rke: " + W[n][g] + "\n");

        // Alternative mittels R[n][g]
        List<String> indexList = Arrays.asList(R[n][g].split(","));
        ArrayList<Integer> shoppingListAlternative = new ArrayList<>();
        for (int q = 1; q < indexList.size(); q++) {
            shoppingListAlternative.add(Integer.parseInt(indexList.get(q)));
        }

        return shoppingListAlternative; //shoppingListAlternative
    }
	
	public static int[] anzahl() throws FileNotFoundException {
		int[][] tmp = auslesen("knaller.dat");
		int[] anzahl = new int[268];
		int current = 0;
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < tmp[i][0]; j++) {
				anzahl[current] = tmp[i][0];
				current = current + 1;
			}
		}

		return anzahl;
	}
}
