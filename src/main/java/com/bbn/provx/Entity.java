package com.bbn.provx;

import java.util.List;

public class Entity {

    private String id;
    private List<Entity> wasDerivedFrom;
    private Activity wasGeneratedBy;
    private Agent wasAttributedTo;
    
    public Entity(String id, List<Entity> wasDerivedFrom, Activity wasGeneratedBy, Agent wasAttributedTo) {
        this.id = id;
        this.wasDerivedFrom = wasDerivedFrom;
        this.wasGeneratedBy = wasGeneratedBy;
        this.wasAttributedTo = wasAttributedTo;
    }

    public void setWasGeneratedBy(Activity activity) {
        this.wasGeneratedBy = activity;
    }

    public String getId() {
        return id;
    }  

    public List<Entity> getWasDerivedFrom() {
        return wasDerivedFrom;
    }

    public Activity getWasGeneratedBy() {
        return wasGeneratedBy;
    }

    public Agent getWasAttributedTo() {
        return wasAttributedTo;
    }
}
