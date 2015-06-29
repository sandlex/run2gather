package com.sandlex.run2gather.model;

import com.sandlex.run2gather.runkeeper.model.ParsedUser;
import com.sandlex.run2gather.runkeeper.model.Profile;
import com.sandlex.run2gather.runkeeper.model.Settings;
import com.sandlex.run2gather.runkeeper.model.types.AthleteType;
import com.sandlex.run2gather.runkeeper.model.types.Gender;
import com.sandlex.run2gather.runkeeper.model.types.ShareType;
import com.vaadin.data.util.ObjectProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * author: Alexey Peskov
 */
@Component
@Scope("session")
public class Model implements ModelListener { //TODO delete

    private Integer userID;
    private ObjectProperty name = new ObjectProperty("xxxx", String.class);;
    private String location;
    private AthleteType athleteType;
    private Gender gender;
    private Date birthday;
    private ShareType shareFitnessActivities;
    private ShareType shareMap;

    public Model() {
        System.out.println("++++++++++ model created");
    }

    @Override
    public void onUserUpdate(ParsedUser parsedUser) {
        userID = parsedUser.getUserID();
    }

    @Override
    public void onSettingsUpdate(Settings settings) {
        shareFitnessActivities = settings.getShareFitnessActivities();
        shareMap = settings.getShareMap();
    }

    @Override
    public void onProfileUpdate(Profile profile) {
        System.out.println("++++++++++++++++ onProfileUpdate");
        name.setValue(profile.getName());
        location = profile.getLocation();
        athleteType = profile.getAthleteType();
        gender = profile.getGender();
        birthday = profile.getBirthday();
    }

    public Integer getUserID() {
        return userID;
    }

    public ObjectProperty getName() {
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

    public ShareType getShareFitnessActivities() {
        return shareFitnessActivities;
    }

    public ShareType getShareMap() {
        return shareMap;
    }
}
