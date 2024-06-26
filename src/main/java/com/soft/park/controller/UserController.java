package com.soft.park.controller;

import com.soft.park.result.Result;
import com.soft.park.service.IUserService;
import com.soft.park.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:21
 * @description (User)控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IUserService iUserService;

	/**
	 * 分页查询
	 *
	 * @param userVO      筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@GetMapping("list-page")
	public Result queryByPage(UserVO userVO, PageRequest pageRequest) {
		return Result.success(this.iUserService.queryByPage(userVO, pageRequest));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Object id) {
		return Result.success(this.iUserService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param userVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody UserVO userVO) {
		return Result.success(this.iUserService.insert(userVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param userVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody UserVO userVO) {
		return Result.success(this.iUserService.update(userVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iUserService.deleteById(id));
	}

}

