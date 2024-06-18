package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.ProjectResumeRelationDTO;
import com.soft.park.entity.ProjectResumeRelationEntity;
import com.soft.park.mapper.ProjectResumeRelationMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IProjectResumeRelationService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.ProjectResumeRelationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
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
		ProjectResumeRelationEntity projectResumeRelationEntity = this.getById(id);
		return BeanUtil.copy(projectResumeRelationEntity, ProjectResumeRelationDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param projectResumeRelationVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<ProjectResumeRelationDTO> queryByPage(ProjectResumeRelationVO projectResumeRelationVO) {
		Page<ProjectResumeRelationEntity> Page = new Page<>(projectResumeRelationVO.getPageNo(), projectResumeRelationVO.getPageSize());
		Page<ProjectResumeRelationEntity> entityPage = this.page(Page);

		ResultPage<ProjectResumeRelationDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, ProjectResumeRelationDTO.class);
		return resultPage;
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
		super.saveOrUpdate(projectResumeRelationEntity);
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
		super.saveOrUpdate(projectResumeRelationEntity);
		return BeanUtil.copy(projectResumeRelationEntity, ProjectResumeRelationDTO.class);
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
