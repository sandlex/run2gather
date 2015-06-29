package com.sandlex.run2gather.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;

/**
 * author: Alexey Peskov
 */
public class LoginHeader extends AbstractHeader {


    private ProcessListener processListener;

    public LoginHeader(ProcessListener processListener) {
        this.processListener = processListener;
    }

    @Override
    protected void init() {
        Button btn = new Button("Login using RunKeeper");
        btn.addStyleName("big default");
        addComponent(btn);
        setComponentAlignment(btn, Alignment.MIDDLE_RIGHT);
        btn.addListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                processListener.authorize();
            }
        });
    }
}
