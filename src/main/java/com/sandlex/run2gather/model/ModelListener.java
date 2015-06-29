package com.sandlex.run2gather.model;

import com.sandlex.run2gather.runkeeper.model.ParsedUser;
import com.sandlex.run2gather.runkeeper.model.Profile;
import com.sandlex.run2gather.runkeeper.model.Settings;

/**
 * author: Alexey Peskov
 */
public interface ModelListener { //TODO delete

    void onUserUpdate(ParsedUser parsedUser);

    void onSettingsUpdate(Settings settings);

    void onProfileUpdate(Profile profile);
}
