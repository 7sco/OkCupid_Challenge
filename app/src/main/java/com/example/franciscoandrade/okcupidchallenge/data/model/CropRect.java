package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CropRect {
    @Expose
    @SerializedName("x")
    private int x;
    @Expose
    @SerializedName("width")
    private int width;
    @Expose
    @SerializedName("y")
    private int y;
    @Expose
    @SerializedName("height")
    private int height;

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }
}
