package project.modele;

public class Vol {

	private String numeroVol;
	private String date;
	private String heureDecollage;
	private String aeroportDepart;
	private String aeroportArrive;
	private String heureArrivee;
	private int nbPlace;
	private int nbPlaceAchetee;
	private String dureeVol;


	public Vol (String numeroVol, String date, String heureDecollage, String aeroportDepart,
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeureDecollage() {
		return heureDecollage;
	}

	public void setHeureDecollage(String heureDecollage) {
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

	public String getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public String getDureeVol() {
		return dureeVol;
	}

	public void setDureeVol(String dureeVol) {
		this.dureeVol = dureeVol;
	}
	
	
}

