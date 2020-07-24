package com.example.tracker.Model;

public class States {

    private String state;
    private Long positive;
    private Long negative;
    private String recovered;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPositive() {
        return positive;
    }

    public void setPositive(Long positive) {
        this.positive = positive;
    }

    public Long getNegative() {
        return negative;
    }

    public void setNegative(Long negative) {
        this.negative = negative;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    @Override
    public String toString() {
        return "States{" +
                "state='" + state + '\'' +
                ", positive=" + positive +
                ", negative=" + negative +
                ", recovered=" + recovered +
                '}';
    }
}
