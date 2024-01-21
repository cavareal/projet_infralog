package project.vue;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import project.controleur.InscriptionGestion;

public class InscriptionPage {
	
	public static void fenetreInscription (Stage primaryStage){
		primaryStage.setTitle("Inscription");
		primaryStage.getIcons().add(new Image("file:icon_flybookeseo.png"));

        // Création des éléments de l'IHM pour la page d'inscription
        Label nameLabel = new Label("Nom :");
        TextField nameField = new TextField();

        Label firstNameLabel = new Label("Prénom :");
        TextField firstNameField = new TextField();

        Label emailLabel = new Label("Email :");
        TextField emailField = new TextField();

        Label passwordLabel = new Label("Mot de passe :");
        PasswordField passwordField = new PasswordField();
        
        Label passwordLabel2 = new Label("Mot de passe :"); // Correspondance des 2 password
        PasswordField passwordField2 = new PasswordField();

        Button registerButton = new Button("S'inscrire");

        Label champsNonRenseignes = new Label("Veuillez renseigner tous les champs.");
        champsNonRenseignes.setTextFill(Color.RED);

        Label motDePasseNonIdentiques = new Label("Mots de passe non identiques");
        motDePasseNonIdentiques.setTextFill(Color.RED);

        Label conditionsMotDePasseNonRespectees = new Label("Mot de passe invalide");
        conditionsMotDePasseNonRespectees.setTextFill(Color.RED);

        Label emailInvalide = new Label("L'email renseigné n'est pas valide.");
        emailInvalide.setTextFill(Color.RED);

        Label emailDejaUtilise = new Label("L'email est déjà utilisé.");
        emailDejaUtilise.setTextFill(Color.RED);

        Label problèmeInscription = new Label("Problème lors de l'inscription");
        problèmeInscription.setTextFill(Color.RED);

        // Mise en page 
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

            nameField.setPrefWidth(200);
            firstNameField.setPrefWidth(200);
            emailField.setPrefWidth(200);
            passwordField.setPrefWidth(200);
            passwordField2.setPrefWidth(200);

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
//        registerButton.setOnAction(e ->{
////                if (!InscriptionGestion.ensembleChampsRenseignes(nameField.getText(), firstNameField.getText(), emailField.getText(), passwordField.getText(), passwordField2.getText())){
////                        gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == 4);
////                        gridPane.addRow(6,gapLabel2, champsNonRenseignes);
////                }
//                if (!InscriptionGestion.verifierAdresseEmail(emailField.getText())){
//                        gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == 4);
//                        gridPane.addRow(6, emailInvalide);
//                }
//                else if (!InscriptionGestion.verifierConditionsMotDePasse(emailField.getText())){
//                        gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == 4);
//                        gridPane.addRow(4, conditionsMotDePasseNonRespectees);
//                }
//                else{
//                     InscriptionGestion.redirection2(primaryStage);
//                }
//
//        });

            registerButton.setOnAction(e -> {
                    gridPane.getChildren().removeAll(champsNonRenseignes, emailInvalide, conditionsMotDePasseNonRespectees, motDePasseNonIdentiques, emailDejaUtilise, problèmeInscription);
                    if (!InscriptionGestion.ensembleChampsRenseignes(nameField.getText(), firstNameField.getText(), emailField.getText(), passwordField.getText(), passwordField2.getText())) {
                            gridPane.add(champsNonRenseignes, 1, 6);
                    }
                    else if (!InscriptionGestion.verifierAdresseEmail(emailField.getText())) {
                            gridPane.add(emailInvalide, 1, 6);
                    }
                    else if (!InscriptionGestion.verifierConditionsMotDePasse(passwordField.getText())) {
                            gridPane.add(conditionsMotDePasseNonRespectees, 1, 6);
                    }
                    else if (!InscriptionGestion.confirmationMotDePasse(passwordField.getText(), passwordField2.getText())) {
                            gridPane.add(motDePasseNonIdentiques, 1, 6);
                    }
                    else if (InscriptionGestion.emailDejaUtilise(emailField.getText())) {
                            gridPane.add(emailDejaUtilise, 1, 6);
                    }
                    else if (!InscriptionGestion.inscriptionEffectuee(nameField.getText(), firstNameField.getText(),emailField.getText(), passwordField.getText(),true)) {
                            gridPane.add(problèmeInscription, 1, 6);
                    }
                    else {
                            InscriptionGestion.redirection2(primaryStage);
                    }
            });


        Scene scene = new Scene(gridPane, 350, 260);

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
