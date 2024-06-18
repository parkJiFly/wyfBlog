package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.RoleFieldPermissionsDTO;
import com.soft.park.entity.RoleFieldPermissionsEntity;
import com.soft.park.mapper.RoleFieldPermissionsMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IRoleFieldPermissionsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.RoleFieldPermissionsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
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
		RoleFieldPermissionsEntity roleFieldPermissionsEntity = this.getById(roleId);
		return BeanUtil.copy(roleFieldPermissionsEntity, RoleFieldPermissionsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param roleFieldPermissionsVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<RoleFieldPermissionsDTO> queryByPage(RoleFieldPermissionsVO roleFieldPermissionsVO) {
		Page<RoleFieldPermissionsEntity> Page = new Page<>(roleFieldPermissionsVO.getPageNo(), roleFieldPermissionsVO.getPageSize());
		Page<RoleFieldPermissionsEntity> entityPage = this.page(Page);

		ResultPage<RoleFieldPermissionsDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, RoleFieldPermissionsDTO.class);
		return resultPage;
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
		super.saveOrUpdate(roleFieldPermissionsEntity);
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
		super.saveOrUpdate(roleFieldPermissionsEntity);
		return BeanUtil.copy(roleFieldPermissionsEntity, RoleFieldPermissionsDTO.class);
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
