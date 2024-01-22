package defaut;


import javafx.application.Application;
import javafx.stage.Stage;
import project.modele.DAO.DAO;
import project.vue.ConnexionPage; 


public class Main extends Application {
	
	private static DAO daoInstance;
	
	public static void main(String[] args) {
		launch(args);
        
    }

	@Override
    public void start(Stage primaryStage) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        primaryStage.setTitle("Connexion");
        
        ConnexionPage.fenetreConnexion(primaryStage);
        daoInstance =new DAO();
    }
	
	public static DAO getDAOInstance() {
        return daoInstance;
    }
}
    