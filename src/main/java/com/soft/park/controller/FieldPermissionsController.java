package com.soft.park.controller;

import com.soft.park.result.Result;
import com.soft.park.service.IFieldPermissionsService;
import com.soft.park.vo.FieldPermissionsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:44:11
 * @description 字段权限表(FieldPermissions)控制层
 */
@RestController
@RequestMapping("/fieldPermissions")
public class FieldPermissionsController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IFieldPermissionsService iFieldPermissionsService;

	/**
	 * 分页查询
	 *
	 * @param fieldPermissionsVO 筛选条件
	 * @param pageRequest        分页对象
	 * @return 查询结果
	 */
	@GetMapping("list-page")
	public Result queryByPage(FieldPermissionsVO fieldPermissionsVO, PageRequest pageRequest) {
		return Result.success(this.iFieldPermissionsService.queryByPage(fieldPermissionsVO, pageRequest));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iFieldPermissionsService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param fieldPermissionsVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody FieldPermissionsVO fieldPermissionsVO) {
		return Result.success(this.iFieldPermissionsService.insert(fieldPermissionsVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param fieldPermissionsVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody FieldPermissionsVO fieldPermissionsVO) {
		return Result.success(this.iFieldPermissionsService.update(fieldPermissionsVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iFieldPermissionsService.deleteById(id));
	}

}

