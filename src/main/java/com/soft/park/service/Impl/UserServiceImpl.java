package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.UserDTO;
import com.soft.park.entity.UserEntity;
import com.soft.park.mapper.UserMapper;
import com.soft.park.service.IUserService;
import com.soft.park.utils.SaltMD5Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/5/31 11:40
 * @description
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements IUserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 进行登录功能
	 * @param userName
	 * @param password
	 * @param type
	 * @return
	 */
	@Override
	public UserDTO login(String userName,String password,String type) {
		UserDTO userDTO = new UserDTO();
		userDTO.setPassword(SaltMD5Utils.MD5(password));
		return userDTO;
	}

}
