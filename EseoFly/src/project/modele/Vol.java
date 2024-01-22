package project.modele;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import project.modele.DAO.DAOVol;

public class Vol {

	private String numeroVol;
//		private Date date;
	private Time heureDepart;
	private Time heureArrivee;
	private LocalDate dateDepart;
	private LocalDate dateArrivee;

	private String depart;
	private String arrivee;
	private int nbPlaceAchetee;
	private Time dureeVol;
	private String modeleAvion;
	
	private Timestamp dateHeureLocaleDepart;
	private Timestamp dateHeureLocaleArrivee;
	private int prixStandard;
	
	private static List<String> numerosVol = new ArrayList<>();

	public Vol(){
	}

	public Vol (String numeroVol, String modeleAvion, Timestamp dateHeureLocaleDepart,
			Timestamp dateHeureLocaleArrivee, String depart, String arrivee, int prixStandard ) {
		this.numeroVol = numeroVol;
		this.dateHeureLocaleDepart = dateHeureLocaleDepart;
		this.dateHeureLocaleArrivee = dateHeureLocaleArrivee;
		this.arrivee = arrivee;
		this.depart = depart;
		this.modeleAvion = modeleAvion;
		this.prixStandard = prixStandard;
	}


	public String getNumeroVol() {
		return numeroVol;
	}

	public void setNumeroVol(String numeroVol) {
		this.numeroVol = numeroVol;
	}

	public Time getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getArrivee() {
		return arrivee;
	}

	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}

	public int getNbPlaceAchetee() {
		return nbPlaceAchetee;
	}

	public void setNbPlaceAchetee(int nbPlaceAchetee) {
		this.nbPlaceAchetee = nbPlaceAchetee;
	}

	public Time getDureeVol() {
		return dureeVol;
	}

	public void setDureeVol(Time dureeVol) {
		this.dureeVol = dureeVol;
	}

	public Time getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Time heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getModeleAvion() {
		return modeleAvion;
	}

	public void setModeleAvion(String modeleAvion) {
		this.modeleAvion = modeleAvion;
	}

	public LocalDate getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Timestamp getDateHeureLocaleDepart() {
		return dateHeureLocaleDepart;
	}


	public Timestamp getDateHeureLocaleArrivee() {
		return dateHeureLocaleArrivee;
	}
	
	public void setDateHeureLocaleDepart(Timestamp dateHeureLocaleDepart) {
		this.dateHeureLocaleDepart = dateHeureLocaleDepart;
        Instant instantDepart = dateHeureLocaleDepart.toInstant();
        this.heureDepart = new Time(instantDepart.toEpochMilli());
        this.dateDepart = instantDepart.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void setDateHeureLocaleArrivee(Timestamp dateHeureLocaleArrivee) {
    	this.dateHeureLocaleArrivee = dateHeureLocaleArrivee;
        Instant instantArrivee = dateHeureLocaleArrivee.toInstant();
        this.heureArrivee = new Time(instantArrivee.toEpochMilli());
        this.dateArrivee = instantArrivee.atZone(ZoneId.systemDefault()).toLocalDate();
    }

	public int getPrixStandard() {
		return prixStandard;
	}

	public void setPrixStandard(int prixStandard) {
		this.prixStandard = prixStandard;
	}
	
	public static List<Vol> getAllVols() {
		List<Vol> vols;
		DAOVol daoVol = new DAOVol();
		vols = daoVol.getAllVols();
		return vols;
	}
	
	public List<String> getNumerosVol() {
		return numerosVol;
	}

	public static void removeNumeroVol(String numeroVolToRemove) {
	    numerosVol.remove(numeroVolToRemove);
	}

	public Boolean addVol(Vol vol,short utcDepart, short utcArrivee) {
		DAOVol daoVol = new DAOVol();
		return daoVol.addVol(vol, utcDepart, utcArrivee);
	}
	
	public void update(Vol vol, short utcDepart, short utcArrivee) {
		DAOVol daoVol = new DAOVol();
		daoVol.updateVol(vol, utcDepart, utcArrivee);
	}
	
	public List<Vol> search(String nom, String prenom, String numeroVol, String date, 
			String aeroport, boolean depart, boolean arrivee) {
		DAOVol daoVol = new DAOVol();
		List<Vol> vols;
		vols = daoVol.searchVols(nom, prenom, numeroVol, date, aeroport, depart, arrivee);
		return vols;
	}
	
	public static List<String> generateNumerosVol() {
	    List<Vol> vols = getAllVols();

	    for (int i = 0; i <= 999; i++) {
	    	String numeroVol = "B737" + String.format("%04d", i);
	        if (!containsNumeroVol(vols, numeroVol)) {
	            numerosVol.add(numeroVol);
	        }
	    }
	    return numerosVol;
	}

	private static boolean containsNumeroVol(List<Vol> vols, String numeroVol) {
	    for (Vol vol : vols) {
	        if (vol.getNumeroVol().equals(numeroVol)) {
	            return true;
	        }
	    }
	    return false;
	}

	
}

