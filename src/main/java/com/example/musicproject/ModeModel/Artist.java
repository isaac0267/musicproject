package com.example.musicproject.ModeModel;

public class Artist {

    // make the artist attribute.
    private int id;
    private String first_name;
    private String last_name;
    private String tracks;
    private int year_of_publication;
    private String record_label;

    // make the constructor her.
    public Artist(int id, String first_name, String last_name, int year_of_publication, String tracks, String record_label) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.tracks = tracks;
        this.year_of_publication = year_of_publication;
        this.record_label = record_label;


    }
    // make the empty constructor.
    public Artist() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public String getRecord_label() {
        return record_label;
    }

    public void setRecord_label(String record_label) {
        this.record_label = record_label;
    }
}
