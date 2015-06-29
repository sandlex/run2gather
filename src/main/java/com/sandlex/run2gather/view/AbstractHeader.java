package com.sandlex.run2gather.view;

import com.vaadin.ui.HorizontalLayout;

/**
 * author: Alexey Peskov
 */
public abstract class AbstractHeader extends HorizontalLayout {

    public AbstractHeader() {
        setMargin(true);
        setStyleName("header");
        setSizeFull();
        init();
    }

    protected abstract void init();
}
