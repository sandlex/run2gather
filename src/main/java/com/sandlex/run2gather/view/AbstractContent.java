package com.sandlex.run2gather.view;

import com.vaadin.ui.VerticalLayout;

/**
 * author: Alexey Peskov
 */
public abstract class AbstractContent extends VerticalLayout {

    public AbstractContent() {
        setSizeFull();
        init();
    }

    protected abstract void init();
}