package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.RoleFieldPermissionsDTO;
import com.soft.park.entity.RoleFieldPermissionsEntity;
import com.soft.park.vo.RoleFieldPermissionsVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:40:40
 * @description 角色字段权限关联表(RoleFieldPermissions)表服务接口
 */
public interface IRoleFieldPermissionsService extends IService<RoleFieldPermissionsEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param roleId 主键
	 * @return 实例对象
	 */
	RoleFieldPermissionsDTO queryById(Long roleId);

	/**
	 * 分页查询
	 *
	 * @param roleFieldPermissionsVO 筛选条件
	 * @param pageRequest            分页对象
	 * @return 查询结果
	 */
	Page<RoleFieldPermissionsDTO> queryByPage(RoleFieldPermissionsVO roleFieldPermissionsVO, PageRequest pageRequest);

	/**
	 * 新增数据
	 *
	 * @param roleFieldPermissionsVO 实例对象
	 * @return 实例对象
	 */
	RoleFieldPermissionsDTO insert(RoleFieldPermissionsVO roleFieldPermissionsVO);

	/**
	 * 修改数据
	 *
	 * @param roleFieldPermissionsVO 实例对象
	 * @return 实例对象
	 */
	RoleFieldPermissionsDTO update(RoleFieldPermissionsVO roleFieldPermissionsVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param roleId 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long roleId);

}
