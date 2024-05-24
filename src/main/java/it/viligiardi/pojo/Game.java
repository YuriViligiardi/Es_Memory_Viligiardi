package it.viligiardi.pojo;

import java.util.ArrayList;

import it.viligiardi.service.FileManager;

public class Game {
    // attributes
    public static Field f = new Field();
    public static Player p1 = new Player("");
    public static Player p2 = new Player("");
    // methods and constructions

    public static void populateField() {
        ArrayList<String> lw = FileManager.readFile();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {

                int x, y;

                do {
                    x = (int) (Math.random() * 4); // da 0 a 3
                    y = (int) (Math.random() * 4);
                } while (f.getMatrix()[x][y] != null);

                if (lw.get(j) != null) {
                    f.getMatrix()[x][y] = lw.get(j);
                }
            }
        }
        System.out.println("FINITO DI POPOLARE IL CAMPO");
    }

    public static String showWord(Integer x, Integer y) {
        String s = f.getMatrix()[x][y];
        return s;
    }

    public static boolean isFoundWord(String s, String s1) {
        if (s.equals(s1)) {
            Game.disableWord(s);
            Game.disableWord(s1);
            return true;
        } else {
            return false;
        }
    }

    public static void disableWord(String s) {
        for (int i = 0; i < f.getDim(); i++) {
            for (int j = 0; j < f.getDim(); j++) {
                if (f.getMatrix()[i][j].equals(s)) {
                    f.getMatrix()[i][j] = "X";
                }
            }
        }
    }

    public static boolean isVictory() {
        for (int i = 0; i < f.getDim(); i++) {
            for (int j = 0; j < f.getDim(); j++) {
                if (!f.getMatrix()[i][j].equals("X")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Object won() {
        if (Game.p1.getNumWF() > Game.p2.getNumWF()) {
            return Game.p1;
        } else if (Game.p2.getNumWF() > Game.p1.getNumWF()) {
            return Game.p2;
        } else {
            return null;
        }
    }

    public static void resetField() {
        populateField();
    }

    // per il controllo
    public static void printMatrix() {
        for (int i = 0; i < f.getDim(); i++) {
            System.out.println(" ");
            for (int j = 0; j < f.getDim(); j++) {
                System.out.print(f.getMatrix()[i][j] + "| ");
            }
        }
    }
}
