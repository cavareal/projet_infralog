package project.modele;

public class Employe {
	
    private String email;
    private boolean administrateur;
    private String nom;
    private String prenom;
    private String motDePasse; 
    private String[] donnees = new String[6];


    public Employe(String email, String motDePasse) {
    	DAOEmploye daoEmploye = new DAOEmploye();
    	donnees = daoEmploye.getEmploye(email, motDePasse);
        this.email = donnees[0];
        this.administrateur = (donnees[1]=="1") ? true : false;
        this.nom = donnees[2];
        this.prenom = donnees[3];
        this.motDePasse = donnees[4];
    }
    
    public String[] getDonnees() {
    	return this.donnees;
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

    public String getEmail() {
        return email;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
    
    

}