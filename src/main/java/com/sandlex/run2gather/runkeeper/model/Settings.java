package com.sandlex.run2gather.runkeeper.model;

import com.google.gson.annotations.SerializedName;
import com.sandlex.run2gather.runkeeper.model.types.ShareType;

/**
 * author: Alexey Peskov
 */
public class Settings extends AbstractModelClass implements Requestable {

    @SerializedName("share_fitness_activities")
    private ShareType shareFitnessActivities;

    @SerializedName("share_map")
    private ShareType shareMap;

    public Settings() {
    }

    public Settings(ShareType shareFitnessActivities, ShareType shareMap) {
        this.shareFitnessActivities = shareFitnessActivities;
        this.shareMap = shareMap;
    }

    @Override
    public String getURI() {
        return "http://api.runkeeper.com/settings";
    }

    @Override
    public String getAccept() {
        return "application/vnd.com.runkeeper.Settings+json";
    }

    public ShareType getShareFitnessActivities() {
        return shareFitnessActivities;
    }

    public ShareType getShareMap() {
        return shareMap;
    }

}
