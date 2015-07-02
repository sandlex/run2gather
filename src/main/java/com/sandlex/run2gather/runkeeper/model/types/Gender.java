package com.sandlex.run2gather.runkeeper.model.types;

import com.google.gson.annotations.SerializedName;

/**
 * author: Alexey Peskov
 */
public enum Gender {

    MALE("M"),
    FEMALE("F"),
    UNKNOWN("");

    @SerializedName("gender")
    private final String code;

    Gender(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public static Gender fromValue(String code) {

        if ("".equals(code)) {
            return UNKNOWN;
        }

        for (Gender type : Gender.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid Gender code: " + code);
    }
}
