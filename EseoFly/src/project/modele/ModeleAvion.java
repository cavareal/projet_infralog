package project.modele;

import com.google.gson.JsonObject;

public class ModeleAvion {
    private String modele;
    private int nbColonnes;
    private int nbPassager;
    private int nbPremiereClasse;
    private ConnexionBdd connexionDB;

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
