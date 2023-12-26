package project;

import javafx.application.Application;
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
}
    