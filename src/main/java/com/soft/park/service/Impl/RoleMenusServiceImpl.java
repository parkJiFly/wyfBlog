package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.RoleMenusDTO;
import com.soft.park.entity.RoleMenusEntity;
import com.soft.park.mapper.RoleMenusMapper;
import com.soft.park.service.IRoleMenusService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.RoleMenusVO;
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
 * @date 2024-06-14 17:40:41
 * @description 角色菜单关联表(RoleMenus)表服务实现类
 */
@Service
@Slf4j
public class RoleMenusServiceImpl extends ServiceImpl<RoleMenusMapper, RoleMenusEntity> implements IRoleMenusService {

	@Autowired
	private RoleMenusMapper roleMenusMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param roleId 主键
	 * @return 实例对象
	 */
	@Override
	public RoleMenusDTO queryById(Long roleId) {
		RoleMenusEntity roleMenusEntity = this.roleMenusMapper.queryById(roleId);
		return BeanUtil.copy(roleMenusEntity, RoleMenusDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param roleMenusVO 筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<RoleMenusDTO> queryByPage(RoleMenusVO roleMenusVO, PageRequest pageRequest) {
		long total = this.roleMenusMapper.count(roleMenusVO);
		List<RoleMenusEntity> roleMenusEntityS = this.roleMenusMapper.queryAllByLimit(roleMenusVO, pageRequest);
		List<RoleMenusDTO> roleMenusDTOS = BeanUtil.copyToList(roleMenusEntityS, RoleMenusDTO.class);
		return new PageImpl<>(roleMenusDTOS, pageRequest, total);
	}

	/**
	 * 新增数据
	 *
	 * @param roleMenusVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public RoleMenusDTO insert(RoleMenusVO roleMenusVO) {
		RoleMenusEntity roleMenusEntity = BeanUtil.copy(roleMenusVO, RoleMenusEntity.class);
		this.roleMenusMapper.insert(roleMenusEntity);
		return BeanUtil.copy(roleMenusEntity, RoleMenusDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param roleMenusVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public RoleMenusDTO update(RoleMenusVO roleMenusVO) {
		RoleMenusEntity roleMenusEntity = BeanUtil.copy(roleMenusVO, RoleMenusEntity.class);
		this.roleMenusMapper.update(roleMenusEntity);
		return this.queryById(roleMenusVO.getRoleId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param roleId 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long roleId) {
		return this.roleMenusMapper.deleteById(roleId) > 0;
	}

}
