package com.soft.park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.park.entity.UserDepartmentsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:31
 * @description 用户部门关联表(UserDepartments)mapper层
 */
@Mapper
public interface UserDepartmentsMapper extends BaseMapper<UserDepartmentsEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param userId 主键
	 * @return 实例对象
	 */
	UserDepartmentsEntity queryById(Long userId);

	/**
	 * 查询指定行数据
	 *
	 * @param userDepartments 查询条件
	 * @param pageable        分页对象
	 * @return 对象列表
	 */
	List<UserDepartmentsEntity> queryAllByLimit(UserDepartmentsEntity userDepartments, @Param("pageable") Pageable pageable);

	/**
	 * 统计总行数
	 *
	 * @param userDepartments 查询条件
	 * @return 总行数
	 */
	long count(UserDepartmentsEntity userDepartments);

	/**
	 * 新增数据
	 *
	 * @param userDepartments 实例对象
	 * @return 影响行数
	 */
	int insert(UserDepartmentsEntity userDepartments);

	/**
	 * 批量新增数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<UserDepartmentsEntity> 实例对象列表
	 * @return 影响行数
	 */
	int insertBatch(@Param("entities") List<UserDepartmentsEntity> entities);

	/**
	 * 批量新增或按主键更新数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<UserDepartmentsEntity> 实例对象列表
	 * @return 影响行数
	 * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
	 */
	int insertOrUpdateBatch(@Param("entities") List<UserDepartmentsEntity> entities);

	/**
	 * 修改数据
	 *
	 * @param userDepartments 实例对象
	 * @return 影响行数
	 */
	int update(UserDepartmentsEntity userDepartments);

	/**
	 * 通过主键删除数据
	 *
	 * @param userId 主键
	 * @return 影响行数
	 */
	int deleteById(Long userId);

}

