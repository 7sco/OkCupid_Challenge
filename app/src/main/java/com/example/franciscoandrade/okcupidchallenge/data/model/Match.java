package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Match implements Serializable{
    @Expose
    @SerializedName("city_name")
    private String cityName;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("age")
    private int age;
    @Expose
    @SerializedName("photo")
    private Photo photo;
    @Expose
    @SerializedName("orientation")
    private int orientation;
    @Expose
    @SerializedName("state_code")
    private String stateCode;
    @Expose
    @SerializedName("liked")
    private boolean liked;
    @Expose
    @SerializedName("match")
    private int match;

    public String getCityName() {
        return cityName;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public Photo getPhoto() {
        return photo;
    }

    public int getOrientation() {
        return orientation;
    }

    public String getStateCode() {
        return stateCode;
    }

    public boolean getLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getMatch() {
        return match;
    }






}
