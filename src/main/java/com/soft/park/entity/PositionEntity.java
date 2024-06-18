package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:21
 * @description
 */
@Data
@TableName("position")
public class PositionEntity extends BaseEntity implements Serializable {


	/**
	 * 上级节点ID
	 */
	@TableField("parent_id")
	private Long parentId;

	/**
	 * 岗位名称
	 */
	@TableField("position_name")
	private String positionName;

	/**
	 * 岗位编码
	 */
	@TableField("position_code")
	private String positionCode;

	/**
	 * 岗位等级
	 */
	@TableField("level")
	private Integer level;

	/**
	 * 状态
	 */
	@TableField("status")
	private Integer status;

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

