package com.soft.park.controller;

import com.soft.park.result.Result;
import com.soft.park.service.IPositionService;
import com.soft.park.vo.PositionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:13
 * @description 岗位表(Position)控制层
 */
@RestController
@RequestMapping("/position")
public class PositionController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IPositionService iPositionService;

	/**
	 * 分页查询
	 *
	 * @param positionVO  筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@GetMapping("list-page")
	public Result queryByPage(PositionVO positionVO, PageRequest pageRequest) {
		return Result.success(this.iPositionService.queryByPage(positionVO, pageRequest));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iPositionService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param positionVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody PositionVO positionVO) {
		return Result.success(this.iPositionService.insert(positionVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param positionVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody PositionVO positionVO) {
		return Result.success(this.iPositionService.update(positionVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iPositionService.deleteById(id));
	}

}

