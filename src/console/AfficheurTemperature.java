package console;

import model.Capteur;
import model.IObservateur;

public class AfficheurTemperature implements IObservateur {
    private Capteur lecapteur;

    public AfficheurTemperature(Capteur lecapteur) {
        this.lecapteur = lecapteur;
    }

    public void update(){
        System.out.println(lecapteur.getNom() + " : température : " + lecapteur.getTemperature());
    }
}
