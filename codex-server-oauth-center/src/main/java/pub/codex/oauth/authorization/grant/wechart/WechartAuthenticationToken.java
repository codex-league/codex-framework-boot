package pub.codex.oauth.authorization.grant.wechart;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

/**
 *
 * 用于Wechart授权授予的身份验证的基本实现
 *
 * @author xuxi
 */
public class WechartAuthenticationToken extends AbstractAuthenticationToken {

	private final Object principal;

	private Object credentials;

	public WechartAuthenticationToken(Object principal, Object credentials,
									  Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		super.setAuthenticated(true);

	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	@Override
	public void eraseCredentials() {
		super.eraseCredentials();
		this.credentials = null;
	}
}
