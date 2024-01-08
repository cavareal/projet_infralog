package project.controleur;

import javafx.stage.Stage;
import project.vue.GardePage;

public class ConnexionGestion {
	
	public boolean connexion(String email, String password) {
		boolean bool = false; 
		
		// CONNEXION VALIDE OU NON 
		
		return bool;
	}
	
	public static void redirection(Stage stage) {
		GardePage.pageDeGarde(new Stage());
        stage.close();
	}

}
