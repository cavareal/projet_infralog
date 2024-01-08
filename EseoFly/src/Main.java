

import javafx.application.Application;
import javafx.stage.Stage;
import project.vue.ConnexionPage; 


public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connexion");
        
        ConnexionPage.fenetreConnexion(primaryStage);
       
    }
}
    