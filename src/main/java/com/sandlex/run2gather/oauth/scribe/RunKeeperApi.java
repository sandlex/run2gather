package com.sandlex.run2gather.oauth.scribe;

import com.sandlex.run2gather.oauth.RunKeeperOAuthConstants;
import org.scribe.builder.api.DefaultApi20;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;

/**
 * author: Alexey Peskov
 */
public class RunKeeperApi extends DefaultApi20 {

    @Override
    public AccessTokenExtractor getAccessTokenExtractor() {
        return new JsonTokenExtractor();
    }

    @Override
    public String getAccessTokenEndpoint() {
        return RunKeeperOAuthConstants.ACCESS_TOKEN_URL;
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    @Override
    public String getAuthorizationUrl(OAuthConfig config) {
        return String.format(RunKeeperOAuthConstants.AUTH_URL + "?client_id=%s&redirect_uri=%s&response_type=code",
                config.getApiKey(), OAuthEncoder.encode(config.getCallback()));
    }

}
