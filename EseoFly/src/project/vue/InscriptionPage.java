package project.vue;

import javafx.stage.Stage;
import project.controleur.ConnexionGestion;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InscriptionPage {
	
	public static void fenetreInscription (Stage primaryStage){
		primaryStage.setTitle("Inscription");

        // Création des éléments de l'IHM pour la page d'inscription
        Label nameLabel = new Label("Nom:");
        TextField nameField = new TextField();

        Label firstNameLabel = new Label("Prénom:");
        TextField firstNameField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label passwordLabel = new Label("Mot de passe:");
        PasswordField passwordField = new PasswordField();
        
        Label passwordLabel2 = new Label("Mot de passe:"); // Correspondance des 2 password
        PasswordField passwordField2 = new PasswordField();

        Button registerButton = new Button("S'inscrire");

        // Mise en page 
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(firstNameLabel, 0, 1);
        gridPane.add(firstNameField, 1, 1);
        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailField, 1, 2);
        gridPane.add(passwordLabel, 0, 3);
        gridPane.add(passwordField, 1, 3);
        gridPane.add(passwordLabel2, 0, 4);
        gridPane.add(passwordField2, 1, 4);
        gridPane.add(registerButton, 1, 5);

        // Gestion de l'événement de clic du bouton d'inscription
//        registerButton.setOnAction(e -> handleRegistration(nameField.getText(), firstNameField.getText(),
//                emailField.getText(), passwordField.getText(), primaryStage));
        registerButton.setOnAction(e ->{
        	
        });
        

        Scene scene = new Scene(gridPane, 300, 250);

        // Configuration de la scène principale
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
//	private static void handleRegistration(String name, String firstName, String email, String password, Stage primaryStage) {
//        
//		// traitement des infos 
//        System.out.println("Nom: " + name);
//        System.out.println("Prénom: " + firstName);
//        System.out.println("Email: " + email);
//        System.out.println("Mot de passe: " + password);
//        
//        // logique de traitement ci dessous
//        ConnexionGestion.redirection(primaryStage);
//    }
}
