package com.sandlex.run2gather.runkeeper.model.types;

import com.google.gson.annotations.SerializedName;

/**
 * author: Alexey Peskov
 */
public enum ActivityType {

    RUNNING("Running"),
    CYCLING("Cycling"),
    MOUNTAIN_BIKING("Mountain Biking"),
    WALKING("Walking"),
    HIKING("Hiking"),
    DOWNHILL_SKIING("Downhill Skiing"),
    CROSS_COUNTRY_SKIING("Cross-Country Skiing"),
    SNOWBOARDING("Snowboarding"),
    SKATING("Skating"),
    SWIMMING("Swimming"),
    WHEELCHAIR("Wheelchair"),
    ROWING("Rowing"),
    ELLIPTICAL("Elliptical"),
    OTHER("Other");

    @SerializedName("type")
    private final String code;

    ActivityType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public static ActivityType fromValue(String code) {
        for (ActivityType type : ActivityType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid ActivityType code: " + code);
    }
}
