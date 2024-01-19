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
        
        try (//Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.4.194:6666/fly_book_eseo", "bdd", "network");
        	Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fly_book_eseo", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	
            	if (resultSet.next()) {
                    // Utilisez les getters appropriés pour extraire les valeurs des colonnes
                    String retrievedEmail = resultSet.getString("email");
                    String retrievedPassword = resultSet.getString("motDePasse");
                    System.out.println(retrievedEmail);
                    // Vous pouvez faire plus de choses avec ces valeurs, par exemple les comparer avec les paramètres d'entrée

                    return true; // Ou retournez true en fonction de votre logique
                } else {
                    return false;
                }
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
