package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.ProjectExperienceDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IProjectExperienceService;
import com.soft.park.vo.ProjectExperienceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:45:46
 * @description 项目经验情况表(ProjectExperience)控制层
 */
@RestController
@RequestMapping("/projectExperience")
public class ProjectExperienceController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IProjectExperienceService iProjectExperienceService;

	/**
	 * 分页查询
	 *
	 * @param projectExperienceVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<ProjectExperienceDTO>> queryByPage(ProjectExperienceVO projectExperienceVO) {
		return Result.success(this.iProjectExperienceService.queryByPage(projectExperienceVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iProjectExperienceService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param projectExperienceVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody ProjectExperienceVO projectExperienceVO) {
		return Result.success(this.iProjectExperienceService.insert(projectExperienceVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param projectExperienceVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody ProjectExperienceVO projectExperienceVO) {
		return Result.success(this.iProjectExperienceService.update(projectExperienceVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iProjectExperienceService.deleteById(id));
	}

}

