package project.controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.stage.Stage;
import project.vue.GardePage;

public class ConnexionGestion {
	
	public static boolean verifyLogin(String email, String password) {
		
		String query = "SELECT * FROM Employe WHERE email = ? AND motDePasse = ?";
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.4.194:6666/fly_book_eseo", "bdd", "network");
        	//Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fly_book_eseo", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	
//            	// Afficher les détails de l'utilisateur
//                String mail = resultSet.getString("email");
//                String mdp = resultSet.getString("motDePasse");
//                // Ajoutez d'autres colonnes au besoin
//
//                System.out.println("Détails de l'utilisateur :");
//                System.out.println("Pseudo : " + mail);
//                System.out.println("Mot de passe : " + mdp);
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon votre logique d'application.
        }
		
		return false;
	}
	
	public static void redirection(Stage stage) {
		GardePage.pageDeGarde(new Stage());
        stage.close();
	}

}
