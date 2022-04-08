package Jannik;

import java.util.Random;

public class Testclass {
	// Testclass mit Hilfe von Kommilitone Patrick Hohn erstellt
	public static void main (String[] args)
		{
			
			MinPQ minheap = new MinPQ(1000);
			
			for(int i=0;i<1000;i++) {
				minheap.insert(i + ".", zufallsDouble());	
			}
			System.out.println(minheap);
			
			for(int i=0;i<1000;i++) {
				minheap.update();	
			}
			
			for(int i=0;i<1000;i++) {
				
			minheap.extractElement();	
			}
			System.out.println(minheap);
		}
	
	
	public static double zufallsDouble() {  //https://stackoverflow.com/questions/3680637/generate-a-random-double-in-a-range/3680648
        Random r = new Random();
        double rangeMin = 1.0;
        double rangeMax = 1000.0;
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        return randomValue;
    }
			
}