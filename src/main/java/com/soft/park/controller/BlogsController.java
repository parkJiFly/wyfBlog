package com.soft.park.controller;

import com.soft.park.entity.BlogsEntity;
import com.soft.park.service.IBlogsService;
import com.soft.park.result.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-25 18:11:53
 * @description 博客表(Blogs)控制层
 */
@RestController
@RequestMapping("/blogs")
public class BlogsController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IBlogsService iBlogsService;

	/**
	 * 分页查询
	 *
	 * @param blogsVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<BlogsDTO>> queryByPage(BlogsVO blogsVO) {
		return Result.success(this.iBlogsService.queryByPage(blogsVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iBlogsService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param blogsVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody BlogsVO blogsVO) {
		return Result.success(this.iBlogsService.insert(blogsVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param blogsVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody BlogsVO blogsVO) {
		return Result.success(this.iBlogsService.update(blogsVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iBlogsService.deleteById(id));
	}

}

