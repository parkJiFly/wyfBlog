package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:10
 * @description
 */
@Data
@TableName("company_info")
public class CompanyInfoEntity implements Serializable {

	private static final long serialVersionUID = -63418897936439447L;

	/**
	 * 主键
	 */
	@TableField("id")
	private Long id;

	/**
	 * 公司名称
	 */
	@TableField("company_name")
	private String companyName;

	/**
	 * 所在区域
	 */
	@TableField("region_id")
	private Long regionId;

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

