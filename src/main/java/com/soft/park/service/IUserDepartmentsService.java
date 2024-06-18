package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.UserDepartmentsDTO;
import com.soft.park.entity.UserDepartmentsEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.UserDepartmentsVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:31
 * @description 用户部门关联表(UserDepartments)表服务接口
 */
public interface IUserDepartmentsService extends IService<UserDepartmentsEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param userId 主键
	 * @return 实例对象
	 */
	UserDepartmentsDTO queryById(Long userId);

	/**
	 * 分页查询
	 *
	 * @param userDepartmentsVO 筛选条件
	 * @return 查询结果
	 */
	ResultPage<UserDepartmentsDTO> queryByPage(UserDepartmentsVO userDepartmentsVO);

	/**
	 * 新增数据
	 *
	 * @param userDepartmentsVO 实例对象
	 * @return 实例对象
	 */
	UserDepartmentsDTO insert(UserDepartmentsVO userDepartmentsVO);

	/**
	 * 修改数据
	 *
	 * @param userDepartmentsVO 实例对象
	 * @return 实例对象
	 */
	UserDepartmentsDTO update(UserDepartmentsVO userDepartmentsVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param userId 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long userId);

}
