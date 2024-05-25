package it.viligiardi.pojo;

import java.util.ArrayList;

import it.viligiardi.service.FileManager;

public class Game {
    // attributes
    public static Field f = new Field();
    public static Player p1 = new Player("", "P1");
    public static Player p2 = new Player("", "P2");
    public static ArrayList<String> lw = FileManager.readFile();
    // methods and constructions

    public static void populateField() {

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

    public static boolean isFoundWord(String s, String s1, Player p) {
        if (s.equals(s1)) {
            Game.disableWord(s, p);
            Game.disableWord(s1, p);
            return true;
        } else {
            return false;
        }
    }

    public static void disableWord(String s, Player p) {
        for (int i = 0; i < f.getDim(); i++) {
            for (int j = 0; j < f.getDim(); j++) {
                if (f.getMatrix()[i][j].equals(s)) {
                    f.getMatrix()[i][j] = p.getSymbol();
                }
            }
        }
    }

    public static boolean isVictory() {
        for (int i = 0; i < f.getDim(); i++) {
            for (int j = 0; j < f.getDim(); j++) {
                for (String s : lw) {
                    if (f.getMatrix()[i][j] == s) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Object controllWon(int n) {
        if (n == 8) {
            return null;
        } else if (n > 8) {
            return p1;
        } else {
            return p2;
        }
    }

    public static Object whoWon(Player p1, Player p2) {
        int num = 0;
        for (int i = 0; i < f.getDim(); i++) {
            for (int j = 0; j < f.getDim(); j++) {
                if (f.getMatrix()[i][j].equals(p1.getSymbol())) {
                    num++;
                }
            }
        }
        return controllWon(num);
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
