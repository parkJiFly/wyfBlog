package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.RolesDTO;
import com.soft.park.entity.RolesEntity;
import com.soft.park.mapper.RolesMapper;
import com.soft.park.service.IRolesService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.RolesVO;
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
 * @date 2024-06-14 17:40:42
 * @description 角色表(Roles)表服务实现类
 */
@Service
@Slf4j
public class RolesServiceImpl extends ServiceImpl<RolesMapper, RolesEntity> implements IRolesService {

	@Autowired
	private RolesMapper rolesMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public RolesDTO queryById(Long id) {
		RolesEntity rolesEntity = this.rolesMapper.queryById(id);
		return BeanUtil.copy(rolesEntity, RolesDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param rolesVO     筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<RolesDTO> queryByPage(RolesVO rolesVO, PageRequest pageRequest) {
		long total = this.rolesMapper.count(rolesVO);
		List<RolesEntity> rolesEntityS = this.rolesMapper.queryAllByLimit(rolesVO, pageRequest);
		List<RolesDTO> rolesDTOS = BeanUtil.copyToList(rolesEntityS, RolesDTO.class);
		return new PageImpl<>(rolesDTOS, pageRequest, total);
	}

	/**
	 * 新增数据
	 *
	 * @param rolesVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public RolesDTO insert(RolesVO rolesVO) {
		RolesEntity rolesEntity = BeanUtil.copy(rolesVO, RolesEntity.class);
		this.rolesMapper.insert(rolesEntity);
		return BeanUtil.copy(rolesEntity, RolesDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param rolesVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public RolesDTO update(RolesVO rolesVO) {
		RolesEntity rolesEntity = BeanUtil.copy(rolesVO, RolesEntity.class);
		this.rolesMapper.update(rolesEntity);
		return this.queryById(rolesVO.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.rolesMapper.deleteById(id) > 0;
	}

}
