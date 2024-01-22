package project.modele.DAO;
import java.sql.Connection;


public class DAO {

	private ConnexionBdd connexionbdd;
	private Connection connexion;
	
	public DAO () {
		try {
	        connexionbdd = new ConnexionBdd();
	        connexion = connexionbdd.getConnexion();
	    } catch (ClassNotFoundException e) {
	        // Handle the exception (e.g., print a message or log it)
	        e.printStackTrace();
	    }
	}
	
	public Connection getConnexion() {
		return connexion;
	}

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







}
