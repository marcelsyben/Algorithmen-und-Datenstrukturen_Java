package Codegeeks;

import java.util.Random;

public class Testklasse {

    // Driver code
    public static void main(String[] arg)
    {

        Random r = new Random();






        int maxsize = 1000;
        MinPQ minHeap = new MinPQ(maxsize);

        for (int i = 1; i < maxsize; i++){

            String t = "test" + i;
            double randomDouble = 1 + (maxsize - 1) * r.nextDouble();
            minHeap.insert(t,randomDouble);

        }
        minHeap.minHeap();



        for (int i = 1; i < maxsize; i+=2) {
            minHeap.update(2);
        }

        System.out.println("The Min val is " + minHeap.extractElement());
    }
}



