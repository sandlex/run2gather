package com.sandlex.run2gather.runkeeper.model.types;

import com.google.gson.annotations.SerializedName;

/**
 * author: Alexey Peskov
 */
public enum PathType {

    START("start"),
    END("end"),
    GPS("gps"),
    PAUSE("pause"),
    RESUME("resume"),
    MANUAL("manual");

    @SerializedName("type")
    private final String code;

    PathType(String code) {
         this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public static PathType fromValue(String code) {
        for (PathType type : PathType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid PathType code: " + code);
    }
}
