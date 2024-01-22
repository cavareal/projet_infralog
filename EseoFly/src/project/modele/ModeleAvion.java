package project.modele;

import java.util.ArrayList;
import java.util.List;

import project.modele.DAO.DAOModeleAvion;

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
    
    public ModeleAvion() {
    	
    }

    // Accesseurs
    public String getModele() {
        return modele;
    }
    
    public void setModele(String mod) {
        this.modele=mod;
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
    
    public List<ModeleAvion> getAllModele(){
    	List<ModeleAvion> mod;
    	DAOModeleAvion dao = new DAOModeleAvion();
    	mod = dao.getAllModele();
    	return mod ;
    }


}