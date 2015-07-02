package com.sandlex.run2gather.runkeeper.model.types;

import com.google.gson.annotations.SerializedName;

/**
 * author: Alexey Peskov
 */
public enum ShareType {

    JUST_ME("Just Me"),
    STREET_TEAM("Street Team"),
    EVERYONE("Everyone");

    @SerializedName("share_type")
    private final String code;

    ShareType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public static ShareType fromValue(String code) {
        for (ShareType type : ShareType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid ShareType code: " + code);
    }
}
