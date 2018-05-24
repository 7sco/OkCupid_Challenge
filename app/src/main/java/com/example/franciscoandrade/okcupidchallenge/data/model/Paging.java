package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paging {
    @Expose
    @SerializedName("cursors")
    private Cursors cursors;

    public Cursors getCursors() {
        return cursors;
    }
}
