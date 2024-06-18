package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.ProjectResumeRelationDTO;
import com.soft.park.entity.ProjectResumeRelationEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.ProjectResumeRelationVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:24
 * @description 项目简历关联表(ProjectResumeRelation)表服务接口
 */
public interface IProjectResumeRelationService extends IService<ProjectResumeRelationEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	ProjectResumeRelationDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param projectResumeRelationVO 筛选条件
	 * @return 查询结果
	 */
	ResultPage<ProjectResumeRelationDTO> queryByPage(ProjectResumeRelationVO projectResumeRelationVO);

	/**
	 * 新增数据
	 *
	 * @param projectResumeRelationVO 实例对象
	 * @return 实例对象
	 */
	ProjectResumeRelationDTO insert(ProjectResumeRelationVO projectResumeRelationVO);

	/**
	 * 修改数据
	 *
	 * @param projectResumeRelationVO 实例对象
	 * @return 实例对象
	 */
	ProjectResumeRelationDTO update(ProjectResumeRelationVO projectResumeRelationVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
