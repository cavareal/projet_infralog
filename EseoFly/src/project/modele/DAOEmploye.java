package project.modele;

import java.sql.*;

import defaut.Main;


public class DAOEmploye{

    private Connection connexion;
    
    public DAOEmploye() {
    	connexion = Main.getDAOInstance().getConnexion();
    }

    public String[] getEmploye(String email, String password) {
    	String[] tableau = new String[6]; // [email, isAdmin, nom, prenom, password, estInsrit];
    	
        String query = "SELECT * FROM Employe WHERE email = ? AND motDePasse = ?";
        boolean estInscrit = false;
        
        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    estInscrit = true;
                    boolean b =resultSet.getBoolean("administrateur");
                    tableau[0] = resultSet.getString("email");
                    tableau[1] = (b==true) ? "1" : "0";
                    tableau[2] = resultSet.getString("nom");
                    tableau[3] = resultSet.getString("prenom");
                    tableau[4] = resultSet.getString("motDePasse");
                }
                tableau[5] = Boolean.toString(estInscrit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableau;
    }


    public boolean addEmploye(Employe employe) {
        String requete = "INSERT INTO Employe (email, administrateur, nom, prenom, motDePasse) VALUES (?, ?, ?, ?, ?)";
        boolean succes = false;

        try (PreparedStatement preparedStatement = this.connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, employe.getEmail());
            preparedStatement.setBoolean(2, employe.isAdministrateur());
            preparedStatement.setString(3, employe.getNom());
            preparedStatement.setString(4, employe.getPrenom());
            preparedStatement.setString(5, employe.getMotDePasse());

            int lignesAffectees = preparedStatement.executeUpdate();

            if (lignesAffectees > 0) {
                ResultSet clesGenerees = preparedStatement.getGeneratedKeys();
                if (clesGenerees.next()) {
                    //employe.setId(clesGenerees.getShort(1));
                    succes = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return succes;
    }


}