package project.modele;

import java.sql.*;

import defaut.Main;


public class DAOModeleAvion {
    private Connection connexion;
    
    public DAOModeleAvion() {
    	connexion = Main.getDAOInstance().getConnexion();
    }

    public boolean addModeleAvion(ModeleAvion modeleAvion) {
        String query = "INSERT INTO ModeleAvion (modele, nbColonnes, nbPassager, nbPremiereClasse) VALUES (?, ?, ?, ?)";
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
}