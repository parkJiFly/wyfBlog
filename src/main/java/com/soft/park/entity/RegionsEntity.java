package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-11 15:25:51
 * @description
 */
@Data
@TableName("regions")
public class RegionsEntity implements Serializable {

	private static final long serialVersionUID = 650934429131495257L;

	/**
	 * 区域ID
	 */
	@TableField("id")
	private String id;

	/**
	 * 区域名称
	 */
	@TableField("region_name")
	private String regionName;

	/**
	 * 父级区域ID
	 */
	@TableField("parent_id")
	private String parentId;

	/**
	 * 区域级别
	 */
	@TableField("level")
	private String level;

}

