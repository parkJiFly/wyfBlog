package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.ProjectResponsibilityDTO;
import com.soft.park.entity.ProjectResponsibilityEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.ProjectResponsibilityVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:23
 * @description 项目责任描述表(ProjectResponsibility)表服务接口
 */
public interface IProjectResponsibilityService extends IService<ProjectResponsibilityEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	ProjectResponsibilityDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param projectResponsibilityVO 筛选条件
	 * @return 查询结果
	 */
	ResultPage<ProjectResponsibilityDTO> queryByPage(ProjectResponsibilityVO projectResponsibilityVO);

	/**
	 * 新增数据
	 *
	 * @param projectResponsibilityVO 实例对象
	 * @return 实例对象
	 */
	ProjectResponsibilityDTO insert(ProjectResponsibilityVO projectResponsibilityVO);

	/**
	 * 修改数据
	 *
	 * @param projectResponsibilityVO 实例对象
	 * @return 实例对象
	 */
	ProjectResponsibilityDTO update(ProjectResponsibilityVO projectResponsibilityVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
