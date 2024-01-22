package project.modele.DAO;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import defaut.Main;
import project.modele.Client;


public class DAOClient {

    private Connection connexion;
    
    public DAOClient() {
    	connexion = Main.getDAOInstance().getConnexion();
    }

    public List<Client> getClientByNomPrenom(String nom, String prenom) {
        List<Client> clientsTrouves = new ArrayList<>();
        String query = "SELECT * FROM Client WHERE LOWER(nom) LIKE LOWER(?) AND LOWER(prenom) LIKE LOWER(?) COLLATE utf8_general_ci";

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query)) {
            // recherche partielle ?
            preparedStatement.setString(1, "%" + nom + "%");
            preparedStatement.setString(2, "%" + prenom + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Client client = new Client();
                    client.setId(resultSet.getInt("id"));
                    client.setEmail(resultSet.getString("email"));
                    client.setNom(resultSet.getString("nom"));
                    client.setPrenom(resultSet.getString("prenom"));
                    client.setDateNaissance(resultSet.getDate("dateNaissance"));
                    client.setMotDePasse(resultSet.getString("motDePasse"));
                    clientsTrouves.add(client);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientsTrouves;
    }

    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        String query = "SELECT * FROM Client";

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setEmail(resultSet.getString("email"));
                client.setNom(resultSet.getString("nom"));
                client.setPrenom(resultSet.getString("prenom"));
                client.setDateNaissance(resultSet.getDate("dateNaissance"));
                client.setMotDePasse(resultSet.getString("motDePasse"));
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientList;
    }
}

