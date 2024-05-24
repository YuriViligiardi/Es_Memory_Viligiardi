package it.viligiardi.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {
    // attributes

    // methods and constructions
    public static ArrayList<String> readFile() {
        ArrayList<String> lw = new ArrayList<String>();
        try {
            FileReader fr = new FileReader("parole.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) {
                lw.add(line);
                line = br.readLine();
            }

            br.close();
        } catch (Exception e) {
            System.out.println("ERRORE LETTURA");
        }
        return lw;
    }
}
