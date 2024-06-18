package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:30
 * @description
 */
@Data
@TableName("user_departments")
public class UserDepartmentsEntity extends BaseEntity implements Serializable {


	/**
	 * 部门ID
	 */
	@TableField("department_id")
	private Long departmentId;

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

