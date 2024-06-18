package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.SkillDTO;
import com.soft.park.result.Result;
import com.soft.park.service.ISkillService;
import com.soft.park.vo.SkillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:45:46
 * @description 技术能力情况表(Skill)控制层
 */
@RestController
@RequestMapping("/skill")
public class SkillController {

	/**
	 * 服务对象
	 */
	@Autowired
	private ISkillService iSkillService;

	/**
	 * 分页查询
	 *
	 * @param skillVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<SkillDTO>> queryByPage(SkillVO skillVO) {
		return Result.success(this.iSkillService.queryByPage(skillVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iSkillService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param skillVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody SkillVO skillVO) {
		return Result.success(this.iSkillService.insert(skillVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param skillVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody SkillVO skillVO) {
		return Result.success(this.iSkillService.update(skillVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iSkillService.deleteById(id));
	}

}

