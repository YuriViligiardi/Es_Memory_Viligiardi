package it.viligiardi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.viligiardi.pojo.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private Label comment;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("menu");
    }

    // @FXML
    public void selectButton(Button b) {

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

                Button b = new Button();

                b.setOnAction(event -> {
                    // quello che succede al clic
                    selectButton(b);
                });

                vb.getChildren().add(l);
                vb.getChildren().add(b);
                gp.add(b, x, y);
            }
        }
    }

    // @FXML
    private void view() {
        nameP1.setText(Game.p1.getName());
        nameP2.setText(Game.p2.getName());
        // String s = Game.p1.getScore().toString();
        // scoreP1.setText(s);
        // String s1 = Game.p2.getScore().toString();
        // scoreP2.setText(s1);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        createGridPane();
    }
}