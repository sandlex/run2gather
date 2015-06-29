package com.sandlex.run2gather.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;

/**
 * author: Alexey Peskov
 */
public class DashboardHeader extends AbstractHeader {

    @Override
    protected void init() {
        Label label = new Label("Welcome!");
        addComponent(label);
        setComponentAlignment(label, Alignment.MIDDLE_RIGHT);
    }
}
