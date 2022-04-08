import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rucksack {

	public int[][] auslesen(String file) throws FileNotFoundException {
		File entries = new File(file);
		Scanner scan = new Scanner(entries);
		int[][] auslese = new int[14][4];

		while (scan.hasNextLine()) {
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 4; j++) {
					if (scan.hasNextInt()) {
						auslese[i][j] = scan.nextInt();
					}
				}
			}
		}

		scan.close();
		return auslese;
	}

	public void print(String file) throws FileNotFoundException {
		int[][] tmp = auslesen(file);
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println("");
		}
	}

//	public ArrayList<Integer> rucksack(int AnzahlPakete, int gewicht[], int wert[], int kapazit�t) {
//		
//	}
}
