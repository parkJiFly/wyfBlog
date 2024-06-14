package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.UserDepartmentsDTO;
import com.soft.park.entity.UserDepartmentsEntity;
import com.soft.park.mapper.UserDepartmentsMapper;
import com.soft.park.service.IUserDepartmentsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.UserDepartmentsVO;
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
 * @date 2024-06-14 17:40:43
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
		UserDepartmentsEntity userDepartmentsEntity = this.userDepartmentsMapper.queryById(userId);
		return BeanUtil.copy(userDepartmentsEntity, UserDepartmentsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param userDepartmentsVO 筛选条件
	 * @param pageRequest       分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<UserDepartmentsDTO> queryByPage(UserDepartmentsVO userDepartmentsVO, PageRequest pageRequest) {
		long total = this.userDepartmentsMapper.count(userDepartmentsVO);
		List<UserDepartmentsEntity> userDepartmentsEntityS = this.userDepartmentsMapper.queryAllByLimit(userDepartmentsVO, pageRequest);
		List<UserDepartmentsDTO> userDepartmentsDTOS = BeanUtil.copyToList(userDepartmentsEntityS, UserDepartmentsDTO.class);
		return new PageImpl<>(userDepartmentsDTOS, pageRequest, total);
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
		this.userDepartmentsMapper.insert(userDepartmentsEntity);
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
		this.userDepartmentsMapper.update(userDepartmentsEntity);
		return this.queryById(userDepartmentsVO.getUserId());
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
