package org.example.StopWatch;

public class StopWatch {

    int minutes = 0;
    public void addMinutes(int minutes) {
        this.minutes += minutes;
    }

    public int getMinutes() {
        return this.minutes;
    }
}