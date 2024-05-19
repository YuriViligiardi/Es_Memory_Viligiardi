package it.viligiardi.pojo;

public class Player {
    // attributes
    private String name;
    private static Integer score = 0;
    private static Integer numWF = 0; // number of words found
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        Player.score = score;
    }

    public Integer getNumWF() {
        return numWF;
    }

    public void setNumWF(Integer numWF) {
        Player.numWF = numWF;
    }

    /**
     * funzione di controllo/settare il nome dei giocatori
     * 
     * @param s   nome del giocatore inserito dall'utente
     * @param num numero del giocatore (1 or 2)
     */
    public void setNickName(String s, int num) {
        if (s == null || s.equals("")) {
            this.name = "GIOCATORE" + num;
        } else {
            this.name = s;
        }
    }
}
