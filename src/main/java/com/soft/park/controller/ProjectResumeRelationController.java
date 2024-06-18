package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.ProjectResumeRelationDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IProjectResumeRelationService;
import com.soft.park.vo.ProjectResumeRelationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:45:46
 * @description 项目简历关联表(ProjectResumeRelation)控制层
 */
@RestController
@RequestMapping("/projectResumeRelation")
public class ProjectResumeRelationController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IProjectResumeRelationService iProjectResumeRelationService;

	/**
	 * 分页查询
	 *
	 * @param projectResumeRelationVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<ProjectResumeRelationDTO>> queryByPage(ProjectResumeRelationVO projectResumeRelationVO) {
		return Result.success(this.iProjectResumeRelationService.queryByPage(projectResumeRelationVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iProjectResumeRelationService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param projectResumeRelationVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody ProjectResumeRelationVO projectResumeRelationVO) {
		return Result.success(this.iProjectResumeRelationService.insert(projectResumeRelationVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param projectResumeRelationVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody ProjectResumeRelationVO projectResumeRelationVO) {
		return Result.success(this.iProjectResumeRelationService.update(projectResumeRelationVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iProjectResumeRelationService.deleteById(id));
	}

}

