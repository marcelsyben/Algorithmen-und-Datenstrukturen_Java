import java.io.FileNotFoundException;

public class test {
	
	public static void main(String[] args) {
		
		Rucksack bag = new Rucksack();
		
		try {
			bag.print("knaller.dat");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
