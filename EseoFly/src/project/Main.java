package project;

import javafx.application.Application;
<<<<<<< HEAD
=======
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
>>>>>>> 6904f20e047e3465ad7ac80f342cf018ec191ef0
import javafx.stage.Stage;
import project.vue.Connexion; 


public class Main extends Application {

	public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connexion");
        
        Connexion.fenetreConnexion(primaryStage);
       
    }
<<<<<<< HEAD
=======

 
>>>>>>> 6904f20e047e3465ad7ac80f342cf018ec191ef0
}
    