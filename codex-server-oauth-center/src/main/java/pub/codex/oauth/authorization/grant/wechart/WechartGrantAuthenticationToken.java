package pub.codex.oauth.authorization.grant.wechart;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 用于Wechart授权授予的身份验证的基本实现
 *
 * @author xuxi
 */
public class WechartGrantAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {

    private final String code;

    private final Set<String> scopes;

    public WechartGrantAuthenticationToken(String code, Authentication clientPrincipal, Set<String> scopes, Map<String, Object> additionalParameters) {
        super(WechartAuthenticationConverter.wechartAuthorizationGrantType, clientPrincipal, additionalParameters);
        super.setAuthenticated(false);
        this.code = code;
        this.scopes = Collections.unmodifiableSet(
                scopes != null ? new HashSet<>(scopes) : Collections.emptySet());
    }

    public String getCode() {
        return code;
    }

    @Override
    public Object getCredentials() {
        return super.getCredentials();
    }

    @Override
    public Object getPrincipal() {
        return super.getPrincipal();
    }

    public Set<String> getScopes() {
        return this.scopes;
    }
}
