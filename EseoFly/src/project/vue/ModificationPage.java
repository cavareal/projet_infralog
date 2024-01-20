package project.vue;

import java.time.LocalDate;
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
import javafx.stage.Stage;

public class ModificationPage {
	
	private static String formattedTime;
	
	public static void fenetreModification(Stage stage) {
		
		stage.setTitle("Modification du vol");
		stage.getIcons().add(new Image("file:icon_flybookeseo.png"));
		
		// CREATIONS COMPOSANTS  
        Label numeroVolLabel = new Label("Numéro de vol :");
        Label numeroVol = new Label ("num vol à récup");

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
        datePicker.setValue(LocalDate.now());
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
        borderPane.setBottom(boutonSauvegarde);
        borderPane.setCenter(gridPane);
        borderPane.setAlignment(boutonSauvegarde, Pos.CENTER);
        
        // FORMATAGE DE LA DATE 
        datePicker.setOnAction(event -> {
            int selectedHour = hourComboBox.getValue();
            int selectedMinute = minuteComboBox.getValue();
            
            LocalTime selectedTime = LocalTime.of(selectedHour, selectedMinute);

            formattedTime = selectedTime.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
            
            //System.out.println("Heure sélectionnée : " + formattedTime);
        });
        
        boutonSauvegarde.setOnAction(e -> handleSauvegarde(numeroVol.getText(),modeleComboBox.getValue(),
        		aeroportsComboBox.getValue(), aeroportsComboBoxBis.getValue(), datePicker.getValue(), formattedTime));
		
		Scene scene = new Scene(borderPane, 600, 400);

        // Config de la scène
        stage.setScene(scene);
        stage.show();
	}
	
	private static void handleSauvegarde(String numeroVolField, String nombrePlaceField,
    		String aeroportDepartField, String aeroportArriveeField, LocalDate date, String heureDecollageField) {
		// VERIF TOUS LES CHAMPS BIEN COMPLETER 
		
		// IMPOSSIBILITE DE CHANGER LE NUMERO DE VOL 
		
		// MODIF DE LA BDD
		
		// MAJ DE LA BDD 
		
		// FERMETURE DE LA FENETRE 
	}
	
	
}
