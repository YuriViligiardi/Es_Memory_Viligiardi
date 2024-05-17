package it.viligiardi.service;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileManager {
    // attributes
    private static int count = 0;

    // methods and constructions
    public static String readFile() {
        int num = 0;
        try {
            FileReader fr = new FileReader("parole.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) {
                if (count == num) {
                    br.close();
                    return line;
                }
                num++;
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERRORE LETTURA");
        }
        return null;
    }
}
