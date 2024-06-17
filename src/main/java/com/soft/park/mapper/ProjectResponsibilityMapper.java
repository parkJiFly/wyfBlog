package com.soft.park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.park.entity.ProjectResponsibilityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:18
 * @description 项目责任描述表(ProjectResponsibility)mapper层
 */
@Mapper
public interface ProjectResponsibilityMapper extends BaseMapper<ProjectResponsibilityEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	ProjectResponsibilityEntity queryById(Long id);

	/**
	 * 查询指定行数据
	 *
	 * @param projectResponsibility 查询条件
	 * @param pageable              分页对象
	 * @return 对象列表
	 */
	List<ProjectResponsibilityEntity> queryAllByLimit(ProjectResponsibilityEntity projectResponsibility, @Param("pageable") Pageable pageable);

	/**
	 * 统计总行数
	 *
	 * @param projectResponsibility 查询条件
	 * @return 总行数
	 */
	long count(ProjectResponsibilityEntity projectResponsibility);

	/**
	 * 新增数据
	 *
	 * @param projectResponsibility 实例对象
	 * @return 影响行数
	 */
	int insert(ProjectResponsibilityEntity projectResponsibility);

	/**
	 * 批量新增数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<ProjectResponsibilityEntity> 实例对象列表
	 * @return 影响行数
	 */
	int insertBatch(@Param("entities") List<ProjectResponsibilityEntity> entities);

	/**
	 * 批量新增或按主键更新数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<ProjectResponsibilityEntity> 实例对象列表
	 * @return 影响行数
	 * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
	 */
	int insertOrUpdateBatch(@Param("entities") List<ProjectResponsibilityEntity> entities);

	/**
	 * 修改数据
	 *
	 * @param projectResponsibility 实例对象
	 * @return 影响行数
	 */
	int update(ProjectResponsibilityEntity projectResponsibility);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 影响行数
	 */
	int deleteById(Long id);

}

