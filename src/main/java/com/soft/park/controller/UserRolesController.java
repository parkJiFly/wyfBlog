package com.soft.park.controller;

import com.soft.park.result.Result;
import com.soft.park.service.IUserRolesService;
import com.soft.park.vo.UserRolesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:40:43
 * @description 用户角色关联表(UserRoles)控制层
 */
@RestController
@RequestMapping("/userRoles")
public class UserRolesController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IUserRolesService iUserRolesService;

	/**
	 * 分页查询
	 *
	 * @param userRolesVO 筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@GetMapping("list-page")
	public Result queryByPage(UserRolesVO userRolesVO, PageRequest pageRequest) {
		return Result.success(this.iUserRolesService.queryByPage(userRolesVO, pageRequest));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iUserRolesService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param userRolesVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody UserRolesVO userRolesVO) {
		return Result.success(this.iUserRolesService.insert(userRolesVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param userRolesVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody UserRolesVO userRolesVO) {
		return Result.success(this.iUserRolesService.update(userRolesVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iUserRolesService.deleteById(id));
	}

}

