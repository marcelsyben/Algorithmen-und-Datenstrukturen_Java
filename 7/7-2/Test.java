import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class Test {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Rucksack rsack = new Rucksack().einlesen("knaller.dat", 14);

        //System.out.println(rsack.rucksack(14, rsack.preisPaket, rsack.krachPaket, 1000));

    



//Die CSV Ausgabe, dafür muss man die opencsv.jar ins Projekt integrieren

    exportDataToExcel("test.csv",rsack.rucksack(14, rsack.preisPaket, rsack.krachPaket, 1000));
}

public static void exportDataToExcel(String fileName, int[][] data) throws FileNotFoundException, IOException
{
    File file = new File(fileName);
    if (!file.isFile())
        file.createNewFile();

    CSVWriter csvWriter = new CSVWriter(new FileWriter(file));

    int rowCount = data.length;

    for (int i = 0; i < rowCount; i++)
    {
        int columnCount = data[i].length;
        String[] values = new String[columnCount];
        for (int j = 0; j < columnCount; j++)
        {
            values[j] = data[i][j] + "";
        }
        csvWriter.writeNext(values);
    }

    csvWriter.flush();
    csvWriter.close();
}
}