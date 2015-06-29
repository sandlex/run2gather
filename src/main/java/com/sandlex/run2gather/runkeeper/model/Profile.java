package com.sandlex.run2gather.runkeeper.model;

import com.google.gson.annotations.SerializedName;
import com.sandlex.run2gather.runkeeper.model.types.AthleteType;
import com.sandlex.run2gather.runkeeper.model.types.Gender;

import java.util.Date;

/**
 * author: Alexey Peskov
 */
public class Profile extends AbstractModelClass implements Requestable {

    private String name;
    private String location;
    @SerializedName("athlete_type")
    private AthleteType athleteType;
    private Gender gender;
    private Date birthday;
    @SerializedName("small_picture")
    private String smallPicture;
    @SerializedName("normal_picture")
    private String normalPicture;
    @SerializedName("medium_picture")
    private String mediumPicture;

    public Profile() {
    }

    public Profile(String name, String location, AthleteType athleteType, Gender gender, Date birthday, String profile, String smallPicture, String normalPicture, String mediumPicture) {
        this.name = name;
        this.location = location;
        this.athleteType = athleteType;
        this.gender = gender;
        this.birthday = birthday;
        this.smallPicture = smallPicture;
        this.normalPicture = normalPicture;
        this.mediumPicture = mediumPicture;
    }

    @Override
    public String getURI() {
        return "http://api.runkeeper.com/profile";
    }

    @Override
    public String getAccept() {
        return "application/vnd.com.runkeeper.Profile+json";
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public AthleteType getAthleteType() {
        return athleteType;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSmallPicture() {
        return smallPicture;
    }

    public String getNormalPicture() {
        return normalPicture;
    }

    public String getMediumPicture() {
        return mediumPicture;
    }

}
