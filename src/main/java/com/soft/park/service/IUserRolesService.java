package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.UserRolesDTO;
import com.soft.park.entity.UserRolesEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.UserRolesVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:31
 * @description 用户角色关联表(UserRoles)表服务接口
 */
public interface IUserRolesService extends IService<UserRolesEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param userId 主键
	 * @return 实例对象
	 */
	UserRolesDTO queryById(Long userId);

	/**
	 * 分页查询
	 *
	 * @param userRolesVO 筛选条件
	 * @return 查询结果
	 */
	ResultPage<UserRolesDTO> queryByPage(UserRolesVO userRolesVO);

	/**
	 * 新增数据
	 *
	 * @param userRolesVO 实例对象
	 * @return 实例对象
	 */
	UserRolesDTO insert(UserRolesVO userRolesVO);

	/**
	 * 修改数据
	 *
	 * @param userRolesVO 实例对象
	 * @return 实例对象
	 */
	UserRolesDTO update(UserRolesVO userRolesVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param userId 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long userId);

}
