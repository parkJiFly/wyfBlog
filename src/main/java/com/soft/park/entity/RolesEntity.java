package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:40:41
 * @description
 */
@Data
@TableName("roles")
public class RolesEntity implements Serializable {

	private static final long serialVersionUID = -56991537916135934L;

	/**
	 * 角色ID
	 */
	@TableField("id")
	private Long id;

	/**
	 * 角色名称
	 */
	@TableField("role_name")
	private String roleName;

	/**
	 * 描述
	 */
	@TableField("description")
	private String description;

	/**
	 * 创建时间
	 */
	@TableField("created_at")
	private Date createdAt;

	/**
	 * 更新时间
	 */
	@TableField("updated_at")
	private Date updatedAt;

	/**
	 * 创建者ID
	 */
	@TableField("created_by")
	private Long createdBy;

	/**
	 * 修改者ID
	 */
	@TableField("updated_by")
	private Long updatedBy;

	/**
	 * 删除标志
	 */
	@TableField("is_deleted")
	private Integer isDeleted;

	/**
	 * 状态
	 */
	@TableField("status")
	private Integer status;

}

