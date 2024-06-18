package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.RolesDTO;
import com.soft.park.entity.RolesEntity;
import com.soft.park.mapper.RolesMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IRolesService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.RolesVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
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
		RolesEntity rolesEntity = this.getById(id);
		return BeanUtil.copy(rolesEntity, RolesDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param rolesVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<RolesDTO> queryByPage(RolesVO rolesVO) {
		Page<RolesEntity> Page = new Page<>(rolesVO.getPageNo(), rolesVO.getPageSize());
		Page<RolesEntity> entityPage = this.page(Page);

		ResultPage<RolesDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, RolesDTO.class);
		return resultPage;
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
		super.saveOrUpdate(rolesEntity);
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
		super.saveOrUpdate(rolesEntity);
		return BeanUtil.copy(rolesEntity, RolesDTO.class);
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
