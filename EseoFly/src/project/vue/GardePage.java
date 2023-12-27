package project.vue;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class GardePage {
	
	public static void pageDeGarde(Stage secondStage) {
		secondStage.setTitle("Page de Garde");

        // Création des onglets
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(createAjouterVolTab(), createHistoriqueTab());

        // Barre de menu
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem monCompteItem = new MenuItem("Mon Compte");
        
        monCompteItem.setOnAction(event -> handleMonCompteClick(secondStage));
        
        menu.getItems().add(monCompteItem);
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
        Tab ajouterVolTab = new Tab("Ajouter un Vol");

        
        Label numeroVolLabel = new Label("Numéro de vol:");
        TextField numeroVolField = new TextField();

        Label nombrePlaceLabel = new Label("Nombre de places:");
        TextField nombrePlaceField = new TextField();

        Label aeroportDepartLabel = new Label("Aéroport de départ:");
        TextField aeroportDepartField = new TextField();

        Label aeroportArriveeLabel = new Label("Aéroport d'arrivée:");
        TextField aeroportArriveeField = new TextField();

        Label heureDecollageLabel = new Label("Heure de décollage:");
        TextField heureDecollageField = new TextField();
        
        Button boutonAjout = new Button("Ajouter");
        

        // Mise en page avec GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.addRow(0, numeroVolLabel, numeroVolField);
        gridPane.addRow(1, nombrePlaceLabel, nombrePlaceField);
        gridPane.addRow(2, aeroportDepartLabel, aeroportDepartField);
        gridPane.addRow(3, aeroportArriveeLabel, aeroportArriveeField);
        gridPane.addRow(4, heureDecollageLabel, heureDecollageField);
        gridPane.addRow(5, boutonAjout);

        // Placeholder content
        ajouterVolTab.setContent(gridPane);
        
        boutonAjout.setOnAction(e -> handleAjout(numeroVolField.getText(),nombrePlaceField.getText(),
        		aeroportDepartField.getText(), aeroportArriveeField.getText(), heureDecollageField.getText()));

        return ajouterVolTab;
    }

    private static Tab createHistoriqueTab() {
        Tab historiqueTab = new Tab("Historique");

        // Ajoutez les composants nécessaires pour l'onglet "Historique" ici
        // Par exemple : TableView, Labels, etc.

        // Placeholder content
        Label label = new Label("Contenu de l'onglet 'Historique'");
        historiqueTab.setContent(label);

        return historiqueTab;
    }
    
    private static void handleAjout(String numeroVolField, String nombrePlaceField,
    		String aeroportDepartField, String aeroportArriveeField, String heureDecollageField) {
    	// Gestion de l'ajout des vols dans la BDD
    	
    	System.out.println("Envoie des données");
    	
    	// Vérification si le vol n'est pas déjà présent dans la BDD 
    }
    
    private static void handleMonCompteClick(Stage secondStage) {
        // Ajoutez le code pour afficher la page de compte, par exemple
    	
    	ComptePage.fenetreCompte(new Stage());
    }

}
