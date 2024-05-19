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
}
