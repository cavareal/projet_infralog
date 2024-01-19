

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.stage.Stage;
import project.modele.ConnexionBdd;
import project.vue.ConnexionPage; 


public class Main extends Application {
	
	
	
	public static void main(String[] args) {
		launch(args);
        
    }

	@Override
    public void start(Stage primaryStage) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        primaryStage.setTitle("Connexion");
        
        ConnexionPage.fenetreConnexion(primaryStage);
        new ConnexionBdd();
    }
}
    