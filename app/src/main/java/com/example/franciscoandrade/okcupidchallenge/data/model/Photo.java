package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Photo implements Serializable{
    @Expose
    @SerializedName("thumb_paths")
    private ThumbPaths thumbPaths;
    @Expose
    @SerializedName("id")
    private String id;

    public ThumbPaths getThumbPaths() {
        return thumbPaths;
    }

    public String getId() {
        return id;
    }

}
