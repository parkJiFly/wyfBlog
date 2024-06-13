package com.soft.park.vo;

import cn.sticki.validator.spel.SpelValid;
import cn.sticki.validator.spel.constrain.SpelNotEmpty;
import com.soft.park.entity.UserEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/5/31 11:31
 * @description
 */
@Data
@Slf4j
@SpelValid
public class UserVO extends UserEntity {

	//版本类型
	private String type;

	//验证码校验Key
	@SpelNotEmpty(group = "ValidGroup.Login.class",message = "登录时verKey不存在")
	private String verKey;

	//验证码校验Code
	@SpelNotEmpty(group = "ValidGroup.Login.class",message = "登录时verCode不存在")
	private String verCode;
}
