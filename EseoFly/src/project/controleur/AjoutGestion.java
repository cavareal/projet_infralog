package project.controleur;

import java.time.LocalDate;

public class AjoutGestion {
	
    public static void handleAjout(String numeroVolField, String nombrePlaceField,
    		String aeroportDepartField, String aeroportArriveeField, LocalDate date, String heureDecollageField) {
    	// Gestion de l'ajout des vols dans la BDD
    	
    	System.out.println("Envoie des données");
    	
    	// Vérification si le vol n'est pas déjà présent dans la BDD 
    	// Verif que tous les champs soient bien non vide 
    }
}
