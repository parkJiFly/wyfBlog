package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.ProjectResponsibilityDTO;
import com.soft.park.entity.ProjectResponsibilityEntity;
import com.soft.park.vo.ProjectResponsibilityVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:18
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
	 * @param pageRequest             分页对象
	 * @return 查询结果
	 */
	Page<ProjectResponsibilityDTO> queryByPage(ProjectResponsibilityVO projectResponsibilityVO, PageRequest pageRequest);

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
