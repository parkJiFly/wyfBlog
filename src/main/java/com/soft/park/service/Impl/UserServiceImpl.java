package com.soft.park.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.UserDTO;
import com.soft.park.entity.UserEntity;
import com.soft.park.exception.CusException;
import com.soft.park.mapper.UserMapper;
import com.soft.park.service.IUserService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.RedisUtils;
import com.soft.park.utils.SaltMD5Utils;
import com.soft.park.vo.UserVO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:22
 * @description (User)表服务实现类
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public UserDTO queryById(Object id) {
		UserEntity userEntity = this.userMapper.queryById(id);
		return BeanUtil.copy(userEntity, UserDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param userVO      筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<UserDTO> queryByPage(UserVO userVO, PageRequest pageRequest) {
		long total = this.userMapper.count(userVO);
		List<UserEntity> userEntityS = this.userMapper.queryAllByLimit(userVO, pageRequest);
		List<UserDTO> userDTOS = BeanUtil.copyToList(userEntityS, UserDTO.class);
		return new PageImpl<>(userDTOS, pageRequest, total);
	}

	/**
	 * 新增数据
	 *
	 * @param userVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public UserDTO insert(@Valid @RequestBody UserVO userVO) {
		UserEntity userEntity = BeanUtil.copy(userVO, UserEntity.class);
		this.userMapper.insert(userEntity);
		return BeanUtil.copy(userEntity, UserDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param userVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public UserDTO update(UserVO userVO) {
		UserEntity userEntity = BeanUtil.copy(userVO, UserEntity.class);
		this.userMapper.update(userEntity);
		return this.queryById(userVO.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.userMapper.deleteById(id) > 0;
	}

	/**
	 * 进行登录功能
	 * @return
	 */
	@Override
	public UserDTO login(UserVO userVO) {
		String key = RedisUtils.get().keyBuilder("verification", userVO.getVerKey());
		if(!RedisUtils.get().hasKey(key)){
			throw new CusException("key值不存在");
		}
		Object code = RedisUtils.get().get(key);
		if(!code.toString().equals(userVO.getVerCode())){
			throw new CusException("验证码错误");
		}
		LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(UserEntity::getUserName,userVO.getUserName());
		List<UserEntity> userEntities = baseMapper.selectList(queryWrapper);
		if(userEntities.size()  ==   1){
			if(SaltMD5Utils.verifySaltPassword(userVO.getPassword(),userEntities.getFirst().getPassword())){
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
