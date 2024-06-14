package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.DepartmentsDTO;
import com.soft.park.entity.DepartmentsEntity;
import com.soft.park.mapper.DepartmentsMapper;
import com.soft.park.service.IDepartmentsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.DepartmentsVO;
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
 * @date 2024-06-14 17:41:47
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
		DepartmentsEntity departmentsEntity = this.departmentsMapper.queryById(id);
		return BeanUtil.copy(departmentsEntity, DepartmentsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param departmentsVO 筛选条件
	 * @param pageRequest   分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<DepartmentsDTO> queryByPage(DepartmentsVO departmentsVO, PageRequest pageRequest) {
		long total = this.departmentsMapper.count(departmentsVO);
		List<DepartmentsEntity> departmentsEntityS = this.departmentsMapper.queryAllByLimit(departmentsVO, pageRequest);
		List<DepartmentsDTO> departmentsDTOS = BeanUtil.copyToList(departmentsEntityS, DepartmentsDTO.class);
		return new PageImpl<>(departmentsDTOS, pageRequest, total);
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
		this.departmentsMapper.insert(departmentsEntity);
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
		this.departmentsMapper.update(departmentsEntity);
		return this.queryById(departmentsVO.getId());
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
