package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.ProjectExperienceDTO;
import com.soft.park.entity.ProjectExperienceEntity;
import com.soft.park.mapper.ProjectExperienceMapper;
import com.soft.park.service.IProjectExperienceService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.ProjectExperienceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:17
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
		ProjectExperienceEntity projectExperienceEntity = this.projectExperienceMapper.queryById(id);
		return BeanUtil.copy(projectExperienceEntity, ProjectExperienceDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param projectExperienceVO 筛选条件
	 * @param pageRequest         分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<ProjectExperienceDTO> queryByPage(ProjectExperienceVO projectExperienceVO, PageRequest pageRequest) {
		long total = this.projectExperienceMapper.count(projectExperienceVO);
		List<ProjectExperienceEntity> projectExperienceEntityS = this.projectExperienceMapper.queryAllByLimit(projectExperienceVO, pageRequest);
		List<ProjectExperienceDTO> projectExperienceDTOS = BeanUtil.copyToList(projectExperienceEntityS, ProjectExperienceDTO.class);
		return new PageImpl<>(projectExperienceDTOS, pageRequest, total);
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
		this.projectExperienceMapper.insert(projectExperienceEntity);
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
		this.projectExperienceMapper.update(projectExperienceEntity);
		return this.queryById(projectExperienceVO.getId());
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
