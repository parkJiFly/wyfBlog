package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.ProjectResumeRelationDTO;
import com.soft.park.entity.ProjectResumeRelationEntity;
import com.soft.park.mapper.ProjectResumeRelationMapper;
import com.soft.park.service.IProjectResumeRelationService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.ProjectResumeRelationVO;
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
 * @date 2024-06-17 19:40:19
 * @description 项目简历关联表(ProjectResumeRelation)表服务实现类
 */
@Service
@Slf4j
public class ProjectResumeRelationServiceImpl extends ServiceImpl<ProjectResumeRelationMapper, ProjectResumeRelationEntity> implements IProjectResumeRelationService {

	@Autowired
	private ProjectResumeRelationMapper projectResumeRelationMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public ProjectResumeRelationDTO queryById(Long id) {
		ProjectResumeRelationEntity projectResumeRelationEntity = this.projectResumeRelationMapper.queryById(id);
		return BeanUtil.copy(projectResumeRelationEntity, ProjectResumeRelationDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param projectResumeRelationVO 筛选条件
	 * @param pageRequest             分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<ProjectResumeRelationDTO> queryByPage(ProjectResumeRelationVO projectResumeRelationVO, PageRequest pageRequest) {
		long total = this.projectResumeRelationMapper.count(projectResumeRelationVO);
		List<ProjectResumeRelationEntity> projectResumeRelationEntityS = this.projectResumeRelationMapper.queryAllByLimit(projectResumeRelationVO, pageRequest);
		List<ProjectResumeRelationDTO> projectResumeRelationDTOS = BeanUtil.copyToList(projectResumeRelationEntityS, ProjectResumeRelationDTO.class);
		return new PageImpl<>(projectResumeRelationDTOS, pageRequest, total);
	}

	/**
	 * 新增数据
	 *
	 * @param projectResumeRelationVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public ProjectResumeRelationDTO insert(ProjectResumeRelationVO projectResumeRelationVO) {
		ProjectResumeRelationEntity projectResumeRelationEntity = BeanUtil.copy(projectResumeRelationVO, ProjectResumeRelationEntity.class);
		this.projectResumeRelationMapper.insert(projectResumeRelationEntity);
		return BeanUtil.copy(projectResumeRelationEntity, ProjectResumeRelationDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param projectResumeRelationVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public ProjectResumeRelationDTO update(ProjectResumeRelationVO projectResumeRelationVO) {
		ProjectResumeRelationEntity projectResumeRelationEntity = BeanUtil.copy(projectResumeRelationVO, ProjectResumeRelationEntity.class);
		this.projectResumeRelationMapper.update(projectResumeRelationEntity);
		return this.queryById(projectResumeRelationVO.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.projectResumeRelationMapper.deleteById(id) > 0;
	}

}
