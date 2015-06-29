package com.sandlex.run2gather;

import com.sandlex.run2gather.view.MainView;
import com.sandlex.run2gather.view.StartView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * author: Alexey Peskov
 */
//@Component("application")
@Configurable
//@Theme("run2gather")
//@Scope("session")
public class Run2GatherApplication extends UI {

//    @Autowired
    private Navigator navigator;

//    @Autowired
    private StartView startView;

//    @Autowired
    private MainView mainView;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigator = new Navigator(this, this);
        navigator.addView("", new StartView(navigator));
        navigator.addView("main", new MainView(navigator));
    }

//    @PostConstruct
//    @Autowired
//    private void post() {
//        navigator.addView("", startView);
//        navigator.addView("main", mainView);
//    }
}
