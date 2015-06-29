package com.sandlex.run2gather.runkeeper.model;

import java.util.List;

/**
 * author: Alexey Peskov
 */
public class ParsedActivity implements Requestable {

    private String uri;
    private List<WGS84> path;

    private static String URI = "http://api.runkeeper.com/fitnessActivities";

    @Override
    public String getURI() {
        return URI;
    }

    public static void setURI(String newUri) {
        URI = newUri;
    }

    @Override
    public String getAccept() {
        return "application/vnd.com.runkeeper.FitnessActivity+json";
    }

    public String getUri() {
        return uri;
    }

    public List<WGS84> getPath() {
        return path;
    }
}
