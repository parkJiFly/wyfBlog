package com.soft.park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.park.entity.CompanyInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:12
 * @description 公司信息表(CompanyInfo)mapper层
 */
@Mapper
public interface CompanyInfoMapper extends BaseMapper<CompanyInfoEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	CompanyInfoEntity queryById(Long id);

	/**
	 * 查询指定行数据
	 *
	 * @param companyInfo 查询条件
	 * @param pageable    分页对象
	 * @return 对象列表
	 */
	List<CompanyInfoEntity> queryAllByLimit(CompanyInfoEntity companyInfo, @Param("pageable") Pageable pageable);

	/**
	 * 统计总行数
	 *
	 * @param companyInfo 查询条件
	 * @return 总行数
	 */
	long count(CompanyInfoEntity companyInfo);

	/**
	 * 新增数据
	 *
	 * @param companyInfo 实例对象
	 * @return 影响行数
	 */
	int insert(CompanyInfoEntity companyInfo);

	/**
	 * 批量新增数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<CompanyInfoEntity> 实例对象列表
	 * @return 影响行数
	 */
	int insertBatch(@Param("entities") List<CompanyInfoEntity> entities);

	/**
	 * 批量新增或按主键更新数据（MyBatis原生foreach方法）
	 *
	 * @param entities List<CompanyInfoEntity> 实例对象列表
	 * @return 影响行数
	 * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
	 */
	int insertOrUpdateBatch(@Param("entities") List<CompanyInfoEntity> entities);

	/**
	 * 修改数据
	 *
	 * @param companyInfo 实例对象
	 * @return 影响行数
	 */
	int update(CompanyInfoEntity companyInfo);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 影响行数
	 */
	int deleteById(Long id);

}

