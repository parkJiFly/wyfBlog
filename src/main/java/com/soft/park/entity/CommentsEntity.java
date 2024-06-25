package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-25 18:11:58
 * @description
 */
@Data
@TableName("comments")
public class CommentsEntity extends BaseEntity implements Serializable {

	/**
	 * 博客ID
	 */
	@TableField("blog_id")
	private Long blogId;

	/**
	 * 用户ID
	 */
	@TableField("user_id")
	private Long userId;

	/**
	 * 评论内容
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

	/**
	 * 父评论ID
	 */
	@TableField("parent_id")
	private Long parentId;

}

