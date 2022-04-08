package Jannik2;

import java.util.Random;

public class Testclass {
	// Testclass mit Hilfe von Kommilitone Patrick Hohn erstellt
	public static void main (String[] args)
		{
			
			MinPQ minheap = new MinPQ(10);
			
			for(int i=0;i<10;i++) {
				minheap.insert(i + ".", zufallsDouble());	
			}
			System.out.println(minheap);	
			
			for(int i=0;i<10;) {
				minheap.update("5", 5.55);
				i = i + 2;
			}




			System.out.println(minheap);
		}
	
	
	public static double zufallsDouble() {  //https://stackoverflow.com/questions/3680637/generate-a-random-double-in-a-range/3680648
        Random r = new Random();
        double rangeMin = 1.0;
        double rangeMax = 10.0;
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        return randomValue;
    }

}