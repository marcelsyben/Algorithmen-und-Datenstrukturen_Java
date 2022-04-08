package com.company;


import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void sortieren(int[] arr, int anfang, int ende) {

        int index = partition(arr, anfang, ende);

        //mit if checken ob weitere Teilung möglich ist

        sortieren(arr, anfang, index-1);
        sortieren(arr, index+1, ende);

        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int anfang, int ende) {

        int index = arr[ende];
        int i = anfang -1;

        for (int j = anfang; j < ende; j++) {

            if (arr[j] <= index) {
                i++;

                int speicher = arr[i];
                arr[i] = arr[j];
                arr[j] = speicher;
            }

            int speicher = arr[i+1];
            arr[i+1] = arr[ende];
            arr[ende] = speicher;



        }
       return i+1;
    }

    public static void main(String[] args) throws IOException {

        //Hier Dateiname angeben:
        String datei = "test.txt";


        Scanner scan = new Scanner(new File(datei));

        BufferedReader groesse = new BufferedReader(new FileReader(datei));
        int anzahlZeilen = 0;

        while (groesse.readLine() != null) anzahlZeilen++;
        groesse.close();


        //Zeilen richtig gezaehlt?
        //System.out.println(anzahlZeilen);

        int[] arr = new int[anzahlZeilen+1];


        for (int i = 0; i < anzahlZeilen; i++) {

            arr[i] = scan.nextInt();
        }

        //Ints im Array?
        //System.out.println(Arrays.toString(arr));

        long zeit1 = System.currentTimeMillis();

        sortieren(arr, 1, anzahlZeilen);

        long zeit2 = System.currentTimeMillis();

        long laufzeit = zeit2 - zeit1;
        System.out.println(laufzeit);

    }


}





