package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:17
 * @description
 */
@Data
@TableName("project_responsibility")
public class ProjectResponsibilityEntity implements Serializable {

	private static final long serialVersionUID = -19280656117249245L;

	/**
	 * 主键
	 */
	@TableField("id")
	private Long id;

	/**
	 * 项目ID
	 */
	@TableField("project_id")
	private Long projectId;

	/**
	 * 责任描述
	 */
	@TableField("resp_desc")
	private String respDesc;

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

