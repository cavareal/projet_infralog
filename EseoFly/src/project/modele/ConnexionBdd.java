package project.modele;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnexionBdd {

	//private String ip = "192.168.56.90"; // private
//	private String ip = "192.168.4.194"; //public
//	private int port = 6666; 
//	private String user="bdd"; 
//	private String password="network";


	
	private String ip = "127.0.0.1"; 
	//private String ip = "localhost";
	private int port = 3306; 
	private String user="root"; 
	private String password="";

	private String nomBdd = "fly_book_eseo";
	private static Connection connexion = null;
	

    public ConnexionBdd() throws ClassNotFoundException {
        	
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = String.format("jdbc:mysql://%s:%d/%s", ip, port, this.nomBdd);
        	connexion = DriverManager.getConnection(url, user, password);
        	System.out.println("database connexion ok");

        	
//			A UTILISER POUR L'INSCRIPTION
//        	String email = "root"; 
//        	boolean isAdmin = true;
//        	String nom = "nom";
//        	String prenom="prenom";
//        	String motDePasse="root";
//        	String query = "INSERT INTO fly_book_eseo.Employe (email, administrateur, nom, prenom, motDePasse) VALUES (?, ?, ?, ?, ?)";
//        	
//            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
//            	
//            	preparedStatement.setString(1, email);
//                preparedStatement.setBoolean(2, isAdmin);
//                preparedStatement.setString(3, nom);
//                preparedStatement.setString(4, prenom);
//                preparedStatement.setString(5, motDePasse);
//
//                int rowsAffected = preparedStatement.executeUpdate();
//                System.out.println("OKK" + rowsAffected);
//                }
        
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
    
    
    





//    public JsonObject executionRequeteSQL(TypeRequeteSQL typeRequete, String table, String requete) {
//        try {
////            String requete = "";
//
//            switch (typeRequete) {
//                case INSERT:
//                    requete = String.format("INSERT INTO %s (...) VALUES (...)", table);
//                    break;
//
//                case DELETE:
//                    requete = String.format("DELETE FROM %s WHERE ...", table);
//                    break;
//
//                case UPDATE:
//                    requete = String.format("UPDATE %s SET ... WHERE ...", table);
//                    break;
//
//                case SELECT:
//                    requete = String.format("SELECT * FROM %s WHERE %s.id = (SELECT MAX(%s.id) FROM %s)", table, table, table, table);
//                    break;
//
//                default:
//                    break;
//            }
//
//            this.cursor.execute(requete);
//
//            if (typeRequete == TypeRequeteSQL.SELECT) {
//                ResultSet resultSet = this.cursor.getResultSet();
//                JsonObject jsonObject = new JsonObject();
//
//                ResultSetMetaData metaData = resultSet.getMetaData();
//                int columnCount = metaData.getColumnCount();
//
//                while (resultSet.next()) {
//                    JsonObject rowObject = new JsonObject();
//                    for (int i = 1; i <= columnCount; i++) {
//                        String columnName = metaData.getColumnName(i);
//                        Object columnValue = resultSet.getObject(i);
//
//                        rowObject.addProperty(columnName, columnValue.toString());
//                    }
//
//                    jsonObject.add("row", rowObject);
//                }
//
//                return jsonObject;
//            }
//
//
//
//        } catch (SQLException e) {
//            System.out.println(String.format("%s: Erreur lors de la récupération de l'entrée de la base de données : %s", this.nameDB, e.getMessage()));
//        }
//
//        return null;
//    }



}