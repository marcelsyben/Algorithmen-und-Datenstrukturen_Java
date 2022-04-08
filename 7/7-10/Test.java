import java.io.IOException;

public class Test {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Rucksack rsack = new Rucksack().einlesen("knaller.dat");


        rsack.rucksack(rsack.b.length-1, rsack.b, rsack.v, 1000);

    }
}