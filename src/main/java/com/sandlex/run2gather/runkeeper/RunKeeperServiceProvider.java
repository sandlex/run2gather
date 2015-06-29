package com.sandlex.run2gather.runkeeper;

import com.sandlex.run2gather.model.ModelListener;
import com.sandlex.run2gather.oauth.RunKeeperOAuthConstants;
import com.sandlex.run2gather.oauth.scribe.RunKeeperApi;
import com.sandlex.run2gather.runkeeper.model.*;
import com.sandlex.run2gather.view.MainWindow;
import com.sandlex.run2gather.view.ProcessListener;
import com.vaadin.server.*;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthConstants;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * author: Alexey Peskov
 */
@Service
@Scope("session")
public class RunKeeperServiceProvider implements ServiceProvider {
    public RunKeeperServiceProvider() {
        System.out.println("RunKeeperServiceProvider");
    }

    private MainWindow mainWindow;

    private RequestHandler handler;

    @Autowired
    private ModelListener modelListener;

//    private ProcessListener processListener;

    private OAuthService service; //todo make a component and inject into requestor so there is no need to pass into getEntity method
    private Token accessToken;
    private Token requestToken = null;


    @Override
    public void authorize(/*ProcessListener processListener*/) {
//        this.processListener = processListener;
        if (service == null) {
            service = new ServiceBuilder()
                    .provider(RunKeeperApi.class)
                    .apiKey(RunKeeperOAuthConstants.CLIENT_ID)
                    .apiSecret(RunKeeperOAuthConstants.CLIENT_SECRET)
                    .callback(Page.getCurrent().getLocation().toString()).build();
        }
        createServiceResponseHandler();
        Page.getCurrent().open(service.getAuthorizationUrl(requestToken), "_self");
    }

    @Override
    public ParsedUser getUser() {
        ParsedUser parsedUser = (ParsedUser) Requestor.getEntity(new ParsedUser(), service, accessToken);
//        modelListener.onUserUpdate(user);
        return parsedUser;
    }

    @Override
    public Settings getSettings() {
        Settings settings = (Settings) Requestor.getEntity(new Settings(), service, accessToken);
//        modelListener.onSettingsUpdate(settings);
        return settings;
    }

    @Override
    public Profile getProfile() {
        Profile profile = (Profile) Requestor.getEntity(new Profile(), service, accessToken);
//        modelListener.onSettingsUpdate(profile);
        return profile;
    }

    @Override
    public ActivityFeed getActivityFeed() {
        ActivityFeed feed = new ActivityFeed();
/*        ActivityFeedPage activityFeedPage = (ActivityFeedPage) Requestor.getEntity(new ActivityFeedPage(), service, accessToken);
        feed.addItems(activityFeedPage.getItems());
//        TODO don't use static field
        while(activityFeedPage.getNext() != null) {
            ActivityFeedPage.setURI("http://api.runkeeper.com/" + activityFeedPage.getNext());
            activityFeedPage = (ActivityFeedPage) Requestor.getEntity(new ActivityFeedPage(), service, accessToken);
            feed.addItems(activityFeedPage.getItems());
        }
*/
        return feed;
    }

    @Override
    public ParsedActivity getActivity() {
        return (ParsedActivity) Requestor.getEntity(new ParsedActivity(), service, accessToken);
    }

    private void retrieveAccessToken(Map<String, String[]> parameters) {
        if (parameters.containsKey(OAuthConstants.CODE)) {
            String code = parameters.get(OAuthConstants.CODE)[0];
            Verifier verifier = new Verifier(code);
            accessToken = service.getAccessToken(requestToken, verifier);
            removeServiceResponseHandler();
//            mainWindow.open(new ExternalResource(mainWindow.getURL()));
//            processListener.onCompleteAuthorization();
        } else {
            //todo error
        }
    }

    private RequestHandler createServiceResponseHandler() {
        if (handler == null) {
            handler = new RequestHandler() {

                @Override
                public boolean handleRequest(VaadinSession vaadinSession, VaadinRequest vaadinRequest, VaadinResponse vaadinResponse) throws IOException {
                    retrieveAccessToken(vaadinRequest.getParameterMap());
                    return false;
                }
            };
            VaadinSession.getCurrent().addRequestHandler(handler);
        }
        return handler;
    }

    private void removeServiceResponseHandler() {
        VaadinSession.getCurrent().removeRequestHandler(handler);
        handler = null;
    }

}
