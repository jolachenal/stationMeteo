package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Observable {
    private List<IObservateur> lesSpinners = new ArrayList<IObservateur>();
    public void ajouterObservateur(IObservateur iobservateur){
        lesSpinners.add(iobservateur);
    }
    public void supprimerObservateur(IObservateur b){
        lesSpinners.remove(b);
    }
    public List<IObservateur> getLesSpinners() {
        return Collections.unmodifiableList(lesSpinners);
    }
    public void notifier(){
        for (IObservateur observateur : lesSpinners) {
            observateur.update();
        }
    };
}
