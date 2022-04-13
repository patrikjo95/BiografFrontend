package com.example.biograffrontend2;

public class Movies {
    public int theaterId;
    public String moviename;
    public String dateTime;
    public String seatsAvailable;

    public Movies(int TheaterID, String Name, String DateTime, String SeatsAvailable) {
        this.moviename = Name;
        this.dateTime = DateTime;
        this.theaterId = TheaterID;
        this.seatsAvailable = SeatsAvailable;

    }

    public Movies(String Name, String DateTime, int TheaterID, String SeatsAvailable) {
        this.moviename = Name;
        this.dateTime = DateTime;
        this.theaterId = TheaterID;
        this.seatsAvailable = SeatsAvailable;

    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(String seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }



    public Movies(String moviename) {
        this.moviename = moviename;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movie_name='" + moviename + '\'' +
                ", movie_datetime='" + dateTime + '\'' +
                ", theater_id='" + theaterId +
                ", seats_avalible='" + seatsAvailable + '\'' +
                '}';
    }
}
