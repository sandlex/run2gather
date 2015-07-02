package com.sandlex.run2gather.runkeeper;

import com.sandlex.run2gather.runkeeper.model.*;
import com.sandlex.run2gather.runkeeper.model.types.*;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * author: Alexey Peskov
 */
public class RequestorTest extends MightyTestParent {

    @Test
    public void testUserFromJson() throws Exception {
        ParsedUser parsedUser = (ParsedUser) Requestor.parseObj(new ParsedUser(), getFileContent("user.json"));
        assertEquals(new ParsedUser(1195164), parsedUser);
    }

    @Test
    public void testProfileFromJson() throws Exception {
        Profile profile = (Profile) Requestor.parseObj(new Profile(), getFileContent("profile.json"));
        assertEquals(new Profile(
                "Alexey Peskov",
                "Haarlem, The Netherlands",
                AthleteType.ATHLETE,
                Gender.MALE,
                getDate("Sun, 30 Aug 1981 00:00:00"),
                "http://runkeeper.com/user/sandlex",
                null,
                "http://graph.facebook.com/1001946155/picture?type=large",
                "http://graph.facebook.com/1001946155/picture?type=small"
        ), profile);
    }

    @Test
    public void testSettingsFromJson() throws Exception {
        Settings settings = (Settings) Requestor.parseObj(new Settings(), getFileContent("settings.json"));
        assertEquals(new Settings(ShareType.EVERYONE, ShareType.EVERYONE), settings);
    }

    @Test
    public void testActivityFeedPageFromJson() throws Exception {
        ActivityFeedPage activityFeedPage = (ActivityFeedPage) Requestor.parseObj(new ActivityFeedPage(), getFileContent("activityfeed2.json"));
        assertTrue(172 == activityFeedPage.getSize());
        assertEquals("/fitnessActivities?page=2&pageSize=25&noEarlierThan=1970-01-01&noLaterThan=2013-01-19&modifiedNoEarlierThan=1970-01-01&modifiedNoLaterThan=2013-01-19", activityFeedPage.getNext());
        assertEquals("/fitnessActivities?page=0&pageSize=25&noEarlierThan=1970-01-01&noLaterThan=2013-01-19&modifiedNoEarlierThan=1970-01-01&modifiedNoLaterThan=2013-01-19", activityFeedPage.getPrevious());
        assertTrue(25 == activityFeedPage.getItems().size());
        assertEquals(new ActivityFeedItem(1956.833,
                6484.90779662696,
                getDate("Mon, 10 Sep 2012 19:09:49"),
                ActivityType.RUNNING,
                "/fitnessActivities/116853586"), activityFeedPage.getItems().get(12));
    }

    @Test
    public void testActivityFeed() throws Exception {
        ActivityFeed feed = new ActivityFeed();
        for (int i = 1; i < 8; i++) {
            ActivityFeedPage activityFeedPage = (ActivityFeedPage) Requestor.parseObj(new ActivityFeedPage(), getFileContent(String.format("activityfeed%d.json", i)));
            feed.addItems(activityFeedPage.getItems());
        }

        assertTrue(172 == feed.getItems().size());
        assertEquals(new ActivityFeedItem(1166d,
                4000d,
                getDate("Mon, 17 Aug 2009 20:30:57"),
                ActivityType.RUNNING,
                "/fitnessActivities/35143249"), feed.getItems().toArray()[3]);
    }

    @Test
    public void testActivityFromJson() throws Exception {
        ParsedActivity parsedActivity = (ParsedActivity) Requestor.parseObj(new ParsedActivity(), getFileContent("activity.json"));
        assertEquals("/fitnessActivities/123262944", parsedActivity.getUri());
        assertTrue(1832 == parsedActivity.getPath().size());
        assertEquals(new WGS84(34.129,
                4.636363636363637,
                4.641312,
                52.396028,
                PathType.GPS), parsedActivity.getPath().get(8));

        assertEquals(PathType.START, parsedActivity.getPath().get(0).getType());
        assertEquals(PathType.END, parsedActivity.getPath().get(1831).getType());
    }

}
