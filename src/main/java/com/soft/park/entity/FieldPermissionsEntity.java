package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:20
 * @description
 */
@Data
@TableName("field_permissions")
public class FieldPermissionsEntity extends BaseEntity implements Serializable {



	/**
	 * 字段权限名称
	 */
	@TableField("field_permission_name")
	private String fieldPermissionName;

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

