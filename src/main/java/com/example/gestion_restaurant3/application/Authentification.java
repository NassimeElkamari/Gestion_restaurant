package com.example.gestion_restaurant3.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Authentification  extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Authentification.class.getResource("Acceuil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 260);
        stage.setTitle("Gestion Restaurant :  ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
