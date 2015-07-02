package com.sandlex.run2gather.model;

import com.sandlex.run2gather.runkeeper.model.ActivityFeed;
import com.sandlex.run2gather.runkeeper.model.Profile;
import com.sandlex.run2gather.runkeeper.model.Settings;
import org.springframework.data.annotation.Id;

/**
 * @author apeskov
 */
public class User {

    @Id
    private Integer id;
    private Profile profile;
    private Settings settings;
    private ActivityFeed activityFeed;

    public User(Integer id, Profile profile, Settings settings, ActivityFeed activityFeed) {
        this.id = id;
        this.profile = profile;
        this.settings = settings;
        this.activityFeed = activityFeed;
    }

    public Integer getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public Settings getSettings() {
        return settings;
    }

    public ActivityFeed getActivityFeed() {
        return activityFeed;
    }
}
