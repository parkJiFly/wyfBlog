package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.UserDTO;
import com.soft.park.entity.UserEntity;
import com.soft.park.vo.UserVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/5/31 11:39
 * @description
 */
public interface IUserService extends IService<UserEntity> {

	/**
	 * 登录
	 * @param userVO
	 * @return
	 */
	UserDTO login(UserVO userVO);

}
