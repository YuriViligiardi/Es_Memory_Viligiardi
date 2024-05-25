package it.viligiardi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.viligiardi.pojo.Game;
import it.viligiardi.pojo.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GameController implements Initializable {
    @FXML
    private GridPane gpScore;
    @FXML
    private GridPane gp;
    @FXML
    private Label nameP1;
    @FXML
    private Label nameP2;
    @FXML
    private Label scoreP1;
    @FXML
    private Label scoreP2;
    @FXML
    private Label numCardsFoundP1;
    @FXML
    private Label numCardsFoundP2;
    @FXML
    private Label comment;
    // @FXML
    int cd; // num card discovered
    // @FXML
    String[] wd = {}; // word discovered
    // @FXML
    int turn; // turn Player
    // @FXML
    int num = 0;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("menu");
    }

    // @FXML
    public void wordDiscovered(Integer x, Integer y, Parent p) {
        wd[cd] = Game.showWord(x, y);
        ((VBox) p).getChildren().get(0).setVisible(true);
        cd++;
    }

    public void action(Parent p, Player pl) {
        if (cd == 1) {
            wordDiscovered(gp.getColumnIndex(p), gp.getRowIndex(p), p);

            if (Game.isFoundWord(wd[0], wd[1], pl)) {
                if (Game.isVictory()) {
                    gp.setDisable(true);
                    Object o = Game.whoWon(Game.p1, Game.p2);

                    if (o.equals(null)) {
                        comment.setText("PAREGGIO");
                    } else if (o.equals(Game.p1)) {
                        comment.setText("HA VINTO" + Game.p1.getName());
                    } else {
                        comment.setText("HA VINTO" + Game.p2.getName());
                    }
                } else {
                    comment.setText(pl.getName() + "HA INDOVINATO UNA COPPIA");

                }
            } else {
                comment.setText(pl.getName() + "NON HA INDOVINATO UNA COPPIA");
                ((VBox) p).getChildren().get(0).setVisible(false);
            }

        } else {
            wordDiscovered(gp.getColumnIndex(p), gp.getRowIndex(p), p);
        }
    }

    // @FXML
    public void selectButton(Parent p) {
        if (turn % 2 == 0) {
            action(p, Game.p1);
            if (num != 0) {
                wd[0] = null;
                wd[1] = null;
                turn++;
                num = 0;
            }
        } else {
            action(p, Game.p2);
            if (num != 0) {
                wd[0] = null;
                wd[1] = null;
                turn++;
                num = 0;
            }
        }
    }

    // @FXML
    public void createGridPane() {
        // comment.setText("Posiziona un simbolo nel campo");
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                VBox vb = new VBox();
                vb.setPrefHeight(100.0);
                vb.setPrefWidth(100.0);
                vb.setAlignment(Pos.CENTER);

                Label l = new Label();
                vb.setMargin(l, new Insets(0.0, 0.0, 20.0, 0.0));
                l.setVisible(false);
                String s = Game.f.getMatrix()[x][y];
                l.setText(s);

                Button b = new Button();
                b.setText("SCOPRI");

                b.setOnAction(event -> {
                    Node n = (Node) event.getSource();
                    Parent p = n.getParent();

                    // quello che succede al clic
                    selectButton(p);
                });

                vb.getChildren().add(l);
                vb.getChildren().add(b);
                gp.add(vb, x, y);
            }
        }
    }

    // @FXML
    public void view() {
        nameP1.setText(Game.p1.getName());
        nameP2.setText(Game.p2.getName());
        String s = Game.p1.getScore().toString();
        scoreP1.setText(s);
        String s1 = Game.p2.getScore().toString();
        scoreP2.setText(s1);
        String s2 = Game.p1.getNumWF().toString();
        numCardsFoundP1.setText(s2);
        String s3 = Game.p2.getNumWF().toString();
        numCardsFoundP2.setText(s3);
    }

    // @FXML
    public void reset() {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cd = 0;
        turn = 0;
        comment.setText("Scopri due carte");
        Game.populateField();
        Game.printMatrix();
        createGridPane();
        view();
    }
}