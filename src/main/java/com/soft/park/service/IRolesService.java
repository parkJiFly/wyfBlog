package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.RolesDTO;
import com.soft.park.entity.RolesEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.RolesVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:26
 * @description 角色表(Roles)表服务接口
 */
public interface IRolesService extends IService<RolesEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	RolesDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param rolesVO     筛选条件
	 * @return 查询结果
	 */
	ResultPage<RolesDTO> queryByPage(RolesVO rolesVO);

	/**
	 * 新增数据
	 *
	 * @param rolesVO 实例对象
	 * @return 实例对象
	 */
	RolesDTO insert(RolesVO rolesVO);

	/**
	 * 修改数据
	 *
	 * @param rolesVO 实例对象
	 * @return 实例对象
	 */
	RolesDTO update(RolesVO rolesVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
