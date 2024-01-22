package project.modele.DAO;


import java.sql.*;

public class ConnexionBdd {


	private static Connection connexion = null;
	

    public ConnexionBdd() throws ClassNotFoundException {
        	
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			//	private String ip = "127.0.0.1";
			//	//private String ip = "localhost";
			//	private int port = 3306;
			//	private String user="root";
			//	private String password="";
			//
			String nomBdd = "fly_book_eseo";
			int port = 6666;
			//private String ip = "192.168.56.90"; // private
			//public
			String ip = "192.168.4.194";
			String url = String.format("jdbc:mysql://%s:%d/%s", ip, port, nomBdd);
			String password = "network";
			String user = "bdd";
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
		connexion = con;
	}


    public void finaliserConnexion() {
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}