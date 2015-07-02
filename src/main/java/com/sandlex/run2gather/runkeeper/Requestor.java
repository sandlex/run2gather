package com.sandlex.run2gather.runkeeper;

import com.google.gson.Gson;
import com.sandlex.run2gather.gson.GsonBuiderWrapper;
import com.sandlex.run2gather.runkeeper.model.Requestable;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 * author: Alexey Peskov
 */
public class Requestor {

    public static final String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss";

    public static Requestable getEntity(Requestable cl, OAuthService service, Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.GET, cl.getURI());
        service.signRequest(accessToken, request);
        request.addHeader("Accept", cl.getAccept());
        Response response = request.send();
        return parseObj(cl, response.getBody());
    }

    static Requestable parseObj(Requestable cl, String json) {
        Gson gson = GsonBuiderWrapper.getInstance().createGson();
        return gson.fromJson(json, cl.getClass());
    }

}
