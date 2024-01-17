package EseoFly.src.project.modele;

import java.sql.Date;
import java.sql.Time;

public class Vol {

	private String numeroVol;
	private Date date;
	private Time heureDecollage;
	private String aeroportDepart;
	private String aeroportArrive;
	private int nbPlace;
	private int nbPlaceAchetee;
	private Time dureeVol;
	private int utc;

	public Vol(){
	}

	public Vol (String numeroVol, Date date, Time heureDecollage, String aeroportDepart,
				String aeroportArrive, int nbPlace, int nbPlaceAchetee ) {
		this.numeroVol = numeroVol;
		this.date = date;
		this.heureDecollage = heureDecollage;
		this.aeroportArrive = aeroportArrive;
		this.aeroportDepart = aeroportDepart;
		this.nbPlace = nbPlace;
		this.nbPlaceAchetee = nbPlaceAchetee;

	}

	public String getNumeroVol() {
		return numeroVol;
	}

	public void setNumeroVol(String numeroVol) {
		this.numeroVol = numeroVol;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHeureDecollage() {
		return heureDecollage;
	}

	public void setHeureDecollage(Time heureDecollage) {
		this.heureDecollage = heureDecollage;
	}

	public String getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(String aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public String getAeroportArrive() {
		return aeroportArrive;
	}

	public void setAeroportArrive(String aeroportArrive) {
		this.aeroportArrive = aeroportArrive;
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


}

