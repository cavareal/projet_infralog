package project.modele;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Vol {

	private String numeroVol;
//		private Date date;
	private Time heureDepart;
	private Time heureArrivee;
	private Date dateDepart;
	private Date dateArrivee;

	private String depart;
	private String arrivee;
	private int nbPlace;
	private int nbPlaceAchetee;
	private Time dureeVol;
	private int utc;
	private String modeleAvion;
//
	private String heureDecollage;
	private String date;
	private Timestamp dateHeureLocaleDepart;
	private Timestamp dateHeureLocaleArrivee;


	public Vol(){
	}

	public Vol (String numeroVol, Timestamp dateHeureLocaleDepart, Timestamp dateHeureLocaleArrivee, String depart,
				String arrivee, int nbPlace, int nbPlaceAchetee ) {
		this.numeroVol = numeroVol;
		this.dateHeureLocaleDepart = dateHeureLocaleDepart;
		this.dateHeureLocaleArrivee = dateHeureLocaleArrivee;
		this.arrivee = arrivee;
		this.depart = depart;
		this.nbPlace = nbPlace;
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

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
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

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getModeleAvion() {
		return modeleAvion;
	}

	public void setModeleAvion(String modeleAvion) {
		this.modeleAvion = modeleAvion;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public String getHeureDecollage() {
		return heureDecollage;
	}

	public void setHeureDecollage(String heureDecollage) {
		this.heureDecollage = heureDecollage;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDateHeureLocaleDepart(Timestamp dateHeureLocaleDepart) {
		this.dateHeureLocaleDepart = dateHeureLocaleDepart;
	}

	public Timestamp getDateHeureLocaleDepart() {
		return dateHeureLocaleDepart;
	}

	public void setDateHeureLocaleArrivee(Timestamp dateHeureLocaleArrivee) {
		this.dateHeureLocaleArrivee = dateHeureLocaleArrivee;
	}

	public Timestamp getDateHeureLocaleArrivee() {
		return dateHeureLocaleArrivee;
	}
}

