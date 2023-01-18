package console;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import model.Aleatoire;
import model.Capteur;

import javafx.application.Application;
import model.CapteurVirtuel;

public class StationMeteo extends Application{
        public static void main(String[] args) {
            // tests unitaires
            Capteur capteur1 = new Capteur(new Aleatoire());
            Capteur capteur2 = new Capteur(new Aleatoire());
            Capteur capteur3 = new Capteur(new Aleatoire());
            CapteurVirtuel zoneDeCaptation = new CapteurVirtuel();
            AfficheurTemperature afficheurTemperature1 = new AfficheurTemperature(zoneDeCaptation);
            zoneDeCaptation.ajouterObservateur(afficheurTemperature1);
            zoneDeCaptation.ajouterCapteur(capteur1);
            zoneDeCaptation.ajouterCapteur(capteur2);
            zoneDeCaptation.ajouterCapteur(capteur3);
            capteur1.setTemperature(capteur1.getTgs().generateTemperature());
            capteur2.setTemperature(capteur2.getTgs().generateTemperature());
            capteur3.setTemperature(capteur3.getTgs().generateTemperature());
//            Parent root=FXMLLoader(getClass().getResource("/fxml/FenetrePrincipale"));
            // start();
        }

    @Override
    public void start(Stage stage) throws Exception {

    }
}