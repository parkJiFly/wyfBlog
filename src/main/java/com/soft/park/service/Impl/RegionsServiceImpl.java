package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.RegionsDTO;
import com.soft.park.entity.RegionsEntity;
import com.soft.park.mapper.RegionsMapper;
import com.soft.park.service.IRegionsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.TreeUtils;
import com.soft.park.vo.RegionsVO;
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
 * @date 2024-06-11 17:00:33
 * @description 区域表(Regions)表服务实现类
 */
@Service
@Slf4j
public class RegionsServiceImpl extends ServiceImpl<RegionsMapper, RegionsEntity> implements IRegionsService {

	@Autowired
	private RegionsMapper regionsMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public RegionsDTO queryById(String id) {
		RegionsEntity regionsEntity = this.regionsMapper.queryById(id);
		return BeanUtil.copy(regionsEntity, RegionsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param regionsVO   筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<RegionsDTO> queryByPage(RegionsVO regionsVO, PageRequest pageRequest) {
		long total = this.regionsMapper.count(regionsVO);
		List<RegionsEntity> regionsEntityS = this.regionsMapper.queryAllByLimit(regionsVO, pageRequest);
		List<RegionsDTO> regionsDTOS = BeanUtil.copyToList(regionsEntityS, RegionsDTO.class);
		return new PageImpl<>(regionsDTOS, pageRequest, total);
	}

	/**
	 * 新增数据
	 *
	 * @param regionsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public RegionsDTO insert(RegionsVO regionsVO) {
		RegionsEntity regionsEntity = BeanUtil.copy(regionsVO, RegionsEntity.class);
		this.regionsMapper.insert(regionsEntity);
		return BeanUtil.copy(regionsEntity, RegionsDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param regionsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public RegionsDTO update(RegionsVO regionsVO) {
		RegionsEntity regionsEntity = BeanUtil.copy(regionsVO, RegionsEntity.class);
		this.regionsMapper.update(regionsEntity);
		return this.queryById(regionsVO.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(String id) {
		return this.regionsMapper.deleteById(id) > 0;
	}

	/**
	 * 省市区树查询
	 * @param regionsVO
	 * @return
	 */
	@Override
	public List<RegionsDTO> queryList(RegionsVO regionsVO) {
		List<RegionsEntity> list = this.list();
		List<RegionsDTO> regionsDTOS = BeanUtil.copyToList(list, RegionsDTO.class);
		List<RegionsDTO> dtos = TreeUtils.buildTree(regionsDTOS);
		return dtos;
	}

}
