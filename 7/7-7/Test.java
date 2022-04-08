import java.io.IOException;

public class Test {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Rucksack rsack = new Rucksack().einlesen("knaller.dat", 14);

        rsack.rucksack(rsack.A.size(), rsack.a, rsack.w, 1000);


    }
}