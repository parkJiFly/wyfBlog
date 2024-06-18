package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:24
 * @description
 */
@Data
@TableName("regions")
public class RegionsEntity extends BaseEntity implements Serializable {


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

