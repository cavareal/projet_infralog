package project.vue;

import javafx.stage.Stage;
import project.controleur.AjoutGestion;
import project.controleur.RechercheGestion;
import project.modele.Aeroport;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class GardePage {
	
	private static String formattedTime;
	
	public static void pageDeGarde(Stage secondStage) {
		secondStage.setTitle("Page de Garde");
		secondStage.getIcons().add(new Image("file:icon_flybookeseo.png"));

        // Création des onglets
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(createAjouterVolTab(), createHistoriqueTab(), createRechercheTab());

        // Barre de menu
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem monCompteItem = new MenuItem("Mon Compte");
        MenuItem ajoutItem = new MenuItem ("Ajouter un vol");
        MenuItem historiqueItem = new MenuItem("Historique");
        MenuItem rechercheItem = new MenuItem("Recherche");
        
        monCompteItem.setOnAction(event -> {
        	ComptePage.fenetreCompte(new Stage(), secondStage);
        });
        ajoutItem.setOnAction(event -> tabPane.getTabs().add(createAjouterVolTab()));
        historiqueItem.setOnAction(event -> tabPane.getTabs().add(createHistoriqueTab()));
        rechercheItem.setOnAction(event -> tabPane.getTabs().add(createRechercheTab()));
        
        menu.getItems().add(monCompteItem);
        menu.getItems().add(ajoutItem);
        menu.getItems().add(historiqueItem);
        menu.getItems().add(rechercheItem);
        menuBar.getMenus().add(menu);
        
        // Mise en page
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(tabPane);

        Scene scene = new Scene(borderPane, 820, 500);

        // Config de la scène
        secondStage.setScene(scene);
        secondStage.show();
    }

    private static Tab createAjouterVolTab() {
    	// CREATION ONGLET  
        Tab ajouterVolTab = new Tab("Ajouter un Vol");
        
        // CREATIONS COMPOSANTS  
        Label numeroVolLabel = new Label("Numéro de vol :");
        TextField numeroVolField = new TextField();

        Label nombrePlaceLabel = new Label("Nombre de places :");
        TextField nombrePlaceField = new TextField();
        
        Label prixLabel = new Label("Prix du billet standard (€) :");
        TextField prixField = new TextField();
        
        Label decollageLabel = new Label("Décollage :");
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
        ComboBox<String> aeroportsComboBox = createAeroportsComboBox();
        ComboBox<String> aeroportsComboBoxBis = createAeroportsComboBox();
        aeroportsHBox.getChildren().add(aeroportsComboBox);
        aeroportsHBoxBis.getChildren().add(aeroportsComboBoxBis);

        // Creation du calendrier 
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        datePicker.setShowWeekNumbers(true);
        
        // Creation du selecteur de l'heure 
        ComboBox<Integer> hourComboBox = createComboBox(0, 23);
        ComboBox<Integer> minuteComboBox = createComboBox(0, 59);
        HBox root = new HBox(10);
        root.getChildren().add( datePicker);
        HBox heureHbox = new HBox(10);
        heureHbox.getChildren().addAll(heureLabel, hourComboBox, minuteLabel,
        		minuteComboBox);
        ComboBox<Integer> hourComboBoxDuree = createComboBox(0, 23);
        ComboBox<Integer> minuteComboBoxDuree = createComboBox(0, 59);
        HBox heureHboxDuree = new HBox(10);
        heureHboxDuree.getChildren().addAll(heureLabelDuree, hourComboBoxDuree, 
        		minuteLabelDuree,minuteComboBoxDuree);
        
        Button boutonAjout = new Button("Ajouter");
        
        // MISE EN PAGE AVEC GRIDPANE
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.addRow(0, numeroVolLabel, numeroVolField, nombrePlaceLabel, nombrePlaceField);
        gridPane.addRow(2, aeroportDepartLabel, aeroportsHBox);
        gridPane.addRow(3, aeroportArriveeLabel,aeroportsHBoxBis);
        gridPane.addRow(4,decollageLabel,heureHbox, dateLabel,root);
        gridPane.addRow(5, dureeLabel, heureHboxDuree, prixLabel, prixField);
                
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(0,0, 220,0));
        borderPane.setCenter(gridPane);
        borderPane.setBottom(boutonAjout);
        borderPane.setAlignment(boutonAjout, Pos.CENTER);

        // MISE A JOUR DU CONTENU 
        ajouterVolTab.setContent(borderPane);
        
        // FORMATAGE DE LA DATE 
        datePicker.setOnAction(event -> {
            int selectedHour = hourComboBox.getValue();
            int selectedMinute = minuteComboBox.getValue();
            
            LocalTime selectedTime = LocalTime.of(selectedHour, selectedMinute);

            formattedTime = selectedTime.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
            
            //System.out.println("Heure sélectionnée : " + formattedTime);
        });
        
        boutonAjout.setOnAction(e -> AjoutGestion.handleAjout(numeroVolField.getText(),nombrePlaceField.getText(),
        		aeroportsComboBox.getValue(), aeroportsComboBoxBis.getValue(), datePicker.getValue(), formattedTime));

        return ajouterVolTab;
    }

    private static Tab createHistoriqueTab() { // VOL ANTERIEUR A L HEURE COURANTE
        Tab historiqueTab = new Tab("Historique");
        
        // VBox contenant les rectangles d'informations de vol
        VBox flightInfoVBox = createFlightInfoVBox();

        // Défilement de la page
        ScrollPane scrollPane = new ScrollPane(flightInfoVBox);
        scrollPane.setFitToWidth(true);

        // Placeholder content
        //historiqueTab.setContent(createFlight());
        historiqueTab.setContent(scrollPane);

        return historiqueTab;
    }
    
    private static Tab createRechercheTab() { // VOL POSTERIEUR A L HEURE COURANTE
    	Tab RechercheTab = new Tab("Recherche");
    	
    	Label nomLabel = new Label("Nom : ");
    	TextField nomField = new TextField();
    	
    	Label prenomLabel = new Label("Prénom : ");
    	TextField prenomField = new TextField();
    	
    	Label numeroVolLabel = new Label("Numéro de vol : ");
    	TextField numeroVolField = new TextField();
    	
    	Label space1 = new Label("  ");
    	Label space2 = new Label("  ");
    	
    	Label dateLabel = new Label("Date : ");
    	DatePicker datePicker = new DatePicker();
        datePicker.setShowWeekNumbers(true);
        HBox dateHBox = new HBox(10);
        dateHBox.getChildren().addAll(datePicker);
        
        Label aeroportLabel = new Label("Aéroport : ");
        HBox aeroportsHBox = new HBox(10);
        ComboBox<String> aeroportsComboBox = createAeroportsComboBox();
        aeroportsHBox.getChildren().add(aeroportsComboBox);
        CheckBox checkBoxArrivee = new CheckBox("Arrivé");
        CheckBox checkBoxDepart = new CheckBox("Départ");
        
        Button searchButton = new Button("Rechercher");
        
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(0, 0, 20, 0)); // ( ? , ? ,Dessous, ?)
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.addRow(0, nomLabel, nomField, prenomLabel, prenomField);
        gridPane.addRow(1, numeroVolLabel, numeroVolField, dateLabel, dateHBox  );
        gridPane.addRow(2, aeroportLabel,aeroportsHBox,checkBoxDepart,  checkBoxArrivee );
        //gridPane.add(searchButton, 1, 3); // colonne 1 et ligne 3 

        borderPane.setPadding(new Insets(20, 20, 10, 20)); 
        borderPane.setCenter(gridPane);
        borderPane.setBottom(searchButton);
        borderPane.setAlignment(searchButton, Pos.CENTER);
    	
        // VBox contenant les rectangles d'informations de vol
        VBox flightInfoVBox = createFlightInfoVBox();
        ScrollPane scrollPane = new ScrollPane(flightInfoVBox);
        scrollPane.setFitToWidth(true);
        VBox mainVBox = new VBox(borderPane, scrollPane);
        
        searchButton.setOnAction(e -> RechercheGestion.handleRecherche());
        
        // Défilement de la page

        RechercheTab.setContent(mainVBox);

        return RechercheTab;
    	
    }
   
    private static VBox createFlightInfoVBox() {
        VBox vbox = new VBox(10); // Espacement vertical entre les rectangles
        
        // NON PERMANANT : Boucle pour remplir l'histo et voir si le scroll fonctionne
        for (int i = 1; i <= 10; i++) {
        	StackPane rectangleinfo = AffichageVol.createFlightRectangle();
            vbox.getChildren().add(rectangleinfo);
          //getChildren() = liste observable des enfants actuellement présents dans la VBox
        }
        
        return vbox;
    }
    
    protected static ComboBox<Integer> createComboBox(int start, int end) {
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int i = start; i <= end; i++) {
            comboBox.getItems().add(i);
        }
        comboBox.getSelectionModel().select(0); // Sélection de la première valeur par défaut
        return comboBox;
    }
    
    protected static ComboBox<String> createAeroportsComboBox() {
        ComboBox<String> comboBox = new ComboBox<>();
        for (Aeroport[] aeroportArray : Aeroport.aeroportsListe()) {
            Aeroport aeroport = aeroportArray[0];
            String aeroportString = aeroport.getPays() + " - " +
                                     aeroport.getVille() + " - " +
                                     aeroport.getCodeIATA() + " - " +
                                     aeroport.getNom();
            comboBox.getItems().add(aeroportString);
        }
        return comboBox;
    }
   
}
