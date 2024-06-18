package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.RoleMenusDTO;
import com.soft.park.entity.RoleMenusEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.RoleMenusVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:25
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
	 * @return 查询结果
	 */
	ResultPage<RoleMenusDTO> queryByPage(RoleMenusVO roleMenusVO);

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
