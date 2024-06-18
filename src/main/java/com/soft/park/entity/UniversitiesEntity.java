package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:30
 * @description
 */
@Data
@TableName("universities")
public class UniversitiesEntity extends BaseEntity implements Serializable {


	/**
	 * 大学名称
	 */
	@TableField("universities_name")
	private String universitiesName;

	/**
	 * 省
	 */
	@TableField("province")
	private String province;

	/**
	 * 市
	 */
	@TableField("city")
	private String city;

	/**
	 * 区
	 */
	@TableField("district")
	private String district;

	/**
	 * 所在城市
	 */
	@TableField("location")
	private String location;

	/**
	 * 排名
	 */
	@TableField("ranking")
	private Integer ranking;

	/**
	 * 专科0或本科1
	 */
	@TableField("type")
	private Integer type;

	/**
	 * 大学等级
	 */
	@TableField("level")
	private Integer level;

}

