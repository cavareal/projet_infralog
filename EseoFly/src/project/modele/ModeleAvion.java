package project.modele;

public class ModeleAvion {
    private String modele;
    private int nbColonnes;
    private int nbPassager;
    private int nbPremiereClasse;

    public ModeleAvion(String modele, int nbColonnes, int nbPassager, int nbPremiereClasse) {
        this.modele = modele;
        this.nbColonnes = nbColonnes;
        this.nbPassager = nbPassager;
        this.nbPremiereClasse = nbPremiereClasse;
    }

    // Accesseurs
    public String getModele() {
        return modele;
    }

    public int getNbPremiereClasse() {
        return nbPremiereClasse;
    }

    public void setNbPremiereClasse(int nbPremiereClasse) {
        this.nbPremiereClasse = nbPremiereClasse;
    }

    public int getNbPassager() {
        return nbPassager;
    }

    public void setNbPassager(int nbPassager) {
        this.nbPassager = nbPassager;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public void setNbColonnes(int nbColonnes) {
        this.nbColonnes = nbColonnes;
    }

//    public int getNbColonnes() {
//        String requete = String.format("SELECT nbColonnes FROM ModeleAvion WHERE modele = '%s'", modele);
//        JsonObject result = connexionDB.executionRequeteSQL(TypeRequeteSQL.SELECT, "ModeleAvion", requete);
//        nbColonnes = result.getAsInt();
//        return nbColonnes;
//    }
//
//    public int getNbPassager() {
//        String requete = String.format("SELECT nbPassager FROM ModeleAvion WHERE modele = '%s'", modele);
//        JsonObject result = connexionDB.executionRequeteSQL(TypeRequeteSQL.SELECT, "ModeleAvion", requete);
//        nbPassager = result.getAsInt();
//        return nbPassager;
//    }
//
//    public int getNbPremiereClasse() {
//        String requete = String.format("SELECT nbPremiereClasse FROM ModeleAvion WHERE modele = '%s'", modele);
//        JsonObject result = connexionDB.executionRequeteSQL(TypeRequeteSQL.SELECT, "ModeleAvion", requete);
//        nbPremiereClasse = result.getAsInt();
//        return nbPremiereClasse;
//    }



}