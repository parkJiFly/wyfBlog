package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.UserRolesDTO;
import com.soft.park.entity.UserRolesEntity;
import com.soft.park.mapper.UserRolesMapper;
import com.soft.park.service.IUserRolesService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.UserRolesVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:40:44
 * @description 用户角色关联表(UserRoles)表服务实现类
 */
@Service
@Slf4j
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRolesEntity> implements IUserRolesService {

	@Autowired
	private UserRolesMapper userRolesMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param userId 主键
	 * @return 实例对象
	 */
	@Override
	public UserRolesDTO queryById(Long userId) {
		UserRolesEntity userRolesEntity = this.userRolesMapper.queryById(userId);
		return BeanUtil.copy(userRolesEntity, UserRolesDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param userRolesVO 筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<UserRolesDTO> queryByPage(UserRolesVO userRolesVO, PageRequest pageRequest) {
		long total = this.userRolesMapper.count(userRolesVO);
		List<UserRolesEntity> userRolesEntityS = this.userRolesMapper.queryAllByLimit(userRolesVO, pageRequest);
		List<UserRolesDTO> userRolesDTOS = BeanUtil.copyToList(userRolesEntityS, UserRolesDTO.class);
		return new PageImpl<>(userRolesDTOS, pageRequest, total);
	}

	/**
	 * 新增数据
	 *
	 * @param userRolesVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public UserRolesDTO insert(UserRolesVO userRolesVO) {
		UserRolesEntity userRolesEntity = BeanUtil.copy(userRolesVO, UserRolesEntity.class);
		this.userRolesMapper.insert(userRolesEntity);
		return BeanUtil.copy(userRolesEntity, UserRolesDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param userRolesVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public UserRolesDTO update(UserRolesVO userRolesVO) {
		UserRolesEntity userRolesEntity = BeanUtil.copy(userRolesVO, UserRolesEntity.class);
		this.userRolesMapper.update(userRolesEntity);
		return this.queryById(userRolesVO.getUserId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param userId 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long userId) {
		return this.userRolesMapper.deleteById(userId) > 0;
	}

}
