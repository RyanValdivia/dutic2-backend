package com.tdl.dutic2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Configuration
public class OAuthConfig {
    @Bean
    public InMemoryClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration clientRegistration = googleRegistration();
        return new InMemoryClientRegistrationRepository(clientRegistration);
    }

    private ClientRegistration googleRegistration() {
        return ClientRegistration
                .withRegistrationId("google")
                .clientId(EnvConfig.get("GOOGLE_CLIENT_ID"))
                .clientSecret(EnvConfig.get("GOOGLE_CLIENT_SECRET"))
                .redirectUri(EnvConfig.get("GOOGLE_REDIRECT_URI"))
                .authorizationUri("https://accounts.google.com/o/oauth2/auth")
                .tokenUri("https://oauth2.googleapis.com/token")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .scope("openid", "profile", "email")
                .userNameAttributeName("sub")
                .clientName("Google")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .build();
    }
}
