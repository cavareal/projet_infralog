package project.modele.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import defaut.Main;
import project.modele.Billet;

public class DAOBillet {

    private final Connection connexion;
    
    public DAOBillet() {
    	connexion = Main.getDAOInstance().getConnexion();
    }

    public Billet getByNumeroReservation(String numeroReservation) {
        String query = "SELECT * FROM Billet WHERE numeroReservation = ?";
        Billet billet = null;

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query)) {
            preparedStatement.setString(1, numeroReservation);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    billet = new Billet(numeroReservation);
                    billet.setIdClient(resultSet.getInt("id"));
                    billet.setNumeroReservation(resultSet.getString("numeroReservation"));
                    billet.setIdClient(resultSet.getInt("idClient"));
                    billet.setNumeroVol(resultSet.getString("numeroVol"));
                    billet.setBagages(resultSet.getBoolean("bagages"));
                    billet.setPrix(resultSet.getInt("prix"));
                    billet.setGarantie(resultSet.getBoolean("garantie"));
                    billet.setPlace(resultSet.getString("place"));
                    billet.setNomPassager(resultSet.getString("nomPassager"));
                    billet.setPrenomPassager(resultSet.getString("prenomPassager"));
                    billet.setAgePassager(resultSet.getInt("agePassager"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return billet;
    }

    public List<Billet> getAllBillets() {
        List<Billet> billets = new ArrayList<>();
        String query = "SELECT * FROM Billet";

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Billet billet = new Billet();
                billet.setNumeroReservation(resultSet.getString("numeroReservation"));
                billet.setIdClient(resultSet.getInt("idClient"));
                billet.setNumeroVol(resultSet.getString("numeroVol"));
                billet.setBagages(resultSet.getBoolean("bagages"));
                billet.setPrix(resultSet.getInt("prix"));
                billet.setGarantie(resultSet.getBoolean("garantie"));
                billet.setPlace(resultSet.getString("place"));
                billet.setNomPassager(resultSet.getString("nomPassager"));
                billet.setPrenomPassager(resultSet.getString("prenomPassager"));
                billet.setAgePassager(resultSet.getInt("agePassager"));

                billets.add(billet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return billets;
    }
}
