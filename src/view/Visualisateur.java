package view;

import model.Capteur;
import model.IObservateur;

public abstract class Visualisateur implements IObservateur {
        private void clickFermer(){
//        Stage stage = (Stage) .getScene().getWindow();
//        stage.close();
        }
        private void intialize (Capteur c){
            c.ajouterObservateur(this);
        }
    }
