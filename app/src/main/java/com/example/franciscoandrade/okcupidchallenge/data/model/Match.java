package com.example.franciscoandrade.okcupidchallenge.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Match {
    @Expose
    @SerializedName("orientation_tags")
    private List<String> orientationTags;
    @Expose
    @SerializedName("last_contact_time")
    private List<Integer> lastContactTime;
    @Expose
    @SerializedName("stoplight_color")
    private String stoplightColor;
    @Expose
    @SerializedName("city_name")
    private String cityName;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("is_online")
    private int isOnline;
    @Expose
    @SerializedName("friend")
    private int friend;
    @Expose
    @SerializedName("country_code")
    private String countryCode;
    @Expose
    @SerializedName("age")
    private int age;
    @Expose
    @SerializedName("state_name")
    private String stateName;
    @Expose
    @SerializedName("photo")
    private Photo photo;
    @Expose
    @SerializedName("country_name")
    private String countryName;
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
    @SerializedName("gender_tags")
    private List<String> genderTags;
    @Expose
    @SerializedName("match")
    private int match;
    @Expose
    @SerializedName("userid")
    private String userid;
    @Expose
    @SerializedName("location")
    private Location location;
    @Expose
    @SerializedName("gender")
    private int gender;
    @Expose
    @SerializedName("last_login")
    private int lastLogin;
    @Expose
    @SerializedName("relative")
    private int relative;
    @Expose
    @SerializedName("enemy")
    private int enemy;

    public List<String> getOrientationTags() {
        return orientationTags;
    }

    public List<Integer> getLastContactTime() {
        return lastContactTime;
    }

    public String getStoplightColor() {
        return stoplightColor;
    }

    public String getCityName() {
        return cityName;
    }

    public String getUsername() {
        return username;
    }

    public int getIsOnline() {
        return isOnline;
    }

    public int getFriend() {
        return friend;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getAge() {
        return age;
    }

    public String getStateName() {
        return stateName;
    }

    public Photo getPhoto() {
        return photo;
    }

    public String getCountryName() {
        return countryName;
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

    public List<String> getGenderTags() {
        return genderTags;
    }

    public int getMatch() {
        return match;
    }

    public String getUserid() {
        return userid;
    }

    public Location getLocation() {
        return location;
    }

    public int getGender() {
        return gender;
    }

    public int getLastLogin() {
        return lastLogin;
    }

    public int getRelative() {
        return relative;
    }

    public int getEnemy() {
        return enemy;
    }
}
