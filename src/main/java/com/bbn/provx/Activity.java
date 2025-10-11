package com.bbn.provx;

public class Activity {
    
    private String id; 
    private String startedAtTime;
    private String endedAtTime;

    public Activity() {}

    public Activity(String id, String startedAtTime, String endedAtTime) {
        this.id = id;
        this.startedAtTime = startedAtTime;
        this.endedAtTime = endedAtTime;
    }

    public String getId() {
        return id;
    }

    public String getStartedAtTime() {
        return startedAtTime;
    }

    public String getEndedAtTime() {
        return endedAtTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStartedAtTime(String startedAtTime) {
        this.startedAtTime = startedAtTime;
    }

    public void setEndedAtTime(String endedAtTime) {
        this.endedAtTime = endedAtTime;
    }

}