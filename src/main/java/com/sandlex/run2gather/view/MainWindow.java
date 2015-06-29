package com.sandlex.run2gather.view;

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
public class MainWindow extends Window {

    @Autowired
    private MainLayout mainLayout;

    @PostConstruct
    private void init() {
        setCaption("Run2gather");
        setContent(mainLayout);
    }

}
