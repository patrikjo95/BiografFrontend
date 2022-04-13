package com.example.biograffrontend2;

public class Movies {
    public String movie_name;
    public String movie_datetime;
    public int theater_id;
    public String seats_avalible;

    public Movies(String movie_name, String movie_datetime, int theater_id, String seats_avalible) {
        this.movie_name = movie_name;
        this.movie_datetime = movie_datetime;
        this.theater_id = theater_id;
        this.seats_avalible = seats_avalible;

    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_datetime() {
        return movie_datetime;
    }

    public void setMovie_datetime(String movie_datetime) {
        this.movie_datetime = movie_datetime;
    }

    public String getSeats_avalible() {
        return seats_avalible;
    }

    public void setSeats_avalible(String seats_avalible) {
        this.seats_avalible = seats_avalible;
    }



    public Movies(String moviename) {
        this.movie_name = moviename;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movie_name='" + movie_name + '\'' +
                ", movie_datetime='" + movie_datetime + '\'' +
                ", theater_id=" + theater_id +
                ", seats_avalible='" + seats_avalible + '\'' +
                '}';
    }
}
