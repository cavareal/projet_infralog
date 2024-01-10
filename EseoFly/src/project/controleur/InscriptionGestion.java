package project.controleur;

import javafx.stage.Stage;

public class InscriptionGestion {
	
	public static void redirection(Stage stage) {
		
	}
	
	public static boolean inscription(String name, String firstName, String email, 
			String password,String password2 ) {
		boolean bool = false;
		
		if(password==password2) {
			
			bool = true;
		}
		
		return bool;
	}

}
