package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.ProfessionDTO;
import com.soft.park.entity.ProfessionEntity;
import com.soft.park.mapper.ProfessionMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IProfessionService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.ProfessionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
 * @description 专业表(Profession)表服务实现类
 */
@Service
@Slf4j
public class ProfessionServiceImpl extends ServiceImpl<ProfessionMapper, ProfessionEntity> implements IProfessionService {

	@Autowired
	private ProfessionMapper professionMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public ProfessionDTO queryById(Long id) {
		ProfessionEntity professionEntity = this.getById(id);
		return BeanUtil.copy(professionEntity, ProfessionDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param professionVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<ProfessionDTO> queryByPage(ProfessionVO professionVO) {
		Page<ProfessionEntity> Page = new Page<>(professionVO.getPageNo(), professionVO.getPageSize());
		Page<ProfessionEntity> entityPage = this.page(Page);

		ResultPage<ProfessionDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, ProfessionDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param professionVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public ProfessionDTO insert(ProfessionVO professionVO) {
		ProfessionEntity professionEntity = BeanUtil.copy(professionVO, ProfessionEntity.class);
		super.saveOrUpdate(professionEntity);
		return BeanUtil.copy(professionEntity, ProfessionDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param professionVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public ProfessionDTO update(ProfessionVO professionVO) {
		ProfessionEntity professionEntity = BeanUtil.copy(professionVO, ProfessionEntity.class);
		super.saveOrUpdate(professionEntity);
		return BeanUtil.copy(professionEntity, ProfessionDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.professionMapper.deleteById(id) > 0;
	}

}
