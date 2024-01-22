package project.controleur;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import project.modele.Vol;

public class AjoutGestion {
	
	private static Vol vol;
	
    @SuppressWarnings("static-access")
	public static boolean handleAjout(String numeroVol, String modeleAvion,
    		String aeroportDepartField, String aeroportArriveeField, String prix,
    		LocalDate date,String heureDecollage, String duration) {
    	
    	String dateTimeDecollage = date + " " + heureDecollage;
    	String dateTimeDuration = date + " " + duration;
    	Timestamp timestamp = null;
    	Timestamp timestampDuration = null;
    	Time heure = null;
    	
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat dateFormatHeure = new SimpleDateFormat("HH:mm");
            Date duree = dateFormatHeure.parse(duration);
            Date decollageDate = dateFormat.parse(dateTimeDecollage);
            Date durationDate = dateFormat.parse(dateTimeDuration);
            
            long tempsEnMillisecondes = duree.getTime();
            heure = new Time(tempsEnMillisecondes);

            // Convert Date to Timestamp
            timestamp = new Timestamp(decollageDate.getTime());
            timestampDuration = new Timestamp(durationDate.getTime());
            
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the exception based on your application's requirements
        }
        
        
        short utcDepart =  Short.parseShort(Objects.requireNonNull(getUtcDepuisChaine(aeroportDepartField)));
        short utcArrivee = Short.parseShort(Objects.requireNonNull(getUtcDepuisChaine(aeroportArriveeField))) ;
        
        String iataDepart = extraireCodeIATA(aeroportDepartField);
        String iataArrivee = extraireCodeIATA(aeroportArriveeField);
    	
    	vol = new Vol(numeroVol,modeleAvion,timestamp,timestampDuration,iataDepart, 
    			iataArrivee, Integer.parseInt(prix));
    	vol.setDureeVol(heure);
    	if(vol.addVol(vol, utcDepart, utcArrivee)) {
    		vol.removeNumeroVol(numeroVol);
    		return true;
    	}
    	return false;
    }
    
    public static void handleModif(String numeroVol, String modeleAvion,
    		String aeroportDepartField, String aeroportArriveeField, String prix,
    		LocalDate date,String heureDecollage, String duration) {
    	// Gestion de l'ajout des vols dans la BDD
    	
    	String dateTimeDecollage = date + " " + heureDecollage;
    	String dateTimeDuration = date + " " + duration;
    	Timestamp timestamp = null;
    	Timestamp timestampDuration = null;
    	Time heure = null;
    	
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat dateFormatHeure = new SimpleDateFormat("HH:mm");
            Date duree = dateFormatHeure.parse(duration);
            Date decollageDate = dateFormat.parse(dateTimeDecollage);
            Date durationDate = dateFormat.parse(dateTimeDuration);
            
            long tempsEnMillisecondes = duree.getTime();
            heure = new Time(tempsEnMillisecondes);

            // Convert Date to Timestamp
            timestamp = new Timestamp(decollageDate.getTime());
            timestampDuration = new Timestamp(durationDate.getTime());
            
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the exception based on your application's requirements
        }
        
        
        short utcDepart =  Short.parseShort(Objects.requireNonNull(getUtcDepuisChaine(aeroportDepartField)));
        short utcArrivee = Short.parseShort(Objects.requireNonNull(getUtcDepuisChaine(aeroportArriveeField))) ;
        
        String iataDepart = extraireCodeIATA(aeroportDepartField);
        String iataArrivee = extraireCodeIATA(aeroportArriveeField);
    	
    	vol = new Vol(numeroVol,modeleAvion,timestamp,timestampDuration,iataDepart, 
    			iataArrivee, Math.abs(Integer.parseInt(prix)));
    	vol.setDureeVol(heure);
    	vol.update(vol, utcDepart, utcArrivee);
    	
    }
    
    private static String getUtcDepuisChaine(String aeroportString) {
        // En supposant que l'offset UTC est à la fin de la chaîne après "UTC"
        int indexOfUTC = aeroportString.indexOf("UTC");
        if (indexOfUTC != -1) {
            return aeroportString.substring(indexOfUTC + 3).trim();
        } else {
            // Gérer le cas où "UTC" n'est pas trouvé dans la chaîne
            return null;
        }
    }
    
    public static String extraireCodeIATA(String aeroportString) {
        String[] elements = aeroportString.split(" - ");
        if (elements.length >= 3) {
            return elements[1]; // Le code IATA est le deuxième élément dans la chaîne séparée par " - "
        } else {
            return null; // Gérer le cas où le format de la chaîne est différent de ce à quoi on s'attend
        }
    }

    
    
}
