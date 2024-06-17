package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.ProjectExperienceDTO;
import com.soft.park.entity.ProjectExperienceEntity;
import com.soft.park.vo.ProjectExperienceVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:17
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
	 * @param pageRequest         分页对象
	 * @return 查询结果
	 */
	Page<ProjectExperienceDTO> queryByPage(ProjectExperienceVO projectExperienceVO, PageRequest pageRequest);

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
