package com.sandlex.run2gather.runkeeper.model;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * author: Alexey Peskov
 */
public class ActivityFeed {

    private SortedSet<ActivityFeedItem> items = new TreeSet<ActivityFeedItem>();

    public SortedSet<ActivityFeedItem> getItems() {
        return items;
    }

    public void addItems(List<ActivityFeedItem> items) {
        this.items.addAll(items);
    }
}
