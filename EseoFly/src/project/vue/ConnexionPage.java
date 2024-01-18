package project.vue;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import project.controleur.ConnexionGestion;

public class ConnexionPage{
	
	public static void fenetreConnexion(Stage primaryStage){
		//Changement du favIcon
		primaryStage.getIcons().add(new Image("file:icon_flybookeseo.png"));
		
		
		 
		// Création des éléments de l'IHM
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label passwordLabel = new Label("Mot de passe:");
        PasswordField passwordField = new PasswordField(); //mdp caché 
        
        Label problemeDeConnexionLabel = new Label("Problème de connexion");
        problemeDeConnexionLabel.setTextFill(Color.RED);
        
        Label gapLabel = new Label("  ");
        Label gapLabel2 = new Label("  ");
        Label gapLabel3 = new Label("  ");

        Button loginButton = new Button("Se connecter");
        
        Button registerButton = new Button("  Inscription  ");

        // Mise en page
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        gridPane.addRow(0, emailLabel, emailField);
        gridPane.addRow(1, passwordLabel, passwordField);
        gridPane.addRow(2, gapLabel, loginButton);
        gridPane.addRow(3, gapLabel2, registerButton);

        // Gestion de l'événement de clic du bouton de connexion
        //loginButton.setOnAction(e -> handleLogin(emailField.getText(), passwordField.getText(), primaryStage));
        loginButton.setOnAction(e -> {
        	if (ConnexionGestion.verifyLogin(emailField.getText(), passwordField.getText())) {
            	// METHODE DE CHANGEMENT DE PAGE
                ConnexionGestion.redirection(primaryStage);
            }
        	else {
        		// AFFICHAGE MESSAGE D'ERREUR
        		gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == 4);
        		gridPane.addRow(4, gapLabel3, problemeDeConnexionLabel);
        	}
        });
        
        // Gestion de l'événement du clic du bouton inscription 
        registerButton.setOnAction(e -> handleRegistration(primaryStage));
        
        Image image = new Image("file:fly_book_eseo_resize.png");
        ImageView imageView = new ImageView(image);
        VBox imageVBox = new VBox(10);
        imageVBox.getChildren().addAll(imageView,gridPane);

        
        // Création de la scène = contenu de la fenêtre
        Scene scene = new Scene(imageVBox, image.getHeight(), 500);

        // Configuration de la scène principale
        primaryStage.setScene(scene);
        primaryStage.show(); // Affichage de la fenêtre
	}
	
//    private static void handleLogin(String email, String password, Stage primaryStage) {
//    	
//    	// METHODE DE VERIFICATION
//        // Ici simple affichage de email et du mdp dans la console PB DE SECU 
//        System.out.println("Email: " + email);
//        System.out.println("Mot de passe: " + password);
//        
//        
//        if (ConnexionGestion.connexion(email, password)) {
//        	// METHODE DE CHANGEMENT DE PAGE
//            ConnexionGestion.redirection(primaryStage);
//            System.out.println("PASS");
//        }
//       
		
//        // METHODE DE CHANGEMENT DE PAGE
//        //ConnexionGestion.redirection(primaryStage);
//        //efrthyuki
//        
//    }
    
    private static void handleRegistration(Stage primaryStage) {
        	
    	// METHODE DE CHANGEMENT DE PAGE
        
        // Appelle la méthode start pour afficher la nouvelle page
        InscriptionPage.fenetreInscription(new Stage());
        // Ferme la scène actuelle (page de connexion)
        primaryStage.close();
    }

}
