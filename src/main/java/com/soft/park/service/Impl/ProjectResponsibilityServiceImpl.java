package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.ProjectResponsibilityDTO;
import com.soft.park.entity.ProjectResponsibilityEntity;
import com.soft.park.mapper.ProjectResponsibilityMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IProjectResponsibilityService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.ProjectResponsibilityVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
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
		ProjectResponsibilityEntity projectResponsibilityEntity = this.getById(id);
		return BeanUtil.copy(projectResponsibilityEntity, ProjectResponsibilityDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param projectResponsibilityVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<ProjectResponsibilityDTO> queryByPage(ProjectResponsibilityVO projectResponsibilityVO) {
		Page<ProjectResponsibilityEntity> Page = new Page<>(projectResponsibilityVO.getPageNo(), projectResponsibilityVO.getPageSize());
		Page<ProjectResponsibilityEntity> entityPage = this.page(Page);

		ResultPage<ProjectResponsibilityDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, ProjectResponsibilityDTO.class);
		return resultPage;
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
		super.saveOrUpdate(projectResponsibilityEntity);
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
		super.saveOrUpdate(projectResponsibilityEntity);
		return BeanUtil.copy(projectResponsibilityEntity, ProjectResponsibilityDTO.class);
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
