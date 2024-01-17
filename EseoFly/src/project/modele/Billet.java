package EseoFly.src.project.modele;

import com.google.gson.JsonObject;

public class Billet {
    private int numeroReservation;
    private int idClient;
    private String numeroVol;
    private int bagages;
    private int prix;
    private boolean garantie;
    private String place;

    public Billet(int numeroReservation, int idClient, String numeroVol, int bagages, int prix, boolean garantie, String place) {
        this.numeroReservation = numeroReservation;
        this.idClient = idClient;
        this.numeroVol = numeroVol;
        this.bagages = bagages;
        this.prix = prix;
        this.garantie = garantie;
        this.place = place;
    }

    // Accesseurs
    public int getNumeroReservation() {
        return numeroReservation;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public int getBagages() {
        return bagages;
    }

    public int getPrix() {
        return prix;
    }

    public boolean isGarantie() {
        return garantie;
    }

    public String getPlace() {
        return place;
    }


    public Billet getBilletByNumeroReservation(int numeroReservation, ConnexionDatabase connexionDB) {
        String requete = String.format("SELECT * FROM EseoFly.src.project.modele.Billet WHERE numeroReservation = %d", numeroReservation);
        JsonObject result = connexionDB.executionRequeteSQL(TypeRequeteSQL.SELECT, "EseoFly.src.project.modele.Billet", requete);
        return null;
    }
}
