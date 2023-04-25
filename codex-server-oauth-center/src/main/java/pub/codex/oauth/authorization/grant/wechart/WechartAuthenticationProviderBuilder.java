package pub.codex.oauth.authorization.grant.wechart;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;
import pub.codex.oauth.service.client.ClientUserDetailsService;
import pub.codex.oauth.utils.OAuth2ConfigurerUtils;

/**
 * A Builder for {@link WechartAuthenticationProviderBuilder}.

 */
public final class WechartAuthenticationProviderBuilder {

    private HttpSecurity httpSecurity;
    private ClientUserDetailsService userDetailsService;

    public WechartAuthenticationProviderBuilder(
            HttpSecurity httpSecurity, ClientUserDetailsService clientUserDetailsService) {
        this.httpSecurity = httpSecurity;
        this.userDetailsService = clientUserDetailsService;
    }


    public WechartAuthenticationProvider build() {
        OAuth2AuthorizationService authorizationService = OAuth2ConfigurerUtils.getAuthorizationService(httpSecurity);
        OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator = OAuth2ConfigurerUtils.getTokenGenerator(httpSecurity);

        WechartAuthenticationProvider PasswordCredentialsAuthenticationProvider =
                new WechartAuthenticationProvider(authorizationService, tokenGenerator,
                        userDetailsService);
        return PasswordCredentialsAuthenticationProvider;
    }
}