package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.RoleMenusDTO;
import com.soft.park.entity.RoleMenusEntity;
import com.soft.park.mapper.RoleMenusMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IRoleMenusService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.RoleMenusVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
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
		RoleMenusEntity roleMenusEntity = this.getById(roleId);
		return BeanUtil.copy(roleMenusEntity, RoleMenusDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param roleMenusVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<RoleMenusDTO> queryByPage(RoleMenusVO roleMenusVO) {
		Page<RoleMenusEntity> Page = new Page<>(roleMenusVO.getPageNo(), roleMenusVO.getPageSize());
		Page<RoleMenusEntity> entityPage = this.page(Page);

		ResultPage<RoleMenusDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, RoleMenusDTO.class);
		return resultPage;
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
		super.saveOrUpdate(roleMenusEntity);
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
		super.saveOrUpdate(roleMenusEntity);
		return BeanUtil.copy(roleMenusEntity, RoleMenusDTO.class);
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
