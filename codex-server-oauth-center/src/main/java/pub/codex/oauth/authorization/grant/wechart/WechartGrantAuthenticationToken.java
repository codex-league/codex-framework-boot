package pub.codex.oauth.authorization.grant.wechart;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;

import java.util.Collections;
import java.util.Map;

/**
 *
 * 用于Wechart授权授予的身份验证的基本实现
 *
 * @author xuxi
 */
public class WechartGrantAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {

	private final String code;

	public WechartGrantAuthenticationToken(String code, Authentication clientPrincipal, Map<String, Object> additionalParameters) {
		super(WechartAuthenticationConverter.wechartAuthorizationGrantType, clientPrincipal, additionalParameters);
		super.setAuthenticated(false);
		this.code = code;
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
}
