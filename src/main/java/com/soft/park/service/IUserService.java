package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.UserDTO;
import com.soft.park.entity.UserEntity;
import com.soft.park.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:22
 * @description (User)表服务接口
 */
public interface IUserService extends IService<UserEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	UserDTO queryById(Object id);

	/**
	 * 分页查询
	 *
	 * @param userVO      筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	Page<UserDTO> queryByPage(UserVO userVO, PageRequest pageRequest);

	/**
	 * 新增数据
	 *
	 * @param userVO 实例对象
	 * @return 实例对象
	 */
	UserDTO insert(UserVO userVO);

	/**
	 * 修改数据
	 *
	 * @param userVO 实例对象
	 * @return 实例对象
	 */
	UserDTO update(UserVO userVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

	/**
	 * 登录
	 * @return
	 */
	UserDTO login(UserVO userVO);


	UserDTO detail(Long id);

}
