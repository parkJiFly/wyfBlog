package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.PositionDTO;
import com.soft.park.entity.PositionEntity;
import com.soft.park.mapper.PositionMapper;
import com.soft.park.service.IPositionService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.PositionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:14
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
		PositionEntity positionEntity = this.positionMapper.queryById(id);
		return BeanUtil.copy(positionEntity, PositionDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param positionVO  筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<PositionDTO> queryByPage(PositionVO positionVO, PageRequest pageRequest) {
		long total = this.positionMapper.count(positionVO);
		List<PositionEntity> positionEntityS = this.positionMapper.queryAllByLimit(positionVO, pageRequest);
		List<PositionDTO> positionDTOS = BeanUtil.copyToList(positionEntityS, PositionDTO.class);
		return new PageImpl<>(positionDTOS, pageRequest, total);
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
		this.positionMapper.insert(positionEntity);
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
		this.positionMapper.update(positionEntity);
		return this.queryById(positionVO.getId());
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
