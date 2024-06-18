package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.RoleMenusDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IRoleMenusService;
import com.soft.park.vo.RoleMenusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:45:46
 * @description 角色菜单关联表(RoleMenus)控制层
 */
@RestController
@RequestMapping("/roleMenus")
public class RoleMenusController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IRoleMenusService iRoleMenusService;

	/**
	 * 分页查询
	 *
	 * @param roleMenusVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<RoleMenusDTO>> queryByPage(RoleMenusVO roleMenusVO) {
		return Result.success(this.iRoleMenusService.queryByPage(roleMenusVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iRoleMenusService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param roleMenusVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody RoleMenusVO roleMenusVO) {
		return Result.success(this.iRoleMenusService.insert(roleMenusVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param roleMenusVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody RoleMenusVO roleMenusVO) {
		return Result.success(this.iRoleMenusService.update(roleMenusVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iRoleMenusService.deleteById(id));
	}

}

