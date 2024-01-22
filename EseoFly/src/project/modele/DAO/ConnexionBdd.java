package project.modele.DAO;


import java.sql.*;

public class ConnexionBdd {

	//private String ip = "192.168.56.90"; // private
	private String ip = "192.168.4.194"; //public
	private int port = 6666; 
	private String user="bdd"; 
	private String password="network";


	
//	private String ip = "127.0.0.1"; 
//	//private String ip = "localhost";
//	private int port = 3306; 
//	private String user="root"; 
//	private String password="";
//
	private String nomBdd = "fly_book_eseo";
	private static Connection connexion = null;
	

    public ConnexionBdd() throws ClassNotFoundException {
        	
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = String.format("jdbc:mysql://%s:%d/%s", ip, port, this.nomBdd);
        	connexion = DriverManager.getConnection(url, user, password);
        	System.out.println("database connexion ok");
        
        }catch (SQLException e) {
        	System.out.println(e.getMessage());
        }

    }
    
	public Connection getConnexion() {
		return connexion;
	}
	
	public void setConnexion(Connection con) {
		this.connexion = con;
	}


    public void finaliserConnexion() {
        if (this.connexion != null) {
            try {
                this.connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}