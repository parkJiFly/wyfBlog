package com.soft.park.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.UserDTO;
import com.soft.park.entity.UserEntity;
import com.soft.park.mapper.UserMapper;
import com.soft.park.service.IUserService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.SaltMD5Utils;
import com.soft.park.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

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
		LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(UserEntity::getUserName,userName);
		List<UserEntity> userEntities = baseMapper.selectList(queryWrapper);
		if(userEntities.size()  ==   1){
			if(SaltMD5Utils.verifySaltPassword(password,userEntities.getFirst().getPassword())){
				UserDTO copy = BeanUtil.copy(userEntities.getFirst(), UserDTO.class);
				StpUtil.login(userEntities.getFirst().getId());
				String tokenValue = StpUtil.getTokenValue();
				copy.setSaToken(tokenValue);
				return copy;
			}
		}
		return null;
	}

	/**
	 * 新增用户
	 * @param userVO
	 * @return
	 */
	@Override
	public UserDTO addUser(UserVO userVO) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userVO,userEntity);
		userEntity.setPassword(SaltMD5Utils.generateSaltPassword(userVO.getPassword()));
		LocalDateTime localDateTime = LocalDateTime.now();
		userEntity.setRegisterTime(localDateTime);
		baseMapper.insert(userEntity);
		return BeanUtil.copy(userEntity,UserDTO.class);
	}

	/**
	 * 查看用户详情
	 * @param id
	 * @return
	 */
	@Override
	public UserDTO detail(Long id) {
		UserEntity userEntity = baseMapper.selectById(id);
		if(ObjectUtils.isEmpty(userEntity)){
			return null;
		}
		return BeanUtil.copy(userEntity,UserDTO.class);
	}

}
