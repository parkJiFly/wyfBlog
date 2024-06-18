package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.UniversitiesDTO;
import com.soft.park.entity.UniversitiesEntity;
import com.soft.park.mapper.UniversitiesMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IUniversitiesService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.UniversitiesVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
 * @description 大学表(Universities)表服务实现类
 */
@Service
@Slf4j
public class UniversitiesServiceImpl extends ServiceImpl<UniversitiesMapper, UniversitiesEntity> implements IUniversitiesService {

	@Autowired
	private UniversitiesMapper universitiesMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public UniversitiesDTO queryById(Integer id) {
		UniversitiesEntity universitiesEntity = this.getById(id);
		return BeanUtil.copy(universitiesEntity, UniversitiesDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param universitiesVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<UniversitiesDTO> queryByPage(UniversitiesVO universitiesVO) {
		Page<UniversitiesEntity> Page = new Page<>(universitiesVO.getPageNo(), universitiesVO.getPageSize());
		Page<UniversitiesEntity> entityPage = this.page(Page);

		ResultPage<UniversitiesDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, UniversitiesDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param universitiesVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public UniversitiesDTO insert(UniversitiesVO universitiesVO) {
		UniversitiesEntity universitiesEntity = BeanUtil.copy(universitiesVO, UniversitiesEntity.class);
		super.saveOrUpdate(universitiesEntity);
		return BeanUtil.copy(universitiesEntity, UniversitiesDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param universitiesVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public UniversitiesDTO update(UniversitiesVO universitiesVO) {
		UniversitiesEntity universitiesEntity = BeanUtil.copy(universitiesVO, UniversitiesEntity.class);
		super.saveOrUpdate(universitiesEntity);
		return BeanUtil.copy(universitiesEntity, UniversitiesDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Integer id) {
		return this.universitiesMapper.deleteById(id) > 0;
	}

}
