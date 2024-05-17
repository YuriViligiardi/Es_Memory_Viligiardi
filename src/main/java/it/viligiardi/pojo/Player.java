package it.viligiardi.pojo;

public class Player {
    // attributes
    private String name;
    private static int score = 0;
    private static int numWF = 0; // number of words found
    // methods and constructions

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        Player.score = score;
    }

    public int getNumWF() {
        return numWF;
    }

    public void setNumWF(int numWF) {
        Player.numWF = numWF;
    }

    public void setNickName(String s, int num) {
        if (s == null || s.equals("")) {
            this.name = "GIOCATORE" + num;
        } else {
            this.name = s;
        }
    }
}
