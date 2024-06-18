package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.RoleFieldPermissionsDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IRoleFieldPermissionsService;
import com.soft.park.vo.RoleFieldPermissionsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:45:46
 * @description 角色字段权限关联表(RoleFieldPermissions)控制层
 */
@RestController
@RequestMapping("/roleFieldPermissions")
public class RoleFieldPermissionsController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IRoleFieldPermissionsService iRoleFieldPermissionsService;

	/**
	 * 分页查询
	 *
	 * @param roleFieldPermissionsVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<RoleFieldPermissionsDTO>> queryByPage(RoleFieldPermissionsVO roleFieldPermissionsVO) {
		return Result.success(this.iRoleFieldPermissionsService.queryByPage(roleFieldPermissionsVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iRoleFieldPermissionsService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param roleFieldPermissionsVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody RoleFieldPermissionsVO roleFieldPermissionsVO) {
		return Result.success(this.iRoleFieldPermissionsService.insert(roleFieldPermissionsVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param roleFieldPermissionsVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody RoleFieldPermissionsVO roleFieldPermissionsVO) {
		return Result.success(this.iRoleFieldPermissionsService.update(roleFieldPermissionsVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iRoleFieldPermissionsService.deleteById(id));
	}

}

