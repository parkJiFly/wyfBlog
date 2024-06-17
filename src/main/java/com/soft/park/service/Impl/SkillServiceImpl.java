package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.SkillDTO;
import com.soft.park.entity.SkillEntity;
import com.soft.park.mapper.SkillMapper;
import com.soft.park.service.ISkillService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.SkillVO;
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
 * @date 2024-06-17 19:40:20
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
		SkillEntity skillEntity = this.skillMapper.queryById(id);
		return BeanUtil.copy(skillEntity, SkillDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param skillVO     筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<SkillDTO> queryByPage(SkillVO skillVO, PageRequest pageRequest) {
		long total = this.skillMapper.count(skillVO);
		List<SkillEntity> skillEntityS = this.skillMapper.queryAllByLimit(skillVO, pageRequest);
		List<SkillDTO> skillDTOS = BeanUtil.copyToList(skillEntityS, SkillDTO.class);
		return new PageImpl<>(skillDTOS, pageRequest, total);
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
		this.skillMapper.insert(skillEntity);
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
		this.skillMapper.update(skillEntity);
		return this.queryById(skillVO.getId());
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
