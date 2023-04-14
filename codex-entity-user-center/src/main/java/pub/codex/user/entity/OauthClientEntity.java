package pub.codex.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import pub.codex.apix.annotations.*;
import pub.codex.apix.annotations.group.VG;
import jakarta.validation.constraints.*;
import java.io.Serializable;






/**
 * 客户端信息表
 * 
 * @date 2023-04-14 09:58:39
 */
@TableName("t_oauth_client")
public class OauthClientEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * client id
	 */
	@TableId
	@JsonSerialize(using = ToStringSerializer.class)
	@NotBlank(groups = {VG.Update.class })
	@ApiModelProperty("client id")
	private String clientId;

	/**
	 * client secret
	 */
	@NotBlank(groups = {VG.Add.class })
	@ApiModelProperty(describe = "client secret", groups = {VG.Update.class })
	private String clientSecret;

	/**
	 * 租户ID
	 */
	@ApiModelProperty(describe = "租户ID", groups = {VG.Update.class })
	private String tenantId;

	/**
	 * 域
	 */
	@ApiModelProperty(describe = "域", groups = {VG.Add.class, VG.Update.class })
	private String scope;

	/**
	 * 授权方式
	 */
	@ApiModelProperty(describe = "授权方式", groups = {VG.Add.class, VG.Update.class })
	private String authorizedGrantTypes;

	/**
	 * 备注
	 */
	@NotBlank(groups = {VG.Add.class })
	@ApiModelProperty(describe = "备注", groups = {VG.Update.class })
	private String remarks;


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getScope() {
		return scope;
	}

	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}
}
