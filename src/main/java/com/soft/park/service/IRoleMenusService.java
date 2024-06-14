package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.RoleMenusDTO;
import com.soft.park.entity.RoleMenusEntity;
import com.soft.park.vo.RoleMenusVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:40:41
 * @description 角色菜单关联表(RoleMenus)表服务接口
 */
public interface IRoleMenusService extends IService<RoleMenusEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param roleId 主键
	 * @return 实例对象
	 */
	RoleMenusDTO queryById(Long roleId);

	/**
	 * 分页查询
	 *
	 * @param roleMenusVO 筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	Page<RoleMenusDTO> queryByPage(RoleMenusVO roleMenusVO, PageRequest pageRequest);

	/**
	 * 新增数据
	 *
	 * @param roleMenusVO 实例对象
	 * @return 实例对象
	 */
	RoleMenusDTO insert(RoleMenusVO roleMenusVO);

	/**
	 * 修改数据
	 *
	 * @param roleMenusVO 实例对象
	 * @return 实例对象
	 */
	RoleMenusDTO update(RoleMenusVO roleMenusVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param roleId 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long roleId);

}
