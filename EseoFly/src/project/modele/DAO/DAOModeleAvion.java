package project.modele.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import defaut.Main;
import project.modele.ModeleAvion;


public class DAOModeleAvion {
    private Connection connexion;
    
    public DAOModeleAvion() {
    	connexion = Main.getDAOInstance().getConnexion();
    }

    public boolean addModeleAvion(ModeleAvion modeleAvion) {
        String query = "INSERT INTO fly_book_eseo.ModeleAvion (modele, nbColonnes, nbPassager, nbPremiereClasse) VALUES (?, ?, ?, ?)";
        boolean succes = false;

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query)) {
            preparedStatement.setString(1, modeleAvion.getModele());
            preparedStatement.setByte(2, (byte) modeleAvion.getNbColonnes());
            preparedStatement.setShort(3, (short) modeleAvion.getNbPassager());
            preparedStatement.setByte(4, (byte) modeleAvion.getNbPremiereClasse());

            int lignesAffectees = preparedStatement.executeUpdate();

            if (lignesAffectees > 0) {
                succes = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return succes;
    }
    
    public List<ModeleAvion> getAllModele() {
        List<ModeleAvion> modele = new ArrayList<>();
        String query = "SELECT * FROM fly_book_eseo.ModeleAvion";

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                ModeleAvion mod = new ModeleAvion();
                mod.setModele(resultSet.getString("modele"));
                modele.add(mod);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modele;
    }
}