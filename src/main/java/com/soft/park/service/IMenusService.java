package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.MenusDTO;
import com.soft.park.entity.MenusEntity;
import com.soft.park.vo.MenusVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-14 17:40:11
 * @description 菜单表(Menus)表服务接口
 */
public interface IMenusService extends IService<MenusEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	MenusDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param menusVO     筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	Page<MenusDTO> queryByPage(MenusVO menusVO, PageRequest pageRequest);

	/**
	 * 新增数据
	 *
	 * @param menusVO 实例对象
	 * @return 实例对象
	 */
	MenusDTO insert(MenusVO menusVO);

	/**
	 * 修改数据
	 *
	 * @param menusVO 实例对象
	 * @return 实例对象
	 */
	MenusDTO update(MenusVO menusVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
