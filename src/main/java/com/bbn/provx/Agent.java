package com.bbn.provx;

public class Agent {

    private String id; 
    private Agent actedOnBehalfOf;

    public Agent(String id, Agent actedOnBehalfOf) {
        this.id = id;
        this.actedOnBehalfOf = actedOnBehalfOf;
    }

    public String getId() {
        return id;
    }

    public Agent getActedOnBehalfOf() {
        return actedOnBehalfOf;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setActedOnBehalfOf(Agent actedOnBehalfOf) {
        this.actedOnBehalfOf = actedOnBehalfOf;
    }
}