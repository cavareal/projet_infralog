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
	        e.printStackTrace();
	    }
	}
	
	public Connection getConnexion() {
		return connexion;
	}




}
