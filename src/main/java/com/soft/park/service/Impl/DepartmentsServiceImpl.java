package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.DepartmentsDTO;
import com.soft.park.entity.DepartmentsEntity;
import com.soft.park.mapper.DepartmentsMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.IDepartmentsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.DepartmentsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
 * @description 部门表(Departments)表服务实现类
 */
@Service
@Slf4j
public class DepartmentsServiceImpl extends ServiceImpl<DepartmentsMapper, DepartmentsEntity> implements IDepartmentsService {

	@Autowired
	private DepartmentsMapper departmentsMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public DepartmentsDTO queryById(Long id) {
		DepartmentsEntity departmentsEntity = this.getById(id);
		return BeanUtil.copy(departmentsEntity, DepartmentsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param departmentsVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<DepartmentsDTO> queryByPage(DepartmentsVO departmentsVO) {
		Page<DepartmentsEntity> Page = new Page<>(departmentsVO.getPageNo(), departmentsVO.getPageSize());
		Page<DepartmentsEntity> entityPage = this.page(Page);

		ResultPage<DepartmentsDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, DepartmentsDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param departmentsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public DepartmentsDTO insert(DepartmentsVO departmentsVO) {
		DepartmentsEntity departmentsEntity = BeanUtil.copy(departmentsVO, DepartmentsEntity.class);
		super.saveOrUpdate(departmentsEntity);
		return BeanUtil.copy(departmentsEntity, DepartmentsDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param departmentsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public DepartmentsDTO update(DepartmentsVO departmentsVO) {
		DepartmentsEntity departmentsEntity = BeanUtil.copy(departmentsVO, DepartmentsEntity.class);
		super.saveOrUpdate(departmentsEntity);
		return BeanUtil.copy(departmentsEntity, DepartmentsDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.departmentsMapper.deleteById(id) > 0;
	}

}
