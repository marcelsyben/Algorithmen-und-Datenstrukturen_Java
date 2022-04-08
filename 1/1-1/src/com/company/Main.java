package com.company;

import java.io.IOException;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main {


    public static void main(String[] args) {


        File datei = new File("randomZahlen.txt");

        try {
            FileWriter writer = new FileWriter(datei.getName());
            BufferedWriter bw = new BufferedWriter(writer);
            Random zufall = new Random();

//          Groesse der Zahlen
            int zufallsZahlen = 5000000;


            for (int i = 0; i < 5000000; i++) {


                int z = zufall.nextInt(zufallsZahlen);
                System.out.println(zufall);
                bw.write(Integer.toString(z));
                bw.newLine();

            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//        Random zufall = new Random();
//
//        int[] arr = new int[1000];
//        BufferedWriter buff = new BufferedWriter(new FileWriter("randomZahlen.txt"));
//        for (int i = 0; i < arr.length; i++) {
//
//            arr[i] = zufall.nextInt(1000);
//            buff.write(Integer.toString(arr[i]));
//            buff.newLine();

//        }
//
//
//
//
//    }
//
//}