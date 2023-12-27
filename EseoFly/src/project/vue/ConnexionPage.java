package project.vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConnexionPage{
	
	public static void fenetreConnexion(Stage primaryStage){
		 // Création des éléments de l'IHM
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label passwordLabel = new Label("Mot de passe:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Se connecter");
        
        Button registerButton = new Button("Inscription");

        // Mise en page
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(emailLabel, 0, 0);
        gridPane.add(emailField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);
        gridPane.add(registerButton, 1, 3);


        // Gestion de l'événement de clic du bouton de connexion
        loginButton.setOnAction(e -> handleLogin(emailField.getText(), passwordField.getText(), primaryStage));
        
        // Gestion de l'événement du clic du bouton inscription 
        registerButton.setOnAction(e -> handleRegistration(primaryStage));

        
        // Création de la scène = contenu de la fenêtre
        Scene scene = new Scene(gridPane, 400, 300);

        // Configuration de la scène principale
        primaryStage.setScene(scene);
        primaryStage.show(); // Affichage de la fenêtre
	}
	
	   // Méthode de gestion de la connexion (à personnaliser selon vos besoins)
    private static void handleLogin(String email, String password, Stage primaryStage) {
        // Ici simple affichage de email et du mdp dans la console PB DE SECU 
    	// Faire l'appel à la data base ici ? 
        System.out.println("Email: " + email);
        System.out.println("Mot de passe: " + password);
        // vérif ici 
        GardePage.pageDeGarde(new Stage());
        primaryStage.close();
        
    }
    
    private static void handleRegistration(Stage primaryStage) {
        
        // Appelle la méthode start pour afficher la nouvelle page
        InscriptionPage.fenetreInscription(new Stage());

        // Ferme la scène actuelle (page de connexion)
        primaryStage.close();
    }

}
