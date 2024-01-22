package project.vue;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.modele.Vol;

public class AffichageVol {
	
	final static Color stroke = Color.BLACK;
	private int stockeWidth = 1;
	private Vol vol;
	
	public AffichageVol(Vol vol) {
		this.vol = vol;
	}
	
    protected StackPane createFlightRectangle() {
    	
    	// RECUPERATION DES INFOS
    	Timestamp dateTimeArrivee = vol.getDateHeureLocaleArrivee() ;
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime dateTime = dateTimeArrivee.toLocalDateTime();
        
        Rectangle rectangle = new Rectangle(350,50);

        if (dateTime.isBefore(currentDateTime)) {
        	rectangle.setFill(Color.LIGHTGRAY);
        } else if (dateTime.isAfter(currentDateTime)) {
        	rectangle.setFill(Color.LIGHTBLUE);
        } else {
        	rectangle.setFill(Color.LIGHTBLUE);
        }
        
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1);
        
        String texte = vol.getNumeroVol();
        Text numVol = new Text(texte);

        numVol.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        // RECUPERATION DES DONNEES DE VOL
        Text text = new Text(numVol.getText() + "    " + vol.getDateDepart() +"    " + vol.getHeureDepart() + "\n"
        		+ vol.getDepart() + " To " + vol.getArrivee() + "\n" 
        		+ "Modèle : "+ vol.getModeleAvion()+ "   "+ "Places vendues : " + vol.getNbPlaceAchetee());

        text.setWrappingWidth(280); // Largeur maximale avant le retour à la ligne
        
        // StackPane pour superposer le rectangle et le texte 
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, text);
        //stackPane.setOnMouseClicked(AffichageVol::handleRectangleClick);
        stackPane.setOnMouseClicked(this::handleRectangleClick);
        
        return stackPane;
    }
    
    private void handleRectangleClick(MouseEvent event) {
        ModificationPage modificationPage = new ModificationPage();
        modificationPage.fenetreModification(new Stage(), this.vol);
    }
	
}
