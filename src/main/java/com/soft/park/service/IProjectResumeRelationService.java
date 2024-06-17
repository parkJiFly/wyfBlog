package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.ProjectResumeRelationDTO;
import com.soft.park.entity.ProjectResumeRelationEntity;
import com.soft.park.vo.ProjectResumeRelationVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:19
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
	 * @param pageRequest             分页对象
	 * @return 查询结果
	 */
	Page<ProjectResumeRelationDTO> queryByPage(ProjectResumeRelationVO projectResumeRelationVO, PageRequest pageRequest);

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
