package project.controleur;

import javafx.stage.Stage;
import project.modele.DAOEmploye;
import project.modele.Employe;

public class InscriptionGestion {


	public static boolean confirmationMotDePasse(String motDePasse, String motDePasseConfirmation){
		boolean motDePasseIdentique = false;
		if (motDePasse.equals(motDePasseConfirmation)){
			motDePasseIdentique = true;
		}
		return motDePasseIdentique;
	}


	public static boolean verifierConditionsMotDePasse(String motDePasse) {
		boolean respectConditionsMotDePasse = true;
		if (!motDePasse.matches(".*[A-Z].*")) {
			respectConditionsMotDePasse = false;
		}
		if (!motDePasse.matches(".*[a-z].*")) {
			respectConditionsMotDePasse = false;
		}
		if (!motDePasse.matches(".*[0-9].*")) {
			respectConditionsMotDePasse = false;
		}
		if (!motDePasse.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?].*")) {
			respectConditionsMotDePasse = false;
		}
		return respectConditionsMotDePasse;
	}


	public static boolean verifierAdresseEmail(String email) {
		boolean domaineCorrect = email.endsWith("@reseau.eseo.fr") || email.endsWith("@eseo.fr");
		boolean commenceParLettre = Character.isLetter(email.charAt(0));
		return domaineCorrect && commenceParLettre;
	}


	public static boolean ensembleChampsRenseignes(String nom, String prenom, String email, String motDePasse, String motDePasseConfirmation) {
		boolean champsRenseignes = !nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !motDePasse.isEmpty() && !motDePasseConfirmation.isEmpty();
		return champsRenseignes;
	}

	public static boolean emailDejaUtilise(String email){
		boolean estEmailDejaUtilise = false;
        try {
            DAOEmploye daoEmploye = new DAOEmploye();
			System.out.println(daoEmploye.getEmployeExistantByEmail(email));
            if (daoEmploye.getEmployeExistantByEmail(email)) {
                estEmailDejaUtilise = true;
            }
        } catch (Exception e){
			e.printStackTrace();
		}
		return estEmailDejaUtilise;
	}

	public static boolean inscriptionEffectuee(String nom, String prenom, String email, String motDePasse, boolean administrateur){
		boolean utilisateurInscrit = false;
		try{
			DAOEmploye daoEmploye = new DAOEmploye();
			Employe employe = new Employe(nom, prenom, email, motDePasse, administrateur);
			utilisateurInscrit = daoEmploye.addEmploye(employe);
		} catch (Exception e){
			e.printStackTrace();
		}
		return utilisateurInscrit;
    }

	public static void redirection2(Stage primaryStage) {
		ConnexionGestion.redirection(primaryStage);
	}


}
