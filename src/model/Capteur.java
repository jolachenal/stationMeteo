package model;

import javafx.application.Platform;
import javafx.beans.property.SimpleFloatProperty;

public class Capteur extends Observable implements Runnable  {
    private final int id;
    private static int idActuel = 0;
    private SimpleFloatProperty temperature;
    private final String nom;
    private long generationTime;
    private TemperatureGenerationStrategy tgs;
    private float poids;

    private final static int DEFAULT_GENERATION_TIME=5000;

    private Thread thread;

    public Capteur() {
        id = idActuel++;
        idActuel = idActuel++;
        temperature = new SimpleFloatProperty(0);
        nom = "capteur " + this.id;
        generationTime = DEFAULT_GENERATION_TIME;
        tgs = new Aleatoire();
        poids = 1;
    }

    public Capteur(TemperatureGenerationStrategy tgs) {
        id = idActuel++;
        idActuel = idActuel++;
        temperature = new SimpleFloatProperty(0);
        nom = "capteur " + id;
        generationTime = DEFAULT_GENERATION_TIME;
        this.tgs = tgs;
        poids = 1;
    }

    public Capteur(TemperatureGenerationStrategy tgs, float poids) {
        id = idActuel++;
        idActuel = idActuel++;
        this.temperature = new SimpleFloatProperty(0);
        nom = "capteur " + id;
        this.generationTime = DEFAULT_GENERATION_TIME;
        this.tgs = tgs;
        this.poids = poids;
    }

    public Capteur(TemperatureGenerationStrategy tgs,long generationTime) {
        idActuel = idActuel++;
        id = idActuel;
        this.temperature = new SimpleFloatProperty(0);
        nom = "capteur " + this.id;
        this.generationTime = generationTime;
        this.tgs = tgs;
        this.poids = 1;
    }

    public Capteur(TemperatureGenerationStrategy tgs,long generationTime, float poids) {
        id = idActuel++;
        this.temperature = new SimpleFloatProperty(0);
        nom = "capteur " + this.id;
        this.generationTime = generationTime;
        this.tgs = tgs;
        this.poids = poids;
    }

    public float getPoids() {
        return poids;
    }
    public void setPoids(float poids) {
        this.poids=poids;
    }

    public int getId() {
        return id;
    }

    public float getTemperature() {
        return temperature.get();
    }

    public void setTemperature(float temperature) {
        this.temperature.set(temperature);
        super.notifier();
    }

    public SimpleFloatProperty temperatureProperty() {
        return temperature;
    }

    public String getNom() {
        return nom;
    }

    public float getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(long generationTime) {
        this.generationTime=generationTime;
    }

    public TemperatureGenerationStrategy getTgs() {
        return tgs;
    }

    public void setTgs(TemperatureGenerationStrategy tgs) {
        this.tgs = tgs;
    }

    public void start(){
        this.thread= new Thread(this);
        this.thread.setDaemon(true);
    }

    @Override
    public void run() {
        while(true){
            Platform.runLater(()->setTemperature(this.tgs.generateTemperature()));
            try{
                Thread.sleep(this.generationTime);
            } catch (InterruptedException e){
                break;
            }
        }
    }
}
