package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:23
 * @description
 */
@Data
@TableName("project_resume_relation")
public class ProjectResumeRelationEntity extends BaseEntity implements Serializable {


	/**
	 * 简历ID
	 */
	@TableField("resume_id")
	private Long resumeId;

	/**
	 * 项目ID
	 */
	@TableField("project_id")
	private Long projectId;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 删除标志，0表示未删除，1表示已删除
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

