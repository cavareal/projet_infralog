package project.modele;

public class Employe {
    private int id;
    private String email;
    private boolean administrateur;
    private String nom;
    private String prenom;
    private String password;
    private ConnexionBdd connexionDB;

    //Constructeur

    public Employe(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Employe(int id, String email, boolean administrateur, String nom, String prenom) {
        this.id = id;
        this.email = email;
        this.administrateur = administrateur;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Accesseurs
//    public int getId() {
//        String requete = String.format("SELECT id FROM Employe WHERE email = '%s' and motDePasse = '%s", email, password);
//        JsonObject result = connexionDB.executionRequeteSQL(TypeRequeteSQL.SELECT, "Employe", requete);
//        id = result.getAsInt();
//        return id;
//    }

    public String getEmail() {
//        String requete = String.format("SELECT email FROM Employe WHERE email = '%s' and motDePasse = '%s", email, motDePasse);
//        JsonObject result = connexionDB.executionRequeteSQL(TypeRequeteSQL.SELECT, "Employe", requete);
//        email = result.getAsString();
        return email;
    }

//    public boolean isAdministrateur() {
//        String requete = String.format("SELECT administrateur FROM Employe WHERE email = '%s' and motDePasse = '%s", email, password);
//        JsonObject result = connexionDB.executionRequeteSQL(TypeRequeteSQL.SELECT, "Employe", requete);
//        administrateur = result.getAsBoolean();
//        return administrateur;
//    }

//    public String getNom() {
//        String requete = String.format("SELECT nom FROM Employe WHERE email = '%s' and motDePasse = '%s", email, password);
//        JsonObject result = connexionDB.executionRequeteSQL(TypeRequeteSQL.SELECT, "Employe", requete);
//        nom = result.getAsString();
//        return nom;
//    }
//
//    public String getPrenom() {
//        String requete = String.format("SELECT prenom FROM Employe WHERE email = '%s' and motDePasse = '%s", email, password);
//        JsonObject result = connexionDB.executionRequeteSQL(TypeRequeteSQL.SELECT, "Employe", requete);
//        prenom = result.getAsString();
//        return prenom;
//    }

    public String getPassword() {
//        String requete = String.format("SELECT motDePasse FROM Employe WHERE email = '%s' and motDePasse = '%s", email, motDePasse);
//        JsonObject result = connexionDB.executionRequeteSQL(TypeRequeteSQL.SELECT, "Employe", requete);
//        motDePasse = result.getAsString();
        return password;
    }


    public void setId(short id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
