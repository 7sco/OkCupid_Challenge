package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OriginalSize implements Serializable{
    @Expose
    @SerializedName("height")
    private int height;
    @Expose
    @SerializedName("width")
    private int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
