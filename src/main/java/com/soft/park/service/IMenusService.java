package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.MenusDTO;
import com.soft.park.entity.MenusEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.MenusVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:21
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
	 * @return 查询结果
	 */
	ResultPage<MenusDTO> queryByPage(MenusVO menusVO);

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
