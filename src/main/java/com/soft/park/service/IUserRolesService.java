package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.UserRolesDTO;
import com.soft.park.entity.UserRolesEntity;
import com.soft.park.vo.UserRolesVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:40:44
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
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	Page<UserRolesDTO> queryByPage(UserRolesVO userRolesVO, PageRequest pageRequest);

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
