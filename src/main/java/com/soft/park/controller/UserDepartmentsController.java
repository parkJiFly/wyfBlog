package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.UserDepartmentsDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IUserDepartmentsService;
import com.soft.park.vo.UserDepartmentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:45:46
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
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<UserDepartmentsDTO>> queryByPage(UserDepartmentsVO userDepartmentsVO) {
		return Result.success(this.iUserDepartmentsService.queryByPage(userDepartmentsVO));
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

