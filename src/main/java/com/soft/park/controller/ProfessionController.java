package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.ProfessionDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IProfessionService;
import com.soft.park.vo.ProfessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:45:46
 * @description 专业表(Profession)控制层
 */
@RestController
@RequestMapping("/profession")
public class ProfessionController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IProfessionService iProfessionService;

	/**
	 * 分页查询
	 *
	 * @param professionVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<ProfessionDTO>> queryByPage(ProfessionVO professionVO) {
		return Result.success(this.iProfessionService.queryByPage(professionVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iProfessionService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param professionVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody ProfessionVO professionVO) {
		return Result.success(this.iProfessionService.insert(professionVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param professionVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody ProfessionVO professionVO) {
		return Result.success(this.iProfessionService.update(professionVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iProfessionService.deleteById(id));
	}

}

