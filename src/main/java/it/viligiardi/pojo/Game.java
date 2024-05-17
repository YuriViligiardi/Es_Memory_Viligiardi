package it.viligiardi.pojo;

import it.viligiardi.service.FileManager;

public class Game {
    // attributes
    public static Field f = new Field();
    public static Player p1 = new Player("");
    public static Player p2 = new Player("");
    // methods and constructions

    public static void populateField() {
        for (int i = 0; i < f.getDim(); i++) {
            for (int j = 0; j < f.getDim(); j++) {
                String s = FileManager.readFile();
                if (!s.equals(null)) {
                    f.getMatrix()[i][j] = s;
                } else {
                    System.out.println("FINITO DI POPOLARE IL CAMPO");
                    break;
                }
            }
        }
    }

    public static boolean isFoundWord(String s, String s1) {
        if (s.equals(s1)) {
            return true;
        } else {
            return false;
        }
    }

    //public static boolean isVictory() {}
}
