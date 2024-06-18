package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.RegionsDTO;
import com.soft.park.entity.RegionsEntity;
import com.soft.park.mapper.RegionsMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IRegionsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.RegionsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
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
		RegionsEntity regionsEntity = this.getById(id);
		return BeanUtil.copy(regionsEntity, RegionsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param regionsVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<RegionsDTO> queryByPage(RegionsVO regionsVO) {
		Page<RegionsEntity> Page = new Page<>(regionsVO.getPageNo(), regionsVO.getPageSize());
		Page<RegionsEntity> entityPage = this.page(Page);

		ResultPage<RegionsDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, RegionsDTO.class);
		return resultPage;
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
		super.saveOrUpdate(regionsEntity);
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
		super.saveOrUpdate(regionsEntity);
		return BeanUtil.copy(regionsEntity, RegionsDTO.class);
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

}
