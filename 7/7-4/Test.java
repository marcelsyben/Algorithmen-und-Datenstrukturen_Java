import java.io.IOException;

public class Test {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Rucksack rsack = new Rucksack().einlesen("knaller.dat", 14);

        int[][] test = rsack.rucksack(14, rsack.preisPaket, rsack.krachPaket, 1000);

        System.out.println(test[14][100]);
    }
}