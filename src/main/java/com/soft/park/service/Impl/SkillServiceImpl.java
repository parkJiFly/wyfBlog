package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.SkillDTO;
import com.soft.park.entity.SkillEntity;
import com.soft.park.mapper.SkillMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.ISkillService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.SkillVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
 * @description 技术能力情况表(Skill)表服务实现类
 */
@Service
@Slf4j
public class SkillServiceImpl extends ServiceImpl<SkillMapper, SkillEntity> implements ISkillService {

	@Autowired
	private SkillMapper skillMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public SkillDTO queryById(Long id) {
		SkillEntity skillEntity = this.getById(id);
		return BeanUtil.copy(skillEntity, SkillDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param skillVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<SkillDTO> queryByPage(SkillVO skillVO) {
		Page<SkillEntity> Page = new Page<>(skillVO.getPageNo(), skillVO.getPageSize());
		Page<SkillEntity> entityPage = this.page(Page);

		ResultPage<SkillDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, SkillDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param skillVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public SkillDTO insert(SkillVO skillVO) {
		SkillEntity skillEntity = BeanUtil.copy(skillVO, SkillEntity.class);
		super.saveOrUpdate(skillEntity);
		return BeanUtil.copy(skillEntity, SkillDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param skillVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public SkillDTO update(SkillVO skillVO) {
		SkillEntity skillEntity = BeanUtil.copy(skillVO, SkillEntity.class);
		super.saveOrUpdate(skillEntity);
		return BeanUtil.copy(skillEntity, SkillDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.skillMapper.deleteById(id) > 0;
	}

}
