package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.BlogsDTO;
import com.soft.park.entity.BlogsEntity;
import com.soft.park.mapper.BlogsMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IBlogsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.BlogsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-25 18:11:57
 * @description 博客表(Blogs)表服务实现类
 */
@Service
@Slf4j
public class BlogsServiceImpl extends ServiceImpl<BlogsMapper, BlogsEntity> implements IBlogsService {

	@Autowired
	private BlogsMapper blogsMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public BlogsDTO queryById(Long id) {
		BlogsEntity blogsEntity = this.getById(id);
		return BeanUtil.copy(blogsEntity, BlogsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param blogsVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<BlogsDTO> queryByPage(BlogsVO blogsVO) {
		Page<BlogsEntity> Page = new Page<>(blogsVO.getPageNo(), blogsVO.getPageSize());
		Page<BlogsEntity> entityPage = this.page(Page);

		ResultPage<BlogsDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, BlogsDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param blogsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public BlogsDTO insert(BlogsVO blogsVO) {
		BlogsEntity blogsEntity = BeanUtil.copy(blogsVO, BlogsEntity.class);
		super.saveOrUpdate(blogsEntity);
		return BeanUtil.copy(blogsEntity, BlogsDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param blogsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public BlogsDTO update(BlogsVO blogsVO) {
		BlogsEntity blogsEntity = BeanUtil.copy(blogsVO, BlogsEntity.class);
		super.saveOrUpdate(blogsEntity);
		return BeanUtil.copy(blogsEntity, BlogsDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.blogsMapper.deleteById(id) > 0;
	}

}
