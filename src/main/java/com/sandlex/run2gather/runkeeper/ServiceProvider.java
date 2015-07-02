package com.sandlex.run2gather.runkeeper;

import com.sandlex.run2gather.runkeeper.model.*;
import com.sandlex.run2gather.view.MainWindow;
import com.sandlex.run2gather.view.ProcessListener;

/**
 * author: Alexey Peskov
 */
public interface ServiceProvider {

    void authorize(/*ProcessListener processListener*/);

    ParsedUser getUser();

    Settings getSettings();

    Profile getProfile();

    ActivityFeed getActivityFeed();

    ParsedActivity getActivity();

}
