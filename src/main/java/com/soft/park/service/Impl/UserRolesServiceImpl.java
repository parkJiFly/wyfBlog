package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.UserRolesDTO;
import com.soft.park.entity.UserRolesEntity;
import com.soft.park.mapper.UserRolesMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IUserRolesService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.UserRolesVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:17
 * @description 用户角色关联表(UserRoles)表服务实现类
 */
@Service
@Slf4j
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRolesEntity> implements IUserRolesService {

	@Autowired
	private UserRolesMapper userRolesMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param userId 主键
	 * @return 实例对象
	 */
	@Override
	public UserRolesDTO queryById(Long userId) {
		UserRolesEntity userRolesEntity = this.getById(userId);
		return BeanUtil.copy(userRolesEntity, UserRolesDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param userRolesVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<UserRolesDTO> queryByPage(UserRolesVO userRolesVO) {
		Page<UserRolesEntity> Page = new Page<>(userRolesVO.getPageNo(), userRolesVO.getPageSize());
		Page<UserRolesEntity> entityPage = this.page(Page);

		ResultPage<UserRolesDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, UserRolesDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param userRolesVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public UserRolesDTO insert(UserRolesVO userRolesVO) {
		UserRolesEntity userRolesEntity = BeanUtil.copy(userRolesVO, UserRolesEntity.class);
		super.saveOrUpdate(userRolesEntity);
		return BeanUtil.copy(userRolesEntity, UserRolesDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param userRolesVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public UserRolesDTO update(UserRolesVO userRolesVO) {
		UserRolesEntity userRolesEntity = BeanUtil.copy(userRolesVO, UserRolesEntity.class);
		super.saveOrUpdate(userRolesEntity);
		return BeanUtil.copy(userRolesEntity, UserRolesDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param userId 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long userId) {
		return this.userRolesMapper.deleteById(userId) > 0;
	}

}
