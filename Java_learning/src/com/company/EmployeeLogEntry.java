package com.company;

import java.util.Comparator;

public class EmployeeLogEntry implements Comparable<EmployeeLogEntry>{

    private int minutes;
    private boolean cameIn;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int applyToSum() {
        return cameIn ? 1 : -1;
    }

    public void setCameIn(boolean cameIn) {
        this.cameIn = cameIn;
    }

    public EmployeeLogEntry(String time, boolean cameIn) {
        this.cameIn = cameIn;
        this.minutes = Integer.valueOf(time.split(":")[0]) * 60 +
                Integer.valueOf(time.split(":")[1]);
    }

    public boolean isCameIn() {
        return cameIn;
    }



    public static int comparing(EmployeeLogEntry o1, EmployeeLogEntry o2) {
            if (o1.getMinutes() == o2.getMinutes()) {
                return Boolean.compare(o2.isCameIn(), o1.isCameIn());
            }
            return Integer.compare(o1.getMinutes(), o2.getMinutes());
        }



    @Override
    public String toString() {
        return "EmployeeLogEntry{" +
                "minutes=" + minutes +
                ", cameIn=" + cameIn +
                '}';
    }



    @Override
    public int compareTo(EmployeeLogEntry o1) {
        if (this.getMinutes() == o1.getMinutes()) {
            return Boolean.compare(o1.isCameIn(), this.isCameIn());
        }
        return Integer.compare(this.getMinutes(), o1.getMinutes());
    }


}