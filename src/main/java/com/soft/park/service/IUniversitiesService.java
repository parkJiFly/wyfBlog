package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.UniversitiesDTO;
import com.soft.park.entity.UniversitiesEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.UniversitiesVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:30
 * @description 大学表(Universities)表服务接口
 */
public interface IUniversitiesService extends IService<UniversitiesEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	UniversitiesDTO queryById(Integer id);

	/**
	 * 分页查询
	 *
	 * @param universitiesVO 筛选条件
	 * @return 查询结果
	 */
	ResultPage<UniversitiesDTO> queryByPage(UniversitiesVO universitiesVO);

	/**
	 * 新增数据
	 *
	 * @param universitiesVO 实例对象
	 * @return 实例对象
	 */
	UniversitiesDTO insert(UniversitiesVO universitiesVO);

	/**
	 * 修改数据
	 *
	 * @param universitiesVO 实例对象
	 * @return 实例对象
	 */
	UniversitiesDTO update(UniversitiesVO universitiesVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Integer id);

}
