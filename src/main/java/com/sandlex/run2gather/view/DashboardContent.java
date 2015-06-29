package com.sandlex.run2gather.view;

import com.sandlex.run2gather.model.Model;
import com.vaadin.ui.Label;

/**
 * author: Alexey Peskov
 */
public class DashboardContent extends AbstractContent {

    private Model model;

    private Label userId;
    private Label share_fitness_activities;
    private Label share_map;

    public DashboardContent(Model model) {
        super();
        System.out.println("++++++++++ DashboardContent created");
        this.model = model;
        userId = new Label();
        userId.setPropertyDataSource(this.model.getName());
        userId.setImmediate(true);
        addComponent(userId);
    }

    @Override
    protected void init() {
        share_fitness_activities = new Label("share_fitness_activities");
        addComponent(share_fitness_activities);
        share_map = new Label("share_map");
        addComponent(share_map);
    }

}
