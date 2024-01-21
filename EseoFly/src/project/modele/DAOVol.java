package project.modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import defaut.Main;
import project.controleur.AjoutGestion;

public class DAOVol {

    private Connection connexion;
    
    public DAOVol() {
    	connexion = Main.getDAOInstance().getConnexion();
    }
    
	protected List<Vol> getAllVols() {
        List<Vol> vols = new ArrayList<>();
        String query = "SELECT * FROM fly_book_eseo.Vol ORDER BY dateHeureLocaleDepart";
        
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
                vol.setPrixStandard(resultSet.getInt("prixStandard"));
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
    
    
    public void addVol(Vol vol,short utcDepart, short utcArrivee) {
        String query = "INSERT INTO fly_book_eseo.Vol (numeroVol, depart, arrivee, dateHeureLocaleDepart, dateHeureLocaleArrivee, modeleAvion, dureeVol, prixStandard) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        boolean succes = false;

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query)) {
            preparedStatement.setString(1, vol.getNumeroVol());
            preparedStatement.setString(2, vol.getDepart());
            preparedStatement.setString(3, vol.getArrivee());
            preparedStatement.setTimestamp(4, vol.getDateHeureLocaleDepart());
            
            int utcDifference = utcArrivee - utcDepart;
            Timestamp dateArrivee = new Timestamp(vol.getDateHeureLocaleDepart().getTime() + TimeUnit.HOURS.toMillis(utcDifference) + vol.getDureeVol().getTime());

            preparedStatement.setTimestamp(5, dateArrivee);
            preparedStatement.setString(6, vol.getModeleAvion());
            preparedStatement.setTime(7, vol.getDureeVol());
            preparedStatement.setInt(8, vol.getPrixStandard());

            int lignesAffectees = preparedStatement.executeUpdate();
            
            if (lignesAffectees > 0) {
                //System.out.println("OK");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void updateVol(Vol vol, short utcDepart, short utcArrivee) {
        String query = "UPDATE fly_book_eseo.Vol SET depart=?, arrivee=?, dateHeureLocaleDepart=?, dateHeureLocaleArrivee=?, modeleAvion=?, dureeVol=?, prixStandard=? WHERE numeroVol=?";
        
        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query)) {
            preparedStatement.setString(1, vol.getDepart());
            preparedStatement.setString(2, vol.getArrivee());
            preparedStatement.setTimestamp(3, vol.getDateHeureLocaleDepart());

            int utcDifference = utcArrivee - utcDepart;
            Timestamp dateArrivee = new Timestamp(vol.getDateHeureLocaleDepart().getTime() + TimeUnit.HOURS.toMillis(utcDifference) + vol.getDureeVol().getTime());

            preparedStatement.setTimestamp(4, dateArrivee);
            preparedStatement.setString(5, vol.getModeleAvion());
            preparedStatement.setTime(6, vol.getDureeVol());
            preparedStatement.setInt(7, vol.getPrixStandard());
            preparedStatement.setString(8, vol.getNumeroVol());

            int lignesAffectees = preparedStatement.executeUpdate();

            if (lignesAffectees > 0) {
                //System.out.println("Mise à jour réussie");
            } else {
                //System.out.println("Aucune ligne mise à jour");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Vol getVolByNumero(String numeroVol) {
        Vol volTrouve = null;
        String query = "SELECT * FROM fly_book_eseo.Vol WHERE numeroVol = ? COLLATE utf8_general_ci";

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
    
    protected List<Vol> searchVols(String nom, String prenom, String numeroVol, String date, 
    	    String aeroport, boolean depart, boolean arrivee) {
    	    List<Vol> resultats = new ArrayList<>();
    	    
    	    String query = "SELECT * FROM fly_book_eseo.Vol V WHERE 1=1";
    	    
    	    if (!nom.equals("")) {
    	        query += " AND EXISTS (SELECT * FROM fly_book_eseo.Billet WHERE V.numeroVol = Billet.numeroVol AND Billet.nomPassager = ?)";
    	    }

    	    if (!prenom.equals("")) {
    	        query += " AND (B.prenomPassager = ? OR B.prenomPassager IS NULL)";
    	    }

    	    if (!numeroVol.equals("")) {
    	        query +=" AND V.numeroVol = ?";
    	    }

    	    if (!date.equals("")) {
    	        query +=" AND V.dateHeureLocaleDepart >= ?";
    	    }

    	    if (!aeroport.equals("")) {
    	    	aeroport = AjoutGestion.extraireCodeIATA(aeroport);
    	        if (depart) {
    	            query +=" AND V.depart = ?";
    	        }
    	        if (arrivee) {
    	            query +=" AND V.arrivee = ?";
    	        }
    	    }
    	    query += " ORDER BY dateHeureLocaleDepart";
    	    try (PreparedStatement preparedStatement = connexion.prepareStatement(query)) {

    	        int parameterIndex = 1;

    	        if (!nom.equals("")) {
    	            preparedStatement.setString(parameterIndex++, nom);
    	        }

    	        if (!prenom.equals("")) {
    	            preparedStatement.setString(parameterIndex++, prenom);
    	        }

    	        if (!numeroVol.equals("")) {
    	            preparedStatement.setString(parameterIndex++, numeroVol);
    	        }

    	        if (!date.equals("")) {
    	            Timestamp timestamp = Timestamp.valueOf(date + " 00:00:00");
    	            preparedStatement.setTimestamp(parameterIndex++, timestamp);
    	        }

    	        if (!aeroport.equals("")) {
    	            if (depart || arrivee) {
    	                preparedStatement.setString(parameterIndex++, aeroport);
    	            }
    	        }

    	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
    	            while (resultSet.next()) {
    	                // Créer des objets Vol et les ajouter à la liste des résultats
    	                Vol vol = new Vol();
    	                vol.setNumeroVol(resultSet.getString("numeroVol"));
    	                vol.setDepart(resultSet.getString("depart"));
    	                vol.setArrivee(resultSet.getString("arrivee"));
    	                vol.setDateHeureLocaleDepart(resultSet.getTimestamp("dateHeureLocaleDepart"));
    	                vol.setDateHeureLocaleArrivee(resultSet.getTimestamp("dateHeureLocaleArrivee"));
    	                vol.setModeleAvion(resultSet.getString("modeleAvion"));
    	                vol.setDureeVol(resultSet.getTime("dureeVol"));
    	                vol.setNbPlaceAchetee(getNombreDePlaceAchetee(resultSet.getString("numeroVol")));
    	                vol.setPrixStandard(resultSet.getInt("prixStandard"));
    	                resultats.add(vol);
    	            }
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    return resultats;
    }
}
