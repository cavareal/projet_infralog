package project.vue;

import java.time.LocalTime;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import project.controleur.AjoutGestion;
import project.modele.Aeroport;
import project.modele.Vol;

public class ModificationPage {
	
	private static String formattedTimeDecollage;
	private static String formattedTimDuration;
	
	@SuppressWarnings("deprecation")
	public void fenetreModification(Stage stage, Vol vol) {
		
		stage.setTitle("Modification du vol");
		stage.getIcons().add(new Image("file:icon_flybookeseo.png"));
		
		// CREATIONS COMPOSANTS  
        Label numeroVolLabel = new Label("Numéro de vol :");
        Label numeroVol = new Label (vol.getNumeroVol());

        Label modeleLabel = new Label("Modele Avion :");
        
        Label prixLabel = new Label("Prix du billet standard (€) :");
        TextField prixField = new TextField();
        
        Label heureLabel = new Label("H :");
        Label minuteLabel = new Label("m :");
        Label dateLabel = new Label("Date :");
        Label dureeLabel = new Label("Durée du trajet :");
        Label heureLabelDuree = new Label("H :");
        Label minuteLabelDuree = new Label("m :");
        
        
        Label aeroportDepartLabel = new Label("Aéroport de départ :");
        Label aeroportArriveeLabel = new Label("Aéroport d'arrivée :");
        
        // Creation d'une liste déroulante 
        HBox aeroportsHBox = new HBox(10);
        HBox aeroportsHBoxBis = new HBox(10);
        HBox modeleHBox = new HBox(10);
        ComboBox<String> aeroportsComboBox = GardePage.createAeroportsComboBox();
        ComboBox<String> aeroportsComboBoxBis = GardePage.createAeroportsComboBox();
        ComboBox<String> modeleComboBox = GardePage.createComboBoxModeleAvion();
        aeroportsHBox.getChildren().add(aeroportsComboBox);
        aeroportsHBoxBis.getChildren().add(aeroportsComboBoxBis);
        modeleHBox.getChildren().add(modeleComboBox);

        // Creation du calendrier 
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(vol.getDateDepart());
        datePicker.setShowWeekNumbers(true);
        
        // Creation du selecteur de l'heure 
        ComboBox<Integer> hourComboBox = GardePage.createComboBox(0, 23);
        ComboBox<Integer> minuteComboBox = GardePage.createComboBox(0, 59);
        HBox root = new HBox(10);
        root.getChildren().addAll( dateLabel, datePicker);
        HBox heureHbox = new HBox(10);
        heureHbox.getChildren().addAll(heureLabel, hourComboBox, minuteLabel,
        		minuteComboBox);
        ComboBox<Integer> hourComboBoxDuree = GardePage.createComboBox(0, 23);
        ComboBox<Integer> minuteComboBoxDuree = GardePage.createComboBox(0, 59);
        HBox heureHboxDuree = new HBox(10);
        heureHboxDuree.getChildren().addAll(heureLabelDuree, hourComboBoxDuree, 
        		minuteLabelDuree,minuteComboBoxDuree);
        
        Button boutonSauvegarde = new Button("Sauvegarder");
        
        Label problemeChamps = new Label("Tous les champs ne sont pas remplis");
        Label problemeDestination = new Label("La destination d'arrivée et de départ sont identiques");
        problemeChamps.setTextFill(Color.RED);
        problemeDestination.setTextFill(Color.RED);
        
        // MISE EN PAGE AVEC GRIDPANE
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.addRow(0, numeroVolLabel, numeroVol);
        gridPane.addRow(1, modeleLabel, modeleHBox);
        gridPane.addRow(2, aeroportDepartLabel, aeroportsHBox);
        gridPane.addRow(3, aeroportArriveeLabel,aeroportsHBoxBis);
        gridPane.addRow(4,heureHbox, root);
        gridPane.addRow(5, dureeLabel, heureHboxDuree);
        gridPane.addRow(6, prixLabel, prixField) ;
        
        gridPane.addRow(7, boutonSauvegarde);
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20,20,20,20));
        borderPane.setCenter(boutonSauvegarde);
        borderPane.setTop(gridPane);
        BorderPane.setAlignment(boutonSauvegarde, Pos.CENTER);
        
        
        Aeroport aeroport = new Aeroport();
        hourComboBox.setValue(vol.getHeureDepart().getHours());
        minuteComboBox.setValue(vol.getHeureDepart().getMinutes());
        hourComboBoxDuree.setValue(vol.getDureeVol().getHours());
        minuteComboBoxDuree.setValue(vol.getDureeVol().getMinutes());
        modeleComboBox.setValue(vol.getModeleAvion());
        aeroportsComboBox.setValue(aeroport.getAeroportStringByCodeIATA(vol.getDepart()));
        aeroportsComboBoxBis.setValue(aeroport.getAeroportStringByCodeIATA(vol.getArrivee()));
        prixField.setText(String.valueOf(vol.getPrixStandard()));
                
        // FORMATAGE DE LA DATE 
        
        boutonSauvegarde.setOnAction(e -> {
        	int heure = hourComboBox.getValue();
            int minute = minuteComboBox.getValue();
            int dureeHeure = hourComboBoxDuree.getValue();
            int dureeMinute = minuteComboBoxDuree.getValue();
            
            LocalTime decollage = LocalTime.of(heure, minute);
            LocalTime duree = LocalTime.of(dureeHeure, dureeMinute);

            formattedTimeDecollage = decollage.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
            formattedTimDuration = duree.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
            
        	if (modeleComboBox.getValue() == null
        			|| aeroportsComboBox.getValue() == null
        	        || aeroportsComboBoxBis.getValue() == null
        	        || datePicker.getValue() == null
        	        || prixField.getText().isEmpty()) { 
        		borderPane.setBottom(problemeChamps);
            	BorderPane.setAlignment(problemeChamps, Pos.CENTER);
        		
        	}
        	else if (aeroportsComboBox.getValue().equals(aeroportsComboBoxBis.getValue())) {
            	borderPane.setBottom(problemeDestination);
            	BorderPane.setAlignment(problemeDestination, Pos.CENTER);
            }
        	else {
        		AjoutGestion.handleModif(numeroVol.getText(),modeleComboBox.getValue(),
                		aeroportsComboBox.getValue(), aeroportsComboBoxBis.getValue(),
                		prixField.getText(), datePicker.getValue(), formattedTimeDecollage,
                		formattedTimDuration );
        		stage.close();
        	}
        });
		
		Scene scene = new Scene(borderPane, 600, 400);

        // Config de la scène
        stage.setScene(scene);
        stage.show();
	}
	
	
}
