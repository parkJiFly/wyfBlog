package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.CommentsDTO;
import com.soft.park.result.Result;
import com.soft.park.service.ICommentsService;
import com.soft.park.vo.CommentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-25 18:11:58
 * @description 评论表(Comments)控制层
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

	/**
	 * 服务对象
	 */
	@Autowired
	private ICommentsService iCommentsService;

	/**
	 * 分页查询
	 *
	 * @param commentsVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<CommentsDTO>> queryByPage(CommentsVO commentsVO) {
		return Result.success(this.iCommentsService.queryByPage(commentsVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iCommentsService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param commentsVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody CommentsVO commentsVO) {
		return Result.success(this.iCommentsService.insert(commentsVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param commentsVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody CommentsVO commentsVO) {
		return Result.success(this.iCommentsService.update(commentsVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iCommentsService.deleteById(id));
	}

}

