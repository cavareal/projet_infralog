package project.vue;

import javafx.stage.Stage;
import project.modele.Aeroport;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;

public class GardePage {
	
	private static String formattedTime;
	
	public static void pageDeGarde(Stage secondStage) {
		secondStage.setTitle("Page de Garde");

        // Création des onglets
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(createAjouterVolTab(), createHistoriqueTab(), createAVenirTab());

        // Barre de menu
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem monCompteItem = new MenuItem("Mon Compte");
        MenuItem ajoutItem = new MenuItem ("Ajouter un vol");
        MenuItem historiqueItem = new MenuItem("Historique");
        MenuItem aVenirItem = new MenuItem("A Venir");
        
        monCompteItem.setOnAction(event -> handleMonCompteClick(secondStage));
        ajoutItem.setOnAction(event -> tabPane.getTabs().add(createAjouterVolTab()));
        historiqueItem.setOnAction(event -> tabPane.getTabs().add(createHistoriqueTab()));
        aVenirItem.setOnAction(event -> tabPane.getTabs().add(createAVenirTab()));
        
        menu.getItems().add(monCompteItem);
        menu.getItems().add(ajoutItem);
        menu.getItems().add(historiqueItem);
        menu.getItems().add(aVenirItem);
        menuBar.getMenus().add(menu);
        
        // Mise en page
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(tabPane);

        Scene scene = new Scene(borderPane, 600, 400);

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
        
        Label heureLabel = new Label("H :");
        Label minuteLabel = new Label("m :");
        Label dateLabel = new Label("Date :");
        
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
        root.getChildren().addAll( dateLabel, datePicker);
        HBox heureHbox = new HBox(10);
        heureHbox.getChildren().addAll(heureLabel, hourComboBox, minuteLabel,
        		minuteComboBox);
        
        Button boutonAjout = new Button("Ajouter");
        
        // MISE EN PAGE AVEC GRIDPANE
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.addRow(0, numeroVolLabel, numeroVolField);
        gridPane.addRow(1, nombrePlaceLabel, nombrePlaceField);
        gridPane.addRow(2, aeroportDepartLabel, aeroportsHBox);
        gridPane.addRow(3, aeroportArriveeLabel,aeroportsHBoxBis);
        gridPane.addRow(4,heureHbox, root);
        gridPane.addRow(5, boutonAjout);

        // MISE A JOUR DU CONTENU 
        ajouterVolTab.setContent(gridPane);
        
        // FORMATAGE DE LA DATE 
        datePicker.setOnAction(event -> {
            int selectedHour = hourComboBox.getValue();
            int selectedMinute = minuteComboBox.getValue();
            
            LocalTime selectedTime = LocalTime.of(selectedHour, selectedMinute);

            formattedTime = selectedTime.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
            
            //System.out.println("Heure sélectionnée : " + formattedTime);
        });
        
        boutonAjout.setOnAction(e -> handleAjout(numeroVolField.getText(),nombrePlaceField.getText(),
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
    
    private static Tab createAVenirTab() { // VOL POSTERIEUR A L HEURE COURANTE
    	Tab aVenirTab = new Tab("A Venir");
        
        // VBox contenant les rectangles d'informations de vol
        VBox flightInfoVBox = createFlightInfoVBox();

        // Défilement de la page
        ScrollPane scrollPane = new ScrollPane(flightInfoVBox);
        scrollPane.setFitToWidth(true);

        // Placeholder content
        aVenirTab.setContent(scrollPane);

        return aVenirTab;
    	
    }
    
    private static void handleAjout(String numeroVolField, String nombrePlaceField,
    		String aeroportDepartField, String aeroportArriveeField, LocalDate date, String heureDecollageField) {
    	// Gestion de l'ajout des vols dans la BDD
    	
    	System.out.println("Envoie des données");
    	
    	// Vérification si le vol n'est pas déjà présent dans la BDD 
    }
    
    private static void handleMonCompteClick(Stage secondStage) {    	
    	ComptePage.fenetreCompte(new Stage());
    }
    
    
    
    private static VBox createFlightInfoVBox() {
        VBox vbox = new VBox(10); // Espacement vertical entre les rectangles
        
        // NON PERMANANT : Boucle pour remplir l'histo et voir si le scroll fonctionne
        for (int i = 1; i <= 10; i++) {
        	StackPane rectangleinfo = createFlightRectangle();
            vbox.getChildren().add(rectangleinfo);
          //getChildren() = liste observable des enfants actuellement présents dans la VBox
        }
        
        return vbox;
    }
    
    private static StackPane createFlightRectangle() {
    	
    	// RECUPERATION DES VRAIES INFOS 
    	
    	String numeroVol = "FR34";
    	String date = "01-02-2024";
    	String heureDecollage ="6:11";
    	String aeroportDepart = "Paris";
    	String aeroportArrive = "Marseille";
    	String nbPlace= "Nb de place : " + "122";
    	String nbPlaceAchetee="Nb de place achetée : " + "97";
    	
    	Rectangle rectangle = new Rectangle(350,50);
        rectangle.setFill(Color.LIGHTGRAY);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1);
        
        // RECUPERATION DES DONNEES DE VOL
        Text text = new Text(numeroVol + "    " + date +"    " + heureDecollage + "\n"
        		+ aeroportDepart + " To " + aeroportArrive + "\n" 
        		+ nbPlace + "   "+ nbPlaceAchetee);
        text.setWrappingWidth(280); // Largeur maximale avant le retour à la ligne
        
        // StackPane pour superposer le rectangle et le texte 
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, text);
        
        return stackPane;
    }
    
    private static ComboBox<Integer> createComboBox(int start, int end) {
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int i = start; i <= end; i++) {
            comboBox.getItems().add(i);
        }
        comboBox.getSelectionModel().select(0); // Sélection de la première valeur par défaut
        return comboBox;
    }
    
    private static ComboBox<String> createAeroportsComboBox() {
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
