package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.MenusDTO;
import com.soft.park.entity.MenusEntity;
import com.soft.park.mapper.MenusMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IMenusService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.MenusVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
 * @description 菜单表(Menus)表服务实现类
 */
@Service
@Slf4j
public class MenusServiceImpl extends ServiceImpl<MenusMapper, MenusEntity> implements IMenusService {

	@Autowired
	private MenusMapper menusMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public MenusDTO queryById(Long id) {
		MenusEntity menusEntity = this.getById(id);
		return BeanUtil.copy(menusEntity, MenusDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param menusVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<MenusDTO> queryByPage(MenusVO menusVO) {
		Page<MenusEntity> Page = new Page<>(menusVO.getPageNo(), menusVO.getPageSize());
		Page<MenusEntity> entityPage = this.page(Page);

		ResultPage<MenusDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, MenusDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param menusVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public MenusDTO insert(MenusVO menusVO) {
		MenusEntity menusEntity = BeanUtil.copy(menusVO, MenusEntity.class);
		super.saveOrUpdate(menusEntity);
		return BeanUtil.copy(menusEntity, MenusDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param menusVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public MenusDTO update(MenusVO menusVO) {
		MenusEntity menusEntity = BeanUtil.copy(menusVO, MenusEntity.class);
		super.saveOrUpdate(menusEntity);
		return BeanUtil.copy(menusEntity, MenusDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.menusMapper.deleteById(id) > 0;
	}

}
