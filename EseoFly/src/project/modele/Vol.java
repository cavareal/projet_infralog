package project.modele;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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
	private int utc;
	private String modeleAvion;
	
	private Timestamp dateHeureLocaleDepart;
	private Timestamp dateHeureLocaleArrivee;

	public Vol(){
	}

	public Vol (String numeroVol, Timestamp dateHeureLocaleDepart, Timestamp dateHeureLocaleArrivee, String depart,
				String arrivee, int nbPlaceAchetee ) {
		this.numeroVol = numeroVol;
		this.dateHeureLocaleDepart = dateHeureLocaleDepart;
		this.dateHeureLocaleArrivee = dateHeureLocaleArrivee;
		this.arrivee = arrivee;
		this.depart = depart;
		this.nbPlaceAchetee = nbPlaceAchetee;
	}


	public String getNumeroVol() {
		return numeroVol;
	}

	public void setNumeroVol(String numeroVol) {
		this.numeroVol = numeroVol;
	}

//		public Date getDate() {
//			return date;
//		}
//
//		public void setDate(Date date) {
//			this.date = date;
//		}

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

	public int getUtc(){
		return this.utc;
	}

	public void setUtc(int utc){
		this.utc = utc;
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
	
	public List<Vol> getAllVols() {
		List<Vol> vols = new ArrayList<>();
		DAOVol daoVol = new DAOVol();
		vols = daoVol.getAllVols();
		return vols;
	}

	
	
}

