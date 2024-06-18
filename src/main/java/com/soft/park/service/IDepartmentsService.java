package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.DepartmentsDTO;
import com.soft.park.entity.DepartmentsEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.DepartmentsVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:20
 * @description 部门表(Departments)表服务接口
 */
public interface IDepartmentsService extends IService<DepartmentsEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	DepartmentsDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param departmentsVO 筛选条件
	 * @return 查询结果
	 */
	ResultPage<DepartmentsDTO> queryByPage(DepartmentsVO departmentsVO);

	/**
	 * 新增数据
	 *
	 * @param departmentsVO 实例对象
	 * @return 实例对象
	 */
	DepartmentsDTO insert(DepartmentsVO departmentsVO);

	/**
	 * 修改数据
	 *
	 * @param departmentsVO 实例对象
	 * @return 实例对象
	 */
	DepartmentsDTO update(DepartmentsVO departmentsVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
