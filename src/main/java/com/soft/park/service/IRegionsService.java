package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.RegionsDTO;
import com.soft.park.entity.RegionsEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.RegionsVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:24
 * @description 区域表(Regions)表服务接口
 */
public interface IRegionsService extends IService<RegionsEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	RegionsDTO queryById(String id);

	/**
	 * 分页查询
	 *
	 * @param regionsVO   筛选条件
	 * @return 查询结果
	 */
	ResultPage<RegionsDTO> queryByPage(RegionsVO regionsVO);

	/**
	 * 新增数据
	 *
	 * @param regionsVO 实例对象
	 * @return 实例对象
	 */
	RegionsDTO insert(RegionsVO regionsVO);

	/**
	 * 修改数据
	 *
	 * @param regionsVO 实例对象
	 * @return 实例对象
	 */
	RegionsDTO update(RegionsVO regionsVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(String id);

}
