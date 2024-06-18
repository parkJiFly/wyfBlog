package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.ProjectExperienceDTO;
import com.soft.park.entity.ProjectExperienceEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.ProjectExperienceVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:23
 * @description 项目经验情况表(ProjectExperience)表服务接口
 */
public interface IProjectExperienceService extends IService<ProjectExperienceEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	ProjectExperienceDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param projectExperienceVO 筛选条件
	 * @return 查询结果
	 */
	ResultPage<ProjectExperienceDTO> queryByPage(ProjectExperienceVO projectExperienceVO);

	/**
	 * 新增数据
	 *
	 * @param projectExperienceVO 实例对象
	 * @return 实例对象
	 */
	ProjectExperienceDTO insert(ProjectExperienceVO projectExperienceVO);

	/**
	 * 修改数据
	 *
	 * @param projectExperienceVO 实例对象
	 * @return 实例对象
	 */
	ProjectExperienceDTO update(ProjectExperienceVO projectExperienceVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
