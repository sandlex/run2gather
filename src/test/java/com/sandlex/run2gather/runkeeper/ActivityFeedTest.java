package com.sandlex.run2gather.runkeeper;

import com.sandlex.run2gather.runkeeper.MightyTestParent;
import com.sandlex.run2gather.runkeeper.Requestor;
import com.sandlex.run2gather.runkeeper.model.ActivityFeed;
import com.sandlex.run2gather.runkeeper.model.ActivityFeedItem;
import com.sandlex.run2gather.runkeeper.model.ActivityFeedPage;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * author: Alexey Peskov
 */
public class ActivityFeedTest extends MightyTestParent {

    @Test
    public void testActivityFeedOrdering() throws Exception {
        ActivityFeed feedNatural = new ActivityFeed();
        for (int i = 1; i < 8; i++) {
            ActivityFeedPage activityFeedPage = (ActivityFeedPage) Requestor.parseObj(
                    new ActivityFeedPage(), getFileContent(String.format("activityfeed%d.json", i)));
            feedNatural.addItems(activityFeedPage.getItems());
        }

        ActivityFeed feedRandom = new ActivityFeed();
        //TODO use random with cycle
        ActivityFeedPage activityFeedPage1 = (ActivityFeedPage) Requestor.parseObj(
                new ActivityFeedPage(), getFileContent("activityfeed1.json"));
        ActivityFeedPage activityFeedPage2 = (ActivityFeedPage) Requestor.parseObj(
                new ActivityFeedPage(), getFileContent("activityfeed3.json"));
        ActivityFeedPage activityFeedPage3 = (ActivityFeedPage) Requestor.parseObj(
                new ActivityFeedPage(), getFileContent("activityfeed5.json"));
        ActivityFeedPage activityFeedPage4 = (ActivityFeedPage) Requestor.parseObj(
                new ActivityFeedPage(), getFileContent("activityfeed7.json"));
        ActivityFeedPage activityFeedPage5 = (ActivityFeedPage) Requestor.parseObj(
                new ActivityFeedPage(), getFileContent("activityfeed6.json"));
        ActivityFeedPage activityFeedPage6 = (ActivityFeedPage) Requestor.parseObj(
                new ActivityFeedPage(), getFileContent("activityfeed4.json"));
        ActivityFeedPage activityFeedPage7 = (ActivityFeedPage) Requestor.parseObj(
                new ActivityFeedPage(), getFileContent("activityfeed2.json"));
        feedRandom.addItems(activityFeedPage1.getItems());
        feedRandom.addItems(activityFeedPage2.getItems());
        feedRandom.addItems(activityFeedPage3.getItems());
        feedRandom.addItems(activityFeedPage4.getItems());
        feedRandom.addItems(activityFeedPage5.getItems());
        feedRandom.addItems(activityFeedPage6.getItems());
        feedRandom.addItems(activityFeedPage7.getItems());

        assertTrue(172 == feedRandom.getItems().size());
        assertTrue(feedNatural.getItems().size() == feedRandom.getItems().size());
        assertEquals(feedNatural.getItems(), feedRandom.getItems());
        Object[] feedNaturalArray = feedNatural.getItems().toArray();
        Object[] feedRandomArray = feedNatural.getItems().toArray();
        assertEquals(feedNaturalArray[0], feedRandomArray[0]);
        assertEquals(feedNaturalArray[171], feedRandomArray[171]);
        assertEquals(feedNaturalArray[65], feedRandomArray[65]);
        assertEquals(feedNaturalArray[101], feedRandomArray[101]);
        Assert.assertEquals(((ActivityFeedItem) feedNaturalArray[101]).getDuration(),
                ((ActivityFeedItem) feedRandomArray[101]).getDuration());
        assertTrue(((ActivityFeedItem) feedNaturalArray[0]).getStartTime().before(
                ((ActivityFeedItem) feedRandomArray[171]).getStartTime()));
        assertEquals(((ActivityFeedItem) feedNaturalArray[0]).getStartTime(),
                getDate("Thu, 1 Jan 1970 01:00:00"));
        assertEquals(((ActivityFeedItem) feedRandomArray[171]).getStartTime(),
                getDate("Sun, 6 Jan 2013 09:57:17"));
    }

}
