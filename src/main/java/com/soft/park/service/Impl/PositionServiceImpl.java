package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.PositionDTO;
import com.soft.park.entity.PositionEntity;
import com.soft.park.mapper.PositionMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IPositionService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.PositionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
 * @description 岗位表(Position)表服务实现类
 */
@Service
@Slf4j
public class PositionServiceImpl extends ServiceImpl<PositionMapper, PositionEntity> implements IPositionService {

	@Autowired
	private PositionMapper positionMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public PositionDTO queryById(Long id) {
		PositionEntity positionEntity = this.getById(id);
		return BeanUtil.copy(positionEntity, PositionDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param positionVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<PositionDTO> queryByPage(PositionVO positionVO) {
		Page<PositionEntity> Page = new Page<>(positionVO.getPageNo(), positionVO.getPageSize());
		Page<PositionEntity> entityPage = this.page(Page);

		ResultPage<PositionDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, PositionDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param positionVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public PositionDTO insert(PositionVO positionVO) {
		PositionEntity positionEntity = BeanUtil.copy(positionVO, PositionEntity.class);
		super.saveOrUpdate(positionEntity);
		return BeanUtil.copy(positionEntity, PositionDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param positionVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public PositionDTO update(PositionVO positionVO) {
		PositionEntity positionEntity = BeanUtil.copy(positionVO, PositionEntity.class);
		super.saveOrUpdate(positionEntity);
		return BeanUtil.copy(positionEntity, PositionDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.positionMapper.deleteById(id) > 0;
	}

}
