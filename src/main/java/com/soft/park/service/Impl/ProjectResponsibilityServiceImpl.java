package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.ProjectResponsibilityDTO;
import com.soft.park.entity.ProjectResponsibilityEntity;
import com.soft.park.mapper.ProjectResponsibilityMapper;
import com.soft.park.service.IProjectResponsibilityService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.ProjectResponsibilityVO;
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
 * @date 2024-06-17 19:40:18
 * @description 项目责任描述表(ProjectResponsibility)表服务实现类
 */
@Service
@Slf4j
public class ProjectResponsibilityServiceImpl extends ServiceImpl<ProjectResponsibilityMapper, ProjectResponsibilityEntity> implements IProjectResponsibilityService {

	@Autowired
	private ProjectResponsibilityMapper projectResponsibilityMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public ProjectResponsibilityDTO queryById(Long id) {
		ProjectResponsibilityEntity projectResponsibilityEntity = this.projectResponsibilityMapper.queryById(id);
		return BeanUtil.copy(projectResponsibilityEntity, ProjectResponsibilityDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param projectResponsibilityVO 筛选条件
	 * @param pageRequest             分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<ProjectResponsibilityDTO> queryByPage(ProjectResponsibilityVO projectResponsibilityVO, PageRequest pageRequest) {
		long total = this.projectResponsibilityMapper.count(projectResponsibilityVO);
		List<ProjectResponsibilityEntity> projectResponsibilityEntityS = this.projectResponsibilityMapper.queryAllByLimit(projectResponsibilityVO, pageRequest);
		List<ProjectResponsibilityDTO> projectResponsibilityDTOS = BeanUtil.copyToList(projectResponsibilityEntityS, ProjectResponsibilityDTO.class);
		return new PageImpl<>(projectResponsibilityDTOS, pageRequest, total);
	}

	/**
	 * 新增数据
	 *
	 * @param projectResponsibilityVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public ProjectResponsibilityDTO insert(ProjectResponsibilityVO projectResponsibilityVO) {
		ProjectResponsibilityEntity projectResponsibilityEntity = BeanUtil.copy(projectResponsibilityVO, ProjectResponsibilityEntity.class);
		this.projectResponsibilityMapper.insert(projectResponsibilityEntity);
		return BeanUtil.copy(projectResponsibilityEntity, ProjectResponsibilityDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param projectResponsibilityVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public ProjectResponsibilityDTO update(ProjectResponsibilityVO projectResponsibilityVO) {
		ProjectResponsibilityEntity projectResponsibilityEntity = BeanUtil.copy(projectResponsibilityVO, ProjectResponsibilityEntity.class);
		this.projectResponsibilityMapper.update(projectResponsibilityEntity);
		return this.queryById(projectResponsibilityVO.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.projectResponsibilityMapper.deleteById(id) > 0;
	}

}
