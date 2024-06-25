package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.BlogsDTO;
import com.soft.park.entity.BlogsEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.BlogsVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-25 18:11:57
 * @description 博客表(Blogs)表服务接口
 */
public interface IBlogsService extends IService<BlogsEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	BlogsDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param blogsVO 筛选条件
	 * @return 查询结果
	 */
	ResultPage<BlogsDTO> queryByPage(BlogsVO blogsVO);

	/**
	 * 新增数据
	 *
	 * @param blogsVO 实例对象
	 * @return 实例对象
	 */
	BlogsDTO insert(BlogsVO blogsVO);

	/**
	 * 修改数据
	 *
	 * @param blogsVO 实例对象
	 * @return 实例对象
	 */
	BlogsDTO update(BlogsVO blogsVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
