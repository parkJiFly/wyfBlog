package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.MenusDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IMenusService;
import com.soft.park.vo.MenusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:45:46
 * @description 菜单表(Menus)控制层
 */
@RestController
@RequestMapping("/menus")
public class MenusController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IMenusService iMenusService;

	/**
	 * 分页查询
	 *
	 * @param menusVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<MenusDTO>> queryByPage(MenusVO menusVO) {
		return Result.success(this.iMenusService.queryByPage(menusVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iMenusService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param menusVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody MenusVO menusVO) {
		return Result.success(this.iMenusService.insert(menusVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param menusVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody MenusVO menusVO) {
		return Result.success(this.iMenusService.update(menusVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iMenusService.deleteById(id));
	}

}

