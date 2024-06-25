package com.soft.park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.park.entity.BlogsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-25 18:11:58
 * @description 博客表(Blogs)mapper层
 */
@Mapper
public interface BlogsMapper extends BaseMapper<BlogsEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	BlogsEntity queryById(Long id);

	/**
	 * 查询指定行数据
	 *
	 * @param blogs    查询条件
	 * @param pageable 分页对象
	 * @return 对象列表
	 */
	List<BlogsEntity> queryAllByLimit(BlogsEntity blogs, @Param("pageable") Pageable pageable);

	/**
	 * 统计总行数
	 *
	 * @param blogs 查询条件
	 * @return 总行数
	 */
	long count(BlogsEntity blogs);

	/**
	 * 新增数据
	 *
	 * @param blogs 实例对象
	 * @return 影响行数
	 */
	int insert(BlogsEntity blogs);

	/**
	 * 批量新增数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<BlogsEntity> 实例对象列表
	 * @return 影响行数
	 */
	int insertBatch(@Param("entities") List<BlogsEntity> entities);

	/**
	 * 批量新增或按主键更新数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<BlogsEntity> 实例对象列表
	 * @return 影响行数
	 * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
	 */
	int insertOrUpdateBatch(@Param("entities") List<BlogsEntity> entities);

	/**
	 * 修改数据
	 *
	 * @param blogs 实例对象
	 * @return 影响行数
	 */
	int update(BlogsEntity blogs);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 影响行数
	 */
	int deleteById(Long id);

}

