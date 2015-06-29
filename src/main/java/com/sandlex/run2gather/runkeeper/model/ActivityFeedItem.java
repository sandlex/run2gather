package com.sandlex.run2gather.runkeeper.model;

import com.google.gson.annotations.SerializedName;
import com.sandlex.run2gather.runkeeper.model.types.ActivityType;

import java.util.Date;

/**
 * author: Alexey Peskov
 */
public class ActivityFeedItem extends AbstractModelClass implements Comparable<ActivityFeedItem> {

    private Double duration;

    @SerializedName("total_distance")
    private Double totalDistance;

    @SerializedName("start_time")
    private Date startTime;

    private ActivityType type;

    private String uri;

    public ActivityFeedItem() {
    }

    public ActivityFeedItem(Double duration, Double totalDistance, Date startTime, ActivityType type, String uri) {
        this.duration = duration;
        this.totalDistance = totalDistance;
        this.startTime = startTime;
        this.type = type;
        this.uri = uri;
    }

    @Override
    public int compareTo(ActivityFeedItem activityFeedItem) {
        return this.startTime.compareTo(activityFeedItem.startTime);
    }

    public Double getDuration() {
        return duration;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public Date getStartTime() {
        return startTime;
    }

    public ActivityType getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
