//package pub.codex.oauth.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
//import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
//
////        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
////
////        return http.build();
//
//        OAuth2AuthorizationServerConfigurer authorizationServerConfigurer =
//                new OAuth2AuthorizationServerConfigurer();
//        http.apply(authorizationServerConfigurer);
//
//        authorizationServerConfigurer
////                .registeredClientRepository(registeredClientRepository)
////                .authorizationService(authorizationService)
////                .authorizationConsentService(authorizationConsentService)
////                .authorizationServerSettings(authorizationServerSettings)
////                .tokenGenerator(tokenGenerator)
//                .clientAuthentication(clientAuthentication -> { })
//                .authorizationEndpoint(authorizationEndpoint -> { })
//                .tokenEndpoint(tokenEndpoint -> { })
//                .tokenIntrospectionEndpoint(tokenIntrospectionEndpoint -> { })
//                .tokenRevocationEndpoint(tokenRevocationEndpoint -> { })
//                .authorizationServerMetadataEndpoint(authorizationServerMetadataEndpoint -> { })
//                .oidc(oidc -> oidc
//                        .providerConfigurationEndpoint(providerConfigurationEndpoint -> { })
//                        .userInfoEndpoint(userInfoEndpoint -> { })
//                        .clientRegistrationEndpoint(clientRegistrationEndpoint -> { })
//                );
//
//        return http.build();
//    }
//}