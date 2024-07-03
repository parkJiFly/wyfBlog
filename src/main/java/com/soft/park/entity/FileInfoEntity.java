package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-07-03 10:32:49
 * @description
 */
@Data
@TableName("file_info")
public class FileInfoEntity extends BaseEntity implements Serializable {

	/**
	 * 附件名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 附件地址
	 */
	@TableField("path")
	private String path;

	/**
	 * 业务关联
	 */
	@TableField("belong_to")
	private String belongTo;

	/**
	 * 附件描述
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 图片业务类型
	 */
	@TableField("type")
	private String type;

	/**
	 * 附件类型（图片、视频）
	 */
	@TableField("file_type")
	private String fileType;

}

