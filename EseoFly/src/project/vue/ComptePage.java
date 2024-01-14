package project.vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ComptePage {
	
	public static void fenetreCompte(Stage stage,Stage previousStage) {
		stage.setTitle("Mon Compte");
		stage.getIcons().add(new Image("file:icon_flybookeseo.png"));
        
        Label firstNameLabel = new Label("Récupération du prénom");
        Label surnameLabel = new Label("Récupération du nom");
        
        Button deconnexionBouton =  new Button("Déconnexion"); 
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        gridPane.addRow(0, firstNameLabel);
        gridPane.addRow(1, surnameLabel);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20,20,20,20));
        borderPane.setCenter(gridPane);
        borderPane.setBottom(deconnexionBouton); 
        borderPane.setAlignment(gridPane, Pos.CENTER);
        borderPane.setAlignment(deconnexionBouton, Pos.CENTER);
        
        deconnexionBouton.setOnAction(e -> {
            stage.close();
            previousStage.close();
        });
        
        Scene scene = new Scene(borderPane, 300, 300);

        stage.setScene(scene);
        stage.show();
	}
	

}
