package com.example.gestion_restaurant3.controller;

import com.example.gestion_restaurant3.RESTAUACCEUILAPP;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthentificationController {
    @FXML
    private Label labelres;
    @FXML
    private TextField txtlog;
    @FXML
    private PasswordField txtpass;
    @FXML
    private Button btncon;
    @FXML
    private Button btnannul;

    public void connecter(javafx.event.ActionEvent actionEvent) {
        if (txtlog.getText().equals("a") == true && txtpass.getText().equals("a") == true) {
            labelres.setTextFill(Paint.valueOf("#008000"));
            labelres.setText(" Bienvenue dans votre Application!");

            try {
                FXMLLoader fxmlLoader1 = new FXMLLoader(RESTAUACCEUILAPP.class.getResource("Acceuil.fxml"));
                Scene scene1 = new Scene(fxmlLoader1.load(), 530, 420);  //Accueil : 570 420
                Stage stage1 = new Stage();
                stage1.setTitle(" ACCUEIL - Restaurant ");
                stage1.setScene(scene1);
                stage1.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            labelres.setTextFill(Paint.valueOf("#FF0000"));
            labelres.setText("ECHEC, erreur d'authentification !!!!");
        }

    }

    public void annuler(javafx.event.ActionEvent actionEvent) {
        txtlog.setText("");
        txtpass.setText("");
        labelres.setText("  ");
    }
}