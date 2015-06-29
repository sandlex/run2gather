package com.sandlex.run2gather.view;

import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.HorizontalLayout;

/**
 * author: Alexey Peskov
 */
public abstract class AbstractHolder extends HorizontalLayout {

    public AbstractHolder() {
                              System.out.println("+++++++++++++++ creating holder");
    }

    protected void setContent(AbstractOrderedLayout component) {
        removeAllComponents();
        addComponent(component);
    }

}
