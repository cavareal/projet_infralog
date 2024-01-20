package project.modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAeroport {
    private Connection connexion;

    public boolean ajouterAeroport(project.modele.Aeroport aeroport) {
        String query = "INSERT INTO Aeroport (acronyme, ville, pays, nom, utc) VALUES (?, ?, ?, ?, ?)";
        boolean succes = false;

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query)) {
            preparedStatement.setString(1, aeroport.getAcronyme());
            preparedStatement.setString(2, aeroport.getVille());
            preparedStatement.setString(3, aeroport.getPays());
            preparedStatement.setString(4, aeroport.getNom());
            preparedStatement.setShort(5, aeroport.getUtc());

            int lignesAffectees = preparedStatement.executeUpdate();

            if (lignesAffectees > 0) {
                succes = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return succes;
    }


    public List<Aeroport> getAllAeroport() {
        List<Aeroport> aeroports = new ArrayList<>();
        String query = "SELECT * FROM Aeroport";

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Aeroport aeroport = new Aeroport();
                aeroport.setAcronyme(resultSet.getString("acronyme"));
                aeroport.setVille(resultSet.getString("ville"));
                aeroport.setPays(resultSet.getString("pays"));
                aeroport.setNom(resultSet.getString("nom"));
                aeroport.setUtc(resultSet.getShort("utc"));

                aeroports.add(aeroport);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aeroports;
    }

}
