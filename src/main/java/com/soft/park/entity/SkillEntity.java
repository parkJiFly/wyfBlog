package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:29
 * @description
 */
@Data
@TableName("skill")
public class SkillEntity extends BaseEntity implements Serializable {

	/**
	 * 简历ID
	 */
	@TableField("resume_id")
	private Long resumeId;

	/**
	 * 技能名称
	 */
	@TableField("skill_name")
	private String skillName;

	/**
	 * 技能水平
	 */
	@TableField("skill_level")
	private Integer skillLevel;

	/**
	 * 技能描述
	 */
	@TableField("skill_desc")
	private String skillDesc;

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

