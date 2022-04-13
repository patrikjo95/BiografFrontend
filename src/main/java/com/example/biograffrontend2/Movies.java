package com.example.biograffrontend2;

public class Movies {
    public int id;
    public int theaterId;
    public String moviename;
    public String dateTime;
    public String seatsAvailable;

    public Movies(int id, int theaterId, String moviename, String dateTime) {
        this.id = id;
        this.moviename = moviename;
        this.dateTime = dateTime;
        this.theaterId = theaterId;




    }

    public Movies(String moviename) {
        this.moviename = moviename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(String seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "ID=" + id +
                ", Name='" + moviename + '\'' +
                ", DateTime='" + dateTime + '\'' +
                ", TheaterID='" + theaterId +
                ", SeatsAvailable='" + seatsAvailable + '\'' +
                '}';
    }
}
