package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/5/31 11:09
 * @description
 */
@Data
@TableName("user")
public class UserEntity {

	@TableField("id")
	private Long id;

	@TableField("user_name")
	private String userName;

	@TableField("school_code")
	private Long schoolCode;

	@TableField("nickname")
	private String nickName;

	@TableField("avatar_url")
	private String avatarUrl;

	@TableField("register_time")
	private LocalDateTime registerTime;

	@TableField("deleted")
	private int deleted;

	@TableField("password")
	private String password;

}
