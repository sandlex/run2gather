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

}
