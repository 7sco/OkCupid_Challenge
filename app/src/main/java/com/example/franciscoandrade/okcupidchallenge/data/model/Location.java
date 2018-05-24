package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
    @Expose
    @SerializedName("state_code")
    private String stateCode;
    @Expose
    @SerializedName("state_name")
    private String stateName;
    @Expose
    @SerializedName("country_name")
    private String countryName;
    @Expose
    @SerializedName("city_name")
    private String cityName;
    @Expose
    @SerializedName("country_code")
    private String countryCode;

    public String getStateCode() {
        return stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
