import java.io.IOException;

public class Test {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Rucksack rsack = new Rucksack().einlesen("knaller.dat", 14);
        System.out.println(rsack.rucksack(14, rsack.preisPaket, rsack.krachPaket, 1000));
    }
}