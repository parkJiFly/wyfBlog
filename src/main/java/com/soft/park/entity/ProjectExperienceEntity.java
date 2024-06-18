package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:22
 * @description
 */
@Data
@TableName("project_experience")
public class ProjectExperienceEntity extends BaseEntity implements Serializable {

	/**
	 * 开发工具
	 */
	@TableField("tool_id")
	private Integer toolId;

	/**
	 * 项目名称
	 */
	@TableField("project_name")
	private String projectName;

	/**
	 * 项目描述
	 */
	@TableField("project_desc")
	private String projectDesc;

	/**
	 * 用户ID
	 */
	@TableField("user_id")
	private Long userId;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 是否删除
	 */
	@TableField("is_delete")
	private Integer isDelete;

	/**
	 * 创建时间
	 */
	@TableField("create_time")
	private Date createTime;

	/**
	 * 创建人
	 */
	@TableField("creator")
	private String creator;

	/**
	 * 修改时间
	 */
	@TableField("update_time")
	private Date updateTime;

	/**
	 * 修改人
	 */
	@TableField("updator")
	private String updator;

}

