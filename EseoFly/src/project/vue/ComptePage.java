package project.vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import project.controleur.ConnexionGestion;

public class ComptePage {
	
	public static void fenetreCompte(Stage stage,Stage previousStage) {
		stage.setTitle("Mon Compte");
		stage.getIcons().add(new Image("file:icon_flybookeseo.png"));
        
		 Label firstNameLabel = new Label("Prénom : " +((ConnexionGestion.getEmploye()).getPrenom()));
	        Label surnameLabel = new Label("Nom : " +((ConnexionGestion.getEmploye()).getNom()));
	        Label emailLabel = new Label("Email : " +((ConnexionGestion.getEmploye()).getEmail()));
        
        Button deconnexionBouton =  new Button("Déconnexion"); 
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        gridPane.addRow(0, firstNameLabel);
        gridPane.addRow(1, surnameLabel);
        gridPane.addRow(2, emailLabel);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20,20,20,20));
        borderPane.setCenter(gridPane);
        borderPane.setBottom(deconnexionBouton); 
        BorderPane.setAlignment(gridPane, Pos.CENTER);
        BorderPane.setAlignment(deconnexionBouton, Pos.CENTER);
        
        deconnexionBouton.setOnAction(e -> {
            stage.close();
            previousStage.close();
        });
        
        Scene scene = new Scene(borderPane, 300, 300);

        stage.setScene(scene);
        stage.show();
	}
	

}
