package com.sandlex.run2gather.runkeeper.model;

import java.util.List;

/**
 * author: Alexey Peskov
 */
public class ActivityFeedPage implements Requestable {

    private Integer size;
    private List<ActivityFeedItem> items;
    private String previous;
    private String next;

    private static String uri = "http://api.runkeeper.com/fitnessActivities";

    @Override
    public String getURI() {
        return uri;
    }

    public static void setURI(String newUri) {
        uri = newUri;
    }

    @Override
    public String getAccept() {
        return "application/vnd.com.runkeeper.FitnessActivityFeed+json";
    }

    public Integer getSize() {
        return size;
    }

    public List<ActivityFeedItem> getItems() {
        return items;
    }

    public String getPrevious() {
        return previous;
    }

    public String getNext() {
        return next;
    }
}
