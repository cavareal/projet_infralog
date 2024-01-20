package project.vue;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.modele.Vol;

public class AffichageVol {
	
	final static Color stroke = Color.BLACK;
	int stockeWidth = 1;
	
    protected static StackPane createFlightRectangle(Vol vol) {
    	
//    	// RECUPERATION DES VRAIES INFOS 
    	
    	Timestamp dateTimeArrivee = vol.getDateHeureLocaleArrivee() ;

        // Conversion de la chaîne en LocalDateTime
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(dateTimeArrivee, formatter);
        
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
        
        // RECUPERATION DES DONNEES DE VOL
        Text text = new Text(vol.getNumeroVol() + "    " + vol.getDateDepart() +"    " + vol.getHeureDepart() + "\n"
        		+ vol.getDepart() + " To " + vol.getArrivee() + "\n" 
        		+ "Modele : "+ vol.getModeleAvion()+ "   "+ "Places vendues : " + vol.getNbPlaceAchetee());
        text.setWrappingWidth(280); // Largeur maximale avant le retour à la ligne
        
        // StackPane pour superposer le rectangle et le texte 
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, text);
        stackPane.setOnMouseClicked(AffichageVol::handleRectangleClick);
        
        return stackPane;
    }
    
    private static void handleRectangleClick(MouseEvent event) {
        // Afficher une autre vue ou effectuer une action appropriée lors du clic sur le rectangle
        System.out.println("Rectangle cliqué ! Vous pouvez changer de vue ici.");
        // Par exemple, vous pourriez ouvrir une nouvelle fenêtre ou masquer la vue actuelle.
        ModificationPage.fenetreModification(new Stage());
    }
	
}
