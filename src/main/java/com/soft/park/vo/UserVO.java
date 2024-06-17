package com.soft.park.vo;

import com.soft.park.config.ValidGroup;
import com.soft.park.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:22
 * @description (User)VO类
 */
@Data
@Slf4j
public class UserVO extends UserEntity {
	//版本类型
	private String type;

	//验证码校验Key
	@NotBlank(groups = {ValidGroup.Login.class},message = "登录时verKey不存在")
	private String verKey;

	//验证码校验Code
	@NotBlank(groups = {ValidGroup.Login.class},message = "登录时verCode不存在")
	private String verCode;
}

