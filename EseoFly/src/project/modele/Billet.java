package project.modele;


public class Billet {
    private String numeroReservation;
    private int idClient;
    private String numeroVol;
    private boolean bagages;
    private int prix;
    private boolean garantie;
    private String place;
    private String nomPassager;
    private String prenomPassager;
    private int agePassager;

    public Billet(String numeroReservation, int idClient, String numeroVol, boolean bagages, int prix, boolean garantie, String place) {
        this.numeroReservation = numeroReservation;
        this.idClient = idClient;
        this.numeroVol = numeroVol;
        this.bagages = bagages;
        this.prix = prix;
        this.garantie = garantie;
        this.place = place;
    }

    public Billet(String numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public Billet() {

    }

    // Accesseurs
    public String getNumeroReservation() {
        return numeroReservation;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNumeroVol() {
        return numeroVol;
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

    public void setNumeroReservation(String numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }


    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public void setBagages(boolean bagages) {
        this.bagages = bagages;
    }

    public boolean isBagages() {
        return bagages;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setGarantie(boolean garantie) {
        this.garantie = garantie;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setNomPassager(String nomPassager) {
        this.nomPassager = nomPassager;
    }

    public String getNomPassager() {
        return nomPassager;
    }

    public void setPrenomPassager(String prenomPassager) {
        this.prenomPassager = prenomPassager;
    }

    public String getPrenomPassager() {
        return prenomPassager;
    }

    public void setAgePassager(int agePassager) {
        this.agePassager = agePassager;
    }

    public int getAgePassager() {
        return agePassager;
    }
}
