package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.soft.park.config.ValidGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:21
 * @description
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 987344077918330786L;

	@TableField("id")
	private Object id;

	/**
	 * 用户名
	 */
	@TableField("user_name")
	@NotBlank(groups = {ValidGroup.SaveOrUpdate.class},message = "添加修改时名称不得为空")
	private String userName;

	/**
	 * 院校代码
	 */
	@TableField("school_code")
	private Object schoolCode;

	/**
	 * 昵称
	 */
	@TableField("nickname")
	private String nickname;

	/**
	 * 头像链接
	 */
	@TableField("avatar_url")
	private String avatarUrl;

	/**
	 * 注册时间
	 */
	@TableField("register_time")
	private LocalDateTime registerTime;

	/**
	 * 0为未删除，已删除时该值等于id，以避免唯一索引的异常
	 */
	@TableField("deleted")
	private Object deleted;

	/**
	 * 密码
	 */
	@TableField("password")
	private String password;

	/**
	 * 出生年月日
	 */
	@TableField("birth_time")
	private Date birthTime;

	/**
	 * 性别
	 */
	@TableField("sex")
	private Long sex;

	/**
	 * 学校名称
	 */
	@TableField("school_name")
	private String schoolName;

	/**
	 * 学历
	 */
	@TableField("educational")
	private Long educational;

	/**
	 * 专业ID
	 */
	@TableField("profession_id")
	private Long professionId;

	/**
	 * 专业名称
	 */
	@TableField("profession_name")
	private String professionName;

	/**
	 * 毕业时间
	 */
	@TableField("graduate_date")
	private Date graduateDate;

	/**
	 * 公司ID
	 */
	@TableField("company_id")
	private Long companyId;

	/**
	 * 公司名称
	 */
	@TableField("company_name")
	private String companyName;

	/**
	 * 岗位ID
	 */
	@TableField("position_id")
	private Long positionId;

	/**
	 * 岗位名称
	 */
	@TableField("position_name")
	private String positionName;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

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

