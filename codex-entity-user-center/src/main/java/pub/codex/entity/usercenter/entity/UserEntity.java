package pub.codex.entity.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotBlank;
import pub.codex.apix.annotations.*;
import pub.codex.apix.annotations.group.VG;
import java.io.Serializable;


import java.util.Date;




/**
 * 用户示例表
 * 
 * @date 2023-03-31 17:44:20
 */
@TableName("t_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Id
	 */
	@TableId
	@JsonSerialize(using=ToStringSerializer.class)
	@NotBlank(groups = {VG.Update.class})
	@ApiModelProperty("Id")
	private String id;
	/**
	 * 姓名
	 */
	@NotBlank(groups = {VG.Add.class})
	@ApiModelProperty(describe = "姓名",groups = {VG.Update.class})
	private String name;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(describe = "创建时间",groups = {VG.Add.class,VG.Update.class})
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(describe = "更新时间",groups = {VG.Add.class,VG.Update.class})
	private Date updateTime;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
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
