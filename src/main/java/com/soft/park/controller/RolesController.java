package com.soft.park.controller;

import com.soft.park.result.Result;
import com.soft.park.service.IRolesService;
import com.soft.park.vo.RolesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:40:41
 * @description 角色表(Roles)控制层
 */
@RestController
@RequestMapping("/roles")
public class RolesController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IRolesService iRolesService;

	/**
	 * 分页查询
	 *
	 * @param rolesVO     筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@GetMapping("list-page")
	public Result queryByPage(RolesVO rolesVO, PageRequest pageRequest) {
		return Result.success(this.iRolesService.queryByPage(rolesVO, pageRequest));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iRolesService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param rolesVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody RolesVO rolesVO) {
		return Result.success(this.iRolesService.insert(rolesVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param rolesVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody RolesVO rolesVO) {
		return Result.success(this.iRolesService.update(rolesVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iRolesService.deleteById(id));
	}

}

