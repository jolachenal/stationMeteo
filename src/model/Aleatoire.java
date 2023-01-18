package model;

import java.util.Random;

public class Aleatoire implements TemperatureGenerationStrategy {
    public float generateTemperature(){
        Random r= new Random();
        return r.nextFloat() * (30+20) - 20;
    }
    public float generateTemperature(float minimum,float maximum){
        Random r= new Random();
        return r.nextFloat(minimum - maximum) + minimum;
    }
}