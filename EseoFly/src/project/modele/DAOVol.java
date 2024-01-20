package project.modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import defaut.Main;

public class DAOVol {

    private Connection connexion;
    
    public DAOVol() {
    	connexion = Main.getDAOInstance().getConnexion();
    }
    
    @SuppressWarnings("deprecation")
	protected List<Vol> getAllVols() {
        List<Vol> vols = new ArrayList<>();
        String query = "SELECT * FROM fly_book_eseo.Vol";
        
        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Vol vol = new Vol();
                vol.setNumeroVol(resultSet.getString("numeroVol"));
                vol.setDepart(resultSet.getString("depart"));
                vol.setArrivee(resultSet.getString("arrivee"));
                vol.setDateHeureLocaleDepart(resultSet.getTimestamp("dateHeureLocaleDepart"));
                vol.setDateHeureLocaleArrivee(resultSet.getTimestamp("dateHeureLocaleArrivee"));
                vol.setModeleAvion(resultSet.getString("modeleAvion"));
                vol.setDureeVol(resultSet.getTime("dureeVol"));
                vol.setNbPlaceAchetee(getNombreDePlaceAchetee(resultSet.getString("numeroVol")));
                vols.add(vol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vols;
    }
    
    private int getNombreDePlaceAchetee(String numeroVol){
    	int nombreDePlacesVendues = 0;
        String query = "SELECT COUNT(*) AS nombreDePlacesVendues "
                + "FROM fly_book_eseo.Billet "
                + "JOIN fly_book_eseo.Vol ON fly_book_eseo.Billet.numeroVol = fly_book_eseo.Vol.numeroVol "
                + "WHERE fly_book_eseo.Vol.numeroVol = ?";
        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query)) {
            preparedStatement.setString(1, numeroVol);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    nombreDePlacesVendues = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreDePlacesVendues;
    }
    
    
    public boolean addVol(Vol vol) {
        String query = "INSERT INTO Vol (numeroVol, depart, arrivee, dateHeureLocaleDepart, dateHeureLocaleArrivee, "
        		+ "modeleAvion, dureeVol) VALUES (?, ?, ?, ?, ?, ?, ?)";
        boolean succes = false;

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query)) {
            preparedStatement.setString(1, vol.getNumeroVol());
            preparedStatement.setString(2, vol.getDepart());
            preparedStatement.setString(3, vol.getArrivee());

            preparedStatement.setTimestamp(4, vol.getDateHeureLocaleDepart());

            preparedStatement.setTimestamp(5, vol.getDateHeureLocaleArrivee());

            preparedStatement.setString(6, vol.getModeleAvion());
            preparedStatement.setTime(7, vol.getDureeVol());

            int lignesAffectees = preparedStatement.executeUpdate();

            if (lignesAffectees > 0) {
                succes = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return succes;
    }

    public Vol getVolByNumero(String numeroVol) {
        Vol volTrouve = null;
        String query = "SELECT * FROM Vol WHERE numeroVol = ? COLLATE utf8_general_ci";

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query)) {
            preparedStatement.setString(1, numeroVol);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    volTrouve = new Vol();
                    volTrouve.setNumeroVol(resultSet.getString("numeroVol"));
                    volTrouve.setDepart(resultSet.getString("depart"));
                    volTrouve.setArrivee(resultSet.getString("arrivee"));
                    volTrouve.setDateHeureLocaleDepart(resultSet.getTimestamp("dateHeureLocaleDepart"));
                    volTrouve.setDateHeureLocaleArrivee(resultSet.getTimestamp("dateHeureLocaleArrivee"));
                    volTrouve.setModeleAvion(resultSet.getString("modeleAvion"));
                    volTrouve.setDureeVol(resultSet.getTime("dureeVol"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return volTrouve;
    }

}
