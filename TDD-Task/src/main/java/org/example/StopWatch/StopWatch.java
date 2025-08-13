package org.example.StopWatch;

public class StopWatch {

    int minutes = 0;
    int hours = 0;
    int days = 0;
    int workingHours = 24;
    public void addMinutes(int minutes) {
        if (minutes > 0) {
            this.minutes += minutes;

            this.hours += minutes / 60;
            this.minutes %= 60;

            this.days += hours / workingHours;
            this.hours %= workingHours;
        }
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getHours() {
        return this.hours;
    }

    public int getDays() {
        return this.days;
    }

    public void setWorkingHours(int i) {
        this.workingHours = i;
    }
}