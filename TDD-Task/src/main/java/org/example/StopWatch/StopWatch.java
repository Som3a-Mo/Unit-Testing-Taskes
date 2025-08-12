package org.example.StopWatch;

public class StopWatch {

    int minutes = 0;
    public void addMinutes(int minutes) {
        if (minutes > 0) {
            this.minutes += minutes;
        }
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getHours() {
        return 0;
    }
}