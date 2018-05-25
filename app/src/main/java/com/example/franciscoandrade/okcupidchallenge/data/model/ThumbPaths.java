package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ThumbPaths implements Serializable{
    @Expose
    @SerializedName("medium")
    private String medium;
    @Expose
    @SerializedName("small")
    private String small;
    @Expose
    @SerializedName("desktop_match")
    private String desktopMatch;
    @Expose
    @SerializedName("large")
    private String large;

    public String getMedium() {
        return medium;
    }

    public String getSmall() {
        return small;
    }

    public String getDesktopMatch() {
        return desktopMatch;
    }

    public String getLarge() {
        return large;
    }
}
