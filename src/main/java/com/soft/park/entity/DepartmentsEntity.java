package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:39:13
 * @description
 */
@Data
@TableName("departments")
public class DepartmentsEntity implements Serializable {

	private static final long serialVersionUID = -95202022150877914L;

	/**
	 * 部门ID
	 */
	@TableField("id")
	private Long id;

	/**
	 * 部门名称
	 */
	@TableField("department_name")
	private String departmentName;

	/**
	 * 父部门ID
	 */
	@TableField("parent_id")
	private Long parentId;

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

