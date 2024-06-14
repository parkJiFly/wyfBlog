package com.soft.park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.park.entity.UserRolesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:40:44
 * @description 用户角色关联表(UserRoles)mapper层
 */
@Mapper
public interface UserRolesMapper extends BaseMapper<UserRolesEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param userId 主键
	 * @return 实例对象
	 */
	UserRolesEntity queryById(Long userId);

	/**
	 * 查询指定行数据
	 *
	 * @param userRoles 查询条件
	 * @param pageable  分页对象
	 * @return 对象列表
	 */
	List<UserRolesEntity> queryAllByLimit(UserRolesEntity userRoles, @Param("pageable") Pageable pageable);

	/**
	 * 统计总行数
	 *
	 * @param userRoles 查询条件
	 * @return 总行数
	 */
	long count(UserRolesEntity userRoles);

	/**
	 * 新增数据
	 *
	 * @param userRoles 实例对象
	 * @return 影响行数
	 */
	int insert(UserRolesEntity userRoles);

	/**
	 * 批量新增数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<UserRolesEntity> 实例对象列表
	 * @return 影响行数
	 */
	int insertBatch(@Param("entities") List<UserRolesEntity> entities);

	/**
	 * 批量新增或按主键更新数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<UserRolesEntity> 实例对象列表
	 * @return 影响行数
	 * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
	 */
	int insertOrUpdateBatch(@Param("entities") List<UserRolesEntity> entities);

	/**
	 * 修改数据
	 *
	 * @param userRoles 实例对象
	 * @return 影响行数
	 */
	int update(UserRolesEntity userRoles);

	/**
	 * 通过主键删除数据
	 *
	 * @param userId 主键
	 * @return 影响行数
	 */
	int deleteById(Long userId);

}

