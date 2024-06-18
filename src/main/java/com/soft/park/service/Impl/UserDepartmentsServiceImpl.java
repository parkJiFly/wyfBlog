package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.UserDepartmentsDTO;
import com.soft.park.entity.UserDepartmentsEntity;
import com.soft.park.mapper.UserDepartmentsMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IUserDepartmentsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.UserDepartmentsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
 * @description 用户部门关联表(UserDepartments)表服务实现类
 */
@Service
@Slf4j
public class UserDepartmentsServiceImpl extends ServiceImpl<UserDepartmentsMapper, UserDepartmentsEntity> implements IUserDepartmentsService {

	@Autowired
	private UserDepartmentsMapper userDepartmentsMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param userId 主键
	 * @return 实例对象
	 */
	@Override
	public UserDepartmentsDTO queryById(Long userId) {
		UserDepartmentsEntity userDepartmentsEntity = this.getById(userId);
		return BeanUtil.copy(userDepartmentsEntity, UserDepartmentsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param userDepartmentsVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<UserDepartmentsDTO> queryByPage(UserDepartmentsVO userDepartmentsVO) {
		Page<UserDepartmentsEntity> Page = new Page<>(userDepartmentsVO.getPageNo(), userDepartmentsVO.getPageSize());
		Page<UserDepartmentsEntity> entityPage = this.page(Page);

		ResultPage<UserDepartmentsDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, UserDepartmentsDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param userDepartmentsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public UserDepartmentsDTO insert(UserDepartmentsVO userDepartmentsVO) {
		UserDepartmentsEntity userDepartmentsEntity = BeanUtil.copy(userDepartmentsVO, UserDepartmentsEntity.class);
		super.saveOrUpdate(userDepartmentsEntity);
		return BeanUtil.copy(userDepartmentsEntity, UserDepartmentsDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param userDepartmentsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public UserDepartmentsDTO update(UserDepartmentsVO userDepartmentsVO) {
		UserDepartmentsEntity userDepartmentsEntity = BeanUtil.copy(userDepartmentsVO, UserDepartmentsEntity.class);
		super.saveOrUpdate(userDepartmentsEntity);
		return BeanUtil.copy(userDepartmentsEntity, UserDepartmentsDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param userId 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long userId) {
		return this.userDepartmentsMapper.deleteById(userId) > 0;
	}

}
