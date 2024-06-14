package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.RoleFieldPermissionsDTO;
import com.soft.park.entity.RoleFieldPermissionsEntity;
import com.soft.park.mapper.RoleFieldPermissionsMapper;
import com.soft.park.service.IRoleFieldPermissionsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.RoleFieldPermissionsVO;
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
 * @date 2024-06-14 17:40:40
 * @description 角色字段权限关联表(RoleFieldPermissions)表服务实现类
 */
@Service
@Slf4j
public class RoleFieldPermissionsServiceImpl extends ServiceImpl<RoleFieldPermissionsMapper, RoleFieldPermissionsEntity> implements IRoleFieldPermissionsService {

	@Autowired
	private RoleFieldPermissionsMapper roleFieldPermissionsMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param roleId 主键
	 * @return 实例对象
	 */
	@Override
	public RoleFieldPermissionsDTO queryById(Long roleId) {
		RoleFieldPermissionsEntity roleFieldPermissionsEntity = this.roleFieldPermissionsMapper.queryById(roleId);
		return BeanUtil.copy(roleFieldPermissionsEntity, RoleFieldPermissionsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param roleFieldPermissionsVO 筛选条件
	 * @param pageRequest            分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<RoleFieldPermissionsDTO> queryByPage(RoleFieldPermissionsVO roleFieldPermissionsVO, PageRequest pageRequest) {
		long total = this.roleFieldPermissionsMapper.count(roleFieldPermissionsVO);
		List<RoleFieldPermissionsEntity> roleFieldPermissionsEntityS = this.roleFieldPermissionsMapper.queryAllByLimit(roleFieldPermissionsVO, pageRequest);
		List<RoleFieldPermissionsDTO> roleFieldPermissionsDTOS = BeanUtil.copyToList(roleFieldPermissionsEntityS, RoleFieldPermissionsDTO.class);
		return new PageImpl<>(roleFieldPermissionsDTOS, pageRequest, total);
	}

	/**
	 * 新增数据
	 *
	 * @param roleFieldPermissionsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public RoleFieldPermissionsDTO insert(RoleFieldPermissionsVO roleFieldPermissionsVO) {
		RoleFieldPermissionsEntity roleFieldPermissionsEntity = BeanUtil.copy(roleFieldPermissionsVO, RoleFieldPermissionsEntity.class);
		this.roleFieldPermissionsMapper.insert(roleFieldPermissionsEntity);
		return BeanUtil.copy(roleFieldPermissionsEntity, RoleFieldPermissionsDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param roleFieldPermissionsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public RoleFieldPermissionsDTO update(RoleFieldPermissionsVO roleFieldPermissionsVO) {
		RoleFieldPermissionsEntity roleFieldPermissionsEntity = BeanUtil.copy(roleFieldPermissionsVO, RoleFieldPermissionsEntity.class);
		this.roleFieldPermissionsMapper.update(roleFieldPermissionsEntity);
		return this.queryById(roleFieldPermissionsVO.getRoleId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param roleId 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long roleId) {
		return this.roleFieldPermissionsMapper.deleteById(roleId) > 0;
	}

}
