package project.modele;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAO {

//    private ConnexionBdd connexion;
////    String nameDb = "fly_book_eseo";
//    String nameDb = "projet";
//
//    int port;
//    String ip;
//    public Employe employe;
//
//    public DAO(ConnexionBdd connexion){
//        this.connexion = new ConnexionBdd();
//    }
//
//    public List<Vol> getAllVols() {
//        List<Vol> vols = new ArrayList<>();
//        String query = "SELECT * FROM vol";
//
//        try (PreparedStatement preparedStatement = this.connexion.getConnexion().prepareStatement(query);
//             ResultSet resultSet = preparedStatement.executeQuery()) {
//            while (resultSet.next()) {
//                Vol vol = new Vol();
//                vol.setNumeroVol(resultSet.getString("numero_vol"));
//                vol.setDate(resultSet.getDate("date"));
//                vol.setAeroportDepart(resultSet.getString("aeroport_depart"));
//                vol.setAeroportArrive(resultSet.getString("aeroport_arrivee"));
//                vol.setDureeVol(resultSet.getTime("dureeVol"));
//                vol.setUtc(resultSet.getInt("utc"));
//                vols.add(vol);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return vols;
//    }
//
//    public Employe getEmployeByEmailAndPassword(String email, String password) {
//        String query = "SELECT * FROM Employe WHERE email = ? AND password = ?";
//
//        try (PreparedStatement preparedStatement = this.connexion.getConnexion().prepareStatement(query)) {
//            preparedStatement.setString(1, email);
//            preparedStatement.setString(2, password);
//
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                if (resultSet.next()) {
//                    boolean bool = true;
//                    Employe employe = new Employe(email, password);
//                    employe.setId(resultSet.getShort("id"));
//                    employe.setEmail(resultSet.getString("email"));
//                    employe.setAdministrateur(resultSet.getBoolean("administrateur"));
//                    employe.setNom(resultSet.getString("nom"));
//                    employe.setPrenom(resultSet.getString("prenom"));
//                }
//                    boolean bool = false;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return employe;
//    }






}
