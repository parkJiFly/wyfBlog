package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:25
 * @description
 */
@Data
@TableName("role_menus")
public class RoleMenusEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 405667491459258147L;



	/**
	 * 菜单ID
	 */
	@TableField("menu_id")
	private Long menuId;

	/**
	 * 创建时间
	 */
	@TableField("created_at")
	private Date createdAt;

	/**
	 * 创建者ID
	 */
	@TableField("created_by")
	private Long createdBy;

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

