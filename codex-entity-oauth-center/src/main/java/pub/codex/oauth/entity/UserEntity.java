package pub.codex.oauth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import pub.codex.apix.annotations.*;
import pub.codex.apix.annotations.group.VG;
import jakarta.validation.constraints.*;
import java.io.Serializable;


import java.util.Date;




/**
 * 用户示例表
 * 
 * @date 2023-04-14 09:49:42
 */
@TableName("t_user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Id
	 */
	@TableId
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty("Id")
	private String id;

	/**
	 * 租户ID
	 */
	@ApiModelProperty("租户ID")
	private String tenantId;

	/**
	 * 用户名
	 */
	@ApiModelProperty("用户名")
	private String username;

	/**
	 * 密码
	 */
	@ApiModelProperty("密码")
	private String password;

	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String name;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
	private Date updateTime;


	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
}
