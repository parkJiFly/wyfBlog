package com.soft.park.dto;

import com.soft.park.entity.UserEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/5/31 11:32
 * @description
 */
@Data
@Slf4j
public class UserDTO extends UserEntity {
	private String saToken;
}
