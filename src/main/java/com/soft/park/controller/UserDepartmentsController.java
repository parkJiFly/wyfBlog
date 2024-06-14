package com.soft.park.controller;

import com.soft.park.result.Result;
import com.soft.park.service.IUserDepartmentsService;
import com.soft.park.vo.UserDepartmentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:40:42
 * @description 用户部门关联表(UserDepartments)控制层
 */
@RestController
@RequestMapping("/userDepartments")
public class UserDepartmentsController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IUserDepartmentsService iUserDepartmentsService;

	/**
	 * 分页查询
	 *
	 * @param userDepartmentsVO 筛选条件
	 * @param pageRequest       分页对象
	 * @return 查询结果
	 */
	@GetMapping("list-page")
	public Result queryByPage(UserDepartmentsVO userDepartmentsVO, PageRequest pageRequest) {
		return Result.success(this.iUserDepartmentsService.queryByPage(userDepartmentsVO, pageRequest));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iUserDepartmentsService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param userDepartmentsVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody UserDepartmentsVO userDepartmentsVO) {
		return Result.success(this.iUserDepartmentsService.insert(userDepartmentsVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param userDepartmentsVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody UserDepartmentsVO userDepartmentsVO) {
		return Result.success(this.iUserDepartmentsService.update(userDepartmentsVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iUserDepartmentsService.deleteById(id));
	}

}

