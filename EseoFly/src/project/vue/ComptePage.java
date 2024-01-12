package project.vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ComptePage {
	
	public static void fenetreCompte(Stage stage) {
		stage.setTitle("Mon Compte");
		stage.getIcons().add(new Image("file:icon_flybookeseo.png"));
		
		// Barre de menu
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem monCompteItem = new MenuItem("Mon Compte");
        
        //monCompteItem.setOnAction(event -> handleMonCompteClick(stage));
        
        menu.getItems().add(monCompteItem);
        menuBar.getMenus().add(menu);
        
        Label firstNameLabel = new Label("Récupération du prénom");
        Label surnameLabel = new Label("Récupération du nom");
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        gridPane.addRow(0, firstNameLabel);
        gridPane.addRow(1, surnameLabel);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(gridPane);
        
        Scene scene = new Scene(borderPane, 600, 400);

        stage.setScene(scene);
        stage.show();
	}
	
	
	
    private static void handleMonCompteClick(Stage secondStage) {
        // Ajoutez le code pour afficher la page de compte, par exemple
    	
    	ComptePage.fenetreCompte(new Stage());
        secondStage.close();
    }

}
