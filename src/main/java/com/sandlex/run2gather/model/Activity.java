package com.sandlex.run2gather.model;

import java.util.List;

import com.sandlex.run2gather.runkeeper.model.ParsedActivity;
import com.sandlex.run2gather.runkeeper.model.ParsedUser;
import com.sandlex.run2gather.runkeeper.model.WGS84;
import org.springframework.data.annotation.Id;

/**
 * @author apeskov
 */
public class Activity {

    private Integer userId;
    @Id
    private String uri;
    private List<WGS84> path;

    public Activity(ParsedUser parsedUser, ParsedActivity parsedActivity) {
        this.userId = parsedUser.getUserID();
        this.uri = parsedActivity.getURI();
        this.path = parsedActivity.getPath();
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUri() {
        return uri;
    }

    public List<WGS84> getPath() {
        return path;
    }
}
