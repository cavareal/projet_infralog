package project.modele;

import java.util.ArrayList;
import java.util.List;

public class Aeroport {
    private String pays;
    private String ville;
    private String codeIATA;
    private String nom;
    private short utc;

    public Aeroport(String pays, String ville, String codeIATA, String nom) {
        this.pays = pays;
        this.ville = ville;
        this.codeIATA = codeIATA;
        this.nom = nom;
    }

    public Aeroport() {

    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getCodeIATA() {
        return codeIATA;
    }

    public String getNom() {
        return nom;
    }

    public short getUtc() {
        return utc;
    }

    public void setUtc(short utc) {
        this.utc = utc;
    }

    public void setCodeIATA(String acronyme) {
        this.codeIATA = acronyme;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public List<Aeroport> getAllAeroports(){
    	DAOAeroport daoAeroport = new DAOAeroport();
    	List<Aeroport> aeroports = new ArrayList<>();
    	aeroports = daoAeroport.getAllAeroport();
        return aeroports;
    }
    
//    public short getUtcAeroport(String iata) {
//    	short utc = 0 ; 
//    	DAOAeroport daoAeroport = new DAOAeroport();
//    	utc = daoAeroport.getAeroportByAcronyme(iata);
//    	return utc;
//    }
}

