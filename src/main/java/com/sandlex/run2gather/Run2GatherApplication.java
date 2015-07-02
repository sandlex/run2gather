package com.sandlex.run2gather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author apeskov
 */
@EnableAutoConfiguration
@EnableOAuth2Client
@RestController
public class Run2GatherApplication {

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    @RequestMapping("/")
    String home() {
        return oAuth2RestTemplate.getAccessToken().getValue();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Run2GatherApplication.class, args);
    }

//    @Value("${oauth.resource:https://runkeeper.com}")
//    private String baseUrl;
//
//    @Value("${oauth.authorize:https://runkeeper.com/apps/authorize}")
//    private String authorizeUrl;
//
//    @Value("${oauth.token:https://runkeeper.com/apps/token}")
//    private String tokenUrl;
//
//    @Autowired
//    private OAuth2RestOperations restTemplate;
//
//    @RequestMapping("/")
//    public List<Map<String,?>> home() {
//        @SuppressWarnings("unchecked")
//        List<Map<String,?>> result = restTemplate.getForObject(baseUrl + "/admin/beans", List.class);
//        return result;
//    }
//
//    @Bean
//    public OAuth2RestOperations restTemplate(OAuth2ClientContext oauth2ClientContext) {
//        return new OAuth2RestTemplate(resource(), oauth2ClientContext);
//    }
//
//    @Bean
//    protected OAuth2ProtectedResourceDetails resource() {
//        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
//        resource.setAccessTokenUri(tokenUrl);
//        resource.setUserAuthorizationUri(authorizeUrl);
//        resource.setClientId("my-trusted-client");
//        return resource ;
//    }
}
