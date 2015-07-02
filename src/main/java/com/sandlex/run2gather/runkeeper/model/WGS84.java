package com.sandlex.run2gather.runkeeper.model;

import com.sandlex.run2gather.runkeeper.model.types.PathType;

/**
 * author: Alexey Peskov
 */
public class WGS84 extends AbstractModelClass {

    private Double timestamp;
    private Double altitude;
    private Double longitude;
    private Double latitude;
    private PathType type;

    public WGS84(Double timestamp, Double altitude, Double longitude, Double latitude, PathType type) {
        this.timestamp = timestamp;
        this.altitude = altitude;
        this.longitude = longitude;
        this.latitude = latitude;
        this.type = type;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public Double getAltitude() {
        return altitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public PathType getType() {
        return type;
    }
}
