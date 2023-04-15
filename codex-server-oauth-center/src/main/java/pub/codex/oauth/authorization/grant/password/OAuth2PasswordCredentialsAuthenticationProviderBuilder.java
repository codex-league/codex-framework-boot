package pub.codex.oauth.authorization.grant.password;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;
import pub.codex.oauth.utils.OAuth2ConfigurerUtils;

/**
 * An Builder for {@link OAuth2PasswordCredentialsAuthenticationProviderBuilder}.

 */
public final class OAuth2PasswordCredentialsAuthenticationProviderBuilder {

    private HttpSecurity httpSecurity;
    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    public OAuth2PasswordCredentialsAuthenticationProviderBuilder(
            HttpSecurity httpSecurity, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.httpSecurity = httpSecurity;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    public OAuth2PasswordCredentialsAuthenticationProvider build() {
        OAuth2AuthorizationService authorizationService = OAuth2ConfigurerUtils.getAuthorizationService(httpSecurity);
        OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator = OAuth2ConfigurerUtils.getTokenGenerator(httpSecurity);

        OAuth2PasswordCredentialsAuthenticationProvider PasswordCredentialsAuthenticationProvider =
                new OAuth2PasswordCredentialsAuthenticationProvider(authorizationService, tokenGenerator,
                        userDetailsService, passwordEncoder);
        return PasswordCredentialsAuthenticationProvider;
    }
}