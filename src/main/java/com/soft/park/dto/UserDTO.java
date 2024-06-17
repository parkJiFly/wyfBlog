package com.soft.park.dto;

import com.soft.park.entity.UserEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:22
 * @description (User)DTO类
 */
@Data
@Slf4j
public class UserDTO extends UserEntity {
	private String saToken;
}

