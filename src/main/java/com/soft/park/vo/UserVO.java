package com.soft.park.vo;

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
public class UserVO extends UserEntity {

	//版本类型
	private String type;
}
