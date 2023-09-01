package com.kgraudina.playground.manager.objects;

import java.util.ArrayList;

public class Swing extends Attraction {

    public Swing() {
        super("Double Swing", 2, 0, new ArrayList<>(2), new ArrayList<>());
    }
    @Override
    public int getUtilisation() {
        if (this.getParticipants().size() == this.getTotalCapacity()) {
            return 100;
        } else {
            return 0;
        }
    }
}
