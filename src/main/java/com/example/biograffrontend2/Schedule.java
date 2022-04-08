package com.example.biograffrontend2;

public class Schedule {
    private String name;
    private String time;
    private String theater;
    private String seats;

    public Schedule(String name, String time, String theater, String seats) {
        this.name = name;
        this.time = time;
        this.theater = theater;
        this.seats = seats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getTheater() {
        return theater;
    }

    public String getSeats() {
        return seats;
    }



}
