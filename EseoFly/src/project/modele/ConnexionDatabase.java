package EseoFly.src.project.modele;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnexionDatabase {
    private String nameDB;
    private Connection db;
    private Statement cursor;
    private String user;
    private String password;



    public ConnexionDatabase(String flyBookEseoDB, String ip, int port) {

        //à retest  avec fichier à part .db_env
//        String cheminDotenv = FileSystems.getDefault().getPath(".db_env").toAbsolutePath().toString();

//        try {
//            chargerDotenv(cheminDotenv);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        this.nameDB = flyBookEseoDB;
        this.user = "pwnd";
        this.password = "network";

        while (true) {
            try {
                String url = String.format("jdbc:mariadb://%s:%d/%s", ip, port, this.nameDB);
                Connection connexion = DriverManager.getConnection(url, this.user, this.password);

                this.db = connexion;
                this.cursor = connexion.createStatement();
                System.out.println("Base de données " + flyBookEseoDB + " - Connectée");
                break;
            } catch (SQLException e) {
                System.out.println("Base de données " + flyBookEseoDB + " - Erreur: " + e.getMessage());
            }


        }
    }

    public Connection getConnexion(){
        return this.db;
    }

    public void finaliserConnexion() {
        System.out.println("Supprimer la connexion à la base de données");
        if (this.db != null) {
            try {
                this.db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




    public JsonObject executionRequeteSQL(TypeRequeteSQL typeRequete, String table, String requete) {
        try {
//            String requete = "";

            switch (typeRequete) {
                case INSERT:
                    requete = String.format("INSERT INTO %s (...) VALUES (...)", table);
                    break;

                case DELETE:
                    requete = String.format("DELETE FROM %s WHERE ...", table);
                    break;

                case UPDATE:
                    requete = String.format("UPDATE %s SET ... WHERE ...", table);
                    break;

                case SELECT:
                    requete = String.format("SELECT * FROM %s WHERE %s.id = (SELECT MAX(%s.id) FROM %s)", table, table, table, table);
                    break;

                default:
                    break;
            }

            this.cursor.execute(requete);

            if (typeRequete == TypeRequeteSQL.SELECT) {
                ResultSet resultSet = this.cursor.getResultSet();
                JsonObject jsonObject = new JsonObject();

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (resultSet.next()) {
                    JsonObject rowObject = new JsonObject();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object columnValue = resultSet.getObject(i);

                        rowObject.addProperty(columnName, columnValue.toString());
                    }

                    jsonObject.add("row", rowObject);
                }

                return jsonObject;
            }



        } catch (SQLException e) {
            System.out.println(String.format("%s: Erreur lors de la récupération de l'entrée de la base de données : %s", this.nameDB, e.getMessage()));
        }

        return null;
    }


    private static void chargerDotenv(String chemin) throws IOException {
        Properties prop = new Properties();
        prop.load(new java.io.FileInputStream(chemin));
        prop.forEach((cle, valeur) -> System.setProperty((String) cle, (String) valeur));
    }


}