package com.sandlex.run2gather.runkeeper.model.types;

import com.google.gson.annotations.SerializedName;

/**
 * author: Alexey Peskov
 */
public enum AthleteType {

    ATHLETE("Athlete"),
    RUNNER("Runner"),
    MARATHONER("Marathoner"),
    ULTRA_MARATHONER("Ultra Marathoner"),
    CYCLIST("Cyclist"),
    TRI_ATHLETE("Tri-Athlete"),
    WALKER("Walker"),
    HIKER("Hiker"),
    SKIER("Skier"),
    SNOWBOARDER("Snowboarder"),
    SKATER("Skater"),
    SWIMMER("Swimmer"),
    ROWER("Rower");

    @SerializedName("athlete_type")
    private final String code;

    AthleteType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public static AthleteType fromValue(String code) {
        for (AthleteType type : AthleteType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid AthleteType code: " + code);
    }
}
