package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-25 18:11:55
 * @description
 */
@Data
@TableName("blogs")
public class BlogsEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -19096575219515265L;

	/**
	 * 主键ID
	 */
	@TableField("id")
	private Long id;

	/**
	 * 用户ID
	 */
	@TableField("user_id")
	private Long userId;

	/**
	 * 博客标题
	 */
	@TableField("title")
	private String title;

	/**
	 * 博客内容
	 */
	@TableField("content")
	private String content;

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

