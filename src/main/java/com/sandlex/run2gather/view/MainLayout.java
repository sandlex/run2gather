package com.sandlex.run2gather.view;

import com.sandlex.run2gather.model.Activity;
import com.sandlex.run2gather.model.Model;
import com.sandlex.run2gather.model.User;
import com.sandlex.run2gather.mongo.ActivityRepository;
import com.sandlex.run2gather.mongo.UserRepository;
import com.sandlex.run2gather.runkeeper.ServiceProvider;
import com.sandlex.run2gather.runkeeper.model.*;
import com.sandlex.run2gather.runkeeper.model.types.ShareType;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * author: Alexey Peskov
 */
@Component
@Scope("session")
public class MainLayout extends VerticalLayout implements ProcessListener {

    @Autowired
    private ServiceProvider serviceProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private Model model;

    private HeaderHolder headerHolder = new HeaderHolder();
    private ContentHolder contentHolder = new ContentHolder();

    @PostConstruct
    private void init() {
        setSizeFull();
        addComponent(headerHolder);
        setComponentAlignment(headerHolder, Alignment.TOP_CENTER);
        addComponent(contentHolder);
        welcome();
    }

    @Override
    public void welcome() {
        headerHolder.setContent(new LoginHeader(this));
        contentHolder.setContent(new WelcomeContent());
    }

    @Override
    public void dashboard() {
        headerHolder.setContent(new DashboardHeader());
        contentHolder.setContent(new DashboardContent(model));
    }

    @Override
    public void authorize() {
        serviceProvider.authorize(/*this*/);
    }

    @Override
    public void saveUserAndActivities() {
        Window progress = new Window();
        progress.setSizeFull();
        progress.setModal(true);
        progress.setWidth(300, UNITS_PIXELS);
        progress.setWidth(100, UNITS_PIXELS);
        ProgressIndicator indicator = new ProgressIndicator();
        indicator.setIndeterminate(false);

//        progress.getContent().addComponent(indicator);

//        getApplication().getMainWindow().addWindow(progress);

        ParsedUser parsedUser = serviceProvider.getUser();
        ActivityFeed activityFeed = serviceProvider.getActivityFeed();
        User user = new User(parsedUser.getUserID(),
                serviceProvider.getProfile(),
                serviceProvider.getSettings(),
                activityFeed);

        boolean isNew = userRepository.findOne(user.getId()) == null;
        if (isNew) {
            System.out.println("Welcome, " + user.getProfile().getName());
            userRepository.save(user);
            verifySharingSettings(user.getSettings());
        } else {
            System.out.println("Welcome back, " + user.getProfile().getName());
        }


        int i = 0;
        for (ActivityFeedItem item : activityFeed.getItems()) {
            if (i == 10) break;
            ParsedActivity.setURI("http://api.runkeeper.com/" + item.getUri());

            Activity activity = new Activity(parsedUser,
                    serviceProvider.getActivity());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            if (activityRepository.findOne(activity.getUri()) == null) {
                activityRepository.save(activity);
            }

            i++;     //todo should be a progress bar on ui
//            indicator.setValue(i / 10);
        }

//        getApplication().getMainWindow().removeWindow(progress);

    }

    @Override
    public void onCompleteAuthorization() {
        dashboard();
        saveUserAndActivities();
    }

    private void verifySharingSettings(Settings settings) {
        if (!ShareType.EVERYONE.equals(settings.getShareFitnessActivities())
                && !ShareType.EVERYONE.equals(settings.getShareMap())) {
            System.out.println("Your are not sharing your activities and maps with everyone. Although you can find other others, they will not be able to find you.");
        }
    }


}
