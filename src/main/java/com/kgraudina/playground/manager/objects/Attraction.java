package com.kgraudina.playground.manager.objects;


import java.util.ArrayList;

public abstract class Attraction {

    private String name;
    private int totalCapacity;
    private int currentCapacity;
    private ArrayList<Visitor> participants;
    private ArrayList<Visitor> queue;

    public Attraction(String name, int totalCapacity, int currentCapacity, ArrayList<Visitor> participants, ArrayList<Visitor> queue) {
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.currentCapacity = currentCapacity;
        this.participants = participants;
        this.queue = queue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public ArrayList<Visitor> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Visitor> participants) {
        this.participants = participants;
    }

    public ArrayList<Visitor> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<Visitor> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                ", totalCapacity=" + totalCapacity +
                ", currentCapacity=" + currentCapacity +
                ", participants=" + participants +
                ", queue=" + queue +
                '}';
    }
}

