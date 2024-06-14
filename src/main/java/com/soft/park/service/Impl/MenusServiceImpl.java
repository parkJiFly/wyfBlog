package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.MenusDTO;
import com.soft.park.entity.MenusEntity;
import com.soft.park.mapper.MenusMapper;
import com.soft.park.service.IMenusService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.MenusVO;
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
 * @date 2024-06-14 17:40:11
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
		MenusEntity menusEntity = this.menusMapper.queryById(id);
		return BeanUtil.copy(menusEntity, MenusDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param menusVO     筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<MenusDTO> queryByPage(MenusVO menusVO, PageRequest pageRequest) {
		long total = this.menusMapper.count(menusVO);
		List<MenusEntity> menusEntityS = this.menusMapper.queryAllByLimit(menusVO, pageRequest);
		List<MenusDTO> menusDTOS = BeanUtil.copyToList(menusEntityS, MenusDTO.class);
		return new PageImpl<>(menusDTOS, pageRequest, total);
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
		this.menusMapper.insert(menusEntity);
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
		this.menusMapper.update(menusEntity);
		return this.queryById(menusVO.getId());
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
