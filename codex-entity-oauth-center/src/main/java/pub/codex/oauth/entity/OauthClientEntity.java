package pub.codex.oauth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;


/**
 * 客户端信息表
 * 
 */
@TableName("oauth2_registered_client")
public class OauthClientEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId
	@JsonSerialize(using = ToStringSerializer.class)
	private String id;

	private String tenantId;

	private String clientId;

	private Instant clientIdIssuedAt;

	private String clientSecret;

	private Instant clientSecretExpiresAt;

	private String clientName;

	private String clientAuthenticationMethods;

	private String authorizationGrantTypes;

	private String redirectUris;

	private String scopes;

	private String clientSettings;

	private String tokenSettings;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Instant getClientIdIssuedAt() {
		return clientIdIssuedAt;
	}

	public void setClientIdIssuedAt(Instant clientIdIssuedAt) {
		this.clientIdIssuedAt = clientIdIssuedAt;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Instant getClientSecretExpiresAt() {
		return clientSecretExpiresAt;
	}

	public void setClientSecretExpiresAt(Instant clientSecretExpiresAt) {
		this.clientSecretExpiresAt = clientSecretExpiresAt;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAuthenticationMethods() {
		return clientAuthenticationMethods;
	}

	public void setClientAuthenticationMethods(String clientAuthenticationMethods) {
		this.clientAuthenticationMethods = clientAuthenticationMethods;
	}

	public String getAuthorizationGrantTypes() {
		return authorizationGrantTypes;
	}

	public void setAuthorizationGrantTypes(String authorizationGrantTypes) {
		this.authorizationGrantTypes = authorizationGrantTypes;
	}

	public String getRedirectUris() {
		return redirectUris;
	}

	public void setRedirectUris(String redirectUris) {
		this.redirectUris = redirectUris;
	}

	public String getScopes() {
		return scopes;
	}

	public void setScopes(String scopes) {
		this.scopes = scopes;
	}

	public String getClientSettings() {
		return clientSettings;
	}

	public void setClientSettings(String clientSettings) {
		this.clientSettings = clientSettings;
	}

	public String getTokenSettings() {
		return tokenSettings;
	}

	public void setTokenSettings(String tokenSettings) {
		this.tokenSettings = tokenSettings;
	}
}
