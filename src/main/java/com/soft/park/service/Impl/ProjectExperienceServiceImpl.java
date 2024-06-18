package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.ProjectExperienceDTO;
import com.soft.park.entity.ProjectExperienceEntity;
import com.soft.park.mapper.ProjectExperienceMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IProjectExperienceService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.ProjectExperienceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
 * @description 项目经验情况表(ProjectExperience)表服务实现类
 */
@Service
@Slf4j
public class ProjectExperienceServiceImpl extends ServiceImpl<ProjectExperienceMapper, ProjectExperienceEntity> implements IProjectExperienceService {

	@Autowired
	private ProjectExperienceMapper projectExperienceMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public ProjectExperienceDTO queryById(Long id) {
		ProjectExperienceEntity projectExperienceEntity = this.getById(id);
		return BeanUtil.copy(projectExperienceEntity, ProjectExperienceDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param projectExperienceVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<ProjectExperienceDTO> queryByPage(ProjectExperienceVO projectExperienceVO) {
		Page<ProjectExperienceEntity> Page = new Page<>(projectExperienceVO.getPageNo(), projectExperienceVO.getPageSize());
		Page<ProjectExperienceEntity> entityPage = this.page(Page);

		ResultPage<ProjectExperienceDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, ProjectExperienceDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param projectExperienceVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public ProjectExperienceDTO insert(ProjectExperienceVO projectExperienceVO) {
		ProjectExperienceEntity projectExperienceEntity = BeanUtil.copy(projectExperienceVO, ProjectExperienceEntity.class);
		super.saveOrUpdate(projectExperienceEntity);
		return BeanUtil.copy(projectExperienceEntity, ProjectExperienceDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param projectExperienceVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public ProjectExperienceDTO update(ProjectExperienceVO projectExperienceVO) {
		ProjectExperienceEntity projectExperienceEntity = BeanUtil.copy(projectExperienceVO, ProjectExperienceEntity.class);
		super.saveOrUpdate(projectExperienceEntity);
		return BeanUtil.copy(projectExperienceEntity, ProjectExperienceDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.projectExperienceMapper.deleteById(id) > 0;
	}

}
