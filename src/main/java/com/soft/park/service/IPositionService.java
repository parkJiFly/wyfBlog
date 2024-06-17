package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.PositionDTO;
import com.soft.park.entity.PositionEntity;
import com.soft.park.vo.PositionVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:14
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
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	Page<PositionDTO> queryByPage(PositionVO positionVO, PageRequest pageRequest);

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
