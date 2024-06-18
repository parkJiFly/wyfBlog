package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.DepartmentsDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IDepartmentsService;
import com.soft.park.vo.DepartmentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:45:46
 * @description 部门表(Departments)控制层
 */
@RestController
@RequestMapping("/departments")
public class DepartmentsController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IDepartmentsService iDepartmentsService;

	/**
	 * 分页查询
	 *
	 * @param departmentsVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<DepartmentsDTO>> queryByPage(DepartmentsVO departmentsVO) {
		return Result.success(this.iDepartmentsService.queryByPage(departmentsVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iDepartmentsService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param departmentsVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody DepartmentsVO departmentsVO) {
		return Result.success(this.iDepartmentsService.insert(departmentsVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param departmentsVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody DepartmentsVO departmentsVO) {
		return Result.success(this.iDepartmentsService.update(departmentsVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iDepartmentsService.deleteById(id));
	}

}

