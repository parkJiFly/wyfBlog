package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.PositionDTO;
import com.soft.park.entity.PositionEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.PositionVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:21
 * @description 岗位表(Position)表服务接口
 */
public interface IPositionService extends IService<PositionEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	PositionDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param positionVO  筛选条件
	 * @return 查询结果
	 */
	ResultPage<PositionDTO> queryByPage(PositionVO positionVO);

	/**
	 * 新增数据
	 *
	 * @param positionVO 实例对象
	 * @return 实例对象
	 */
	PositionDTO insert(PositionVO positionVO);

	/**
	 * 修改数据
	 *
	 * @param positionVO 实例对象
	 * @return 实例对象
	 */
	PositionDTO update(PositionVO positionVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
