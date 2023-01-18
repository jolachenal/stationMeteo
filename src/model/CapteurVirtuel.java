package model;

import java.util.ArrayList;
import java.util.List;

public class CapteurVirtuel extends Capteur implements IObservateur{
    private List<Capteur> lesCapteurs = new ArrayList<>();

    public CapteurVirtuel() {
        super();
    }

    public CapteurVirtuel(TemperatureGenerationStrategy tgs) {
        super(tgs);
    }

    public CapteurVirtuel(TemperatureGenerationStrategy tgs, long generationTime) {
        super(tgs, generationTime);
    }

    public CapteurVirtuel(TemperatureGenerationStrategy tgs, float poids) {
        super(tgs, poids);
    }

    public CapteurVirtuel(TemperatureGenerationStrategy tgs, long generationTime, float poids) {
        super(tgs, generationTime, poids);
    }
    public void ajouterCapteur(Capteur capteur)
    {
        capteur.ajouterObservateur(this);
        lesCapteurs.add(capteur);
        setPoids(this.getPoids()+capteur.getPoids());
    }

    @Override
    public void setTgs(TemperatureGenerationStrategy tgs) {
        super.setTgs(tgs);
        for (Capteur capteur : lesCapteurs) {
            capteur.setTgs(super.getTgs());
        }
    }
    public void update(){
        float temp=0;
        float poids=0;
        for(Capteur capteur: lesCapteurs){
            temp+=capteur.getTemperature()*capteur.getPoids();
            poids+=capteur.getPoids();
        }
        super.setTemperature(temp/poids);
    }
}
