package com.sandlex.run2gather.view;

import com.sandlex.run2gather.runkeeper.ServiceProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * author: Alexey Peskov
 */
@Component
@Scope("session")
public class MainView extends VerticalLayout implements View {

//    @Autowired
    private Navigator navigator;

    @Autowired
    private ServiceProvider serviceProvider;


    //    @PostConstruct
    public MainView(final Navigator navigator) {
//            private void init() {
        System.out.println("MainView");
        setSizeFull();

        Button button = new Button("Go to start View",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
//                        navigator.navigateTo("");
                        serviceProvider.authorize(/*this*/);
                    }
                });
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }
}
