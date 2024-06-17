package com.soft.park.controller;

import com.soft.park.result.Result;
import com.soft.park.service.IProjectResponsibilityService;
import com.soft.park.vo.ProjectResponsibilityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:17
 * @description 项目责任描述表(ProjectResponsibility)控制层
 */
@RestController
@RequestMapping("/projectResponsibility")
public class ProjectResponsibilityController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IProjectResponsibilityService iProjectResponsibilityService;

	/**
	 * 分页查询
	 *
	 * @param projectResponsibilityVO 筛选条件
	 * @param pageRequest             分页对象
	 * @return 查询结果
	 */
	@GetMapping("list-page")
	public Result queryByPage(ProjectResponsibilityVO projectResponsibilityVO, PageRequest pageRequest) {
		return Result.success(this.iProjectResponsibilityService.queryByPage(projectResponsibilityVO, pageRequest));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iProjectResponsibilityService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param projectResponsibilityVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody ProjectResponsibilityVO projectResponsibilityVO) {
		return Result.success(this.iProjectResponsibilityService.insert(projectResponsibilityVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param projectResponsibilityVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody ProjectResponsibilityVO projectResponsibilityVO) {
		return Result.success(this.iProjectResponsibilityService.update(projectResponsibilityVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iProjectResponsibilityService.deleteById(id));
	}

}

