package project.modele;

public class BddRecuperation {
	
	public String[] donneesVol() {
		
		// A REFAIRE : FAIRE UN TABLEAU DE VOL QUI EST UN TABLEAU DE DONNEES DE VOL
		
		
		String numeroVol = "";
    	String date = "";
    	String heureDecollage = "";
    	String aeroportDepart = "";
    	String aeroportArrive = "";
    	String nbPlace = "";
    	String nbPlaceAchetee ="";
		String[] vol;
		
		vol = new String[6];
		
		// RECUPERATION DES DONNEES DE LA BDD
		
		numeroVol = "FR56";
    	date = "21-01-24";
    	heureDecollage = "6:13";
    	aeroportDepart = "Paris";
    	aeroportArrive = "Marseille";
    	nbPlace = "122";
    	nbPlaceAchetee ="89";
		
		// AJOUT 
		vol[0] = numeroVol;
		vol[1] = date;
		vol[2] = heureDecollage;
		vol[3] = aeroportDepart;
		vol[4] = aeroportArrive;
		vol[5] = nbPlace;
		vol[6] = nbPlaceAchetee;
		
		return vol;
		
	}

}
