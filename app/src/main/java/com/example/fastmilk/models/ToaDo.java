package com.example.fastmilk.models;

public class ToaDo {
    private Float Longtitude;
    private Float Latitude;
    private String title;

    public ToaDo(Float longtitude, Float latitude, String title) {
        Longtitude = longtitude;
        Latitude = latitude;
        this.title = title;
    }

    public ToaDo(Float longtitude, Float latitude) {
        Longtitude = longtitude;
        Latitude = latitude;
    }

    public ToaDo() {
    }

    public Float getLongtitude() {
        return Longtitude;
    }

    public void setLongtitude(Float longtitude) {
        Longtitude = longtitude;
    }

    public Float getLatitude() {
        return Latitude;
    }

    public void setLatitude(Float latitude) {
        Latitude = latitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
