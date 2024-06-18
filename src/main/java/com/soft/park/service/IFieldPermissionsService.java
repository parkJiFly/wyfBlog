package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.FieldPermissionsDTO;
import com.soft.park.entity.FieldPermissionsEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.FieldPermissionsVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:20
 * @description 字段权限表(FieldPermissions)表服务接口
 */
public interface IFieldPermissionsService extends IService<FieldPermissionsEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	FieldPermissionsDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param fieldPermissionsVO 筛选条件
	 * @return 查询结果
	 */
	ResultPage<FieldPermissionsDTO> queryByPage(FieldPermissionsVO fieldPermissionsVO);

	/**
	 * 新增数据
	 *
	 * @param fieldPermissionsVO 实例对象
	 * @return 实例对象
	 */
	FieldPermissionsDTO insert(FieldPermissionsVO fieldPermissionsVO);

	/**
	 * 修改数据
	 *
	 * @param fieldPermissionsVO 实例对象
	 * @return 实例对象
	 */
	FieldPermissionsDTO update(FieldPermissionsVO fieldPermissionsVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
