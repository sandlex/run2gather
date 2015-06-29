package com.sandlex.run2gather.view;

import com.vaadin.ui.Label;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * author: Alexey Peskov
 */
@Component
@Scope("session")
public class WelcomeContent extends AbstractContent {

    @Override
    protected void init() {
        Label welcome = new Label("Welcome");
        addComponent(welcome);
    }
}
