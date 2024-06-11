package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-11 15:26:45
 * @description
 */
@Data
@TableName("universities")
public class UniversitiesEntity implements Serializable {

	private static final long serialVersionUID = -99383751275325912L;

	/**
	 * 大学ID
	 */
	@TableField("university_id")
	private Integer universityId;

	/**
	 * 大学名称
	 */
	@TableField("university_name")
	private String universityName;

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

