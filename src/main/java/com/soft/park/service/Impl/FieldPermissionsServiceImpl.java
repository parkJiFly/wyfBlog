package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.FieldPermissionsDTO;
import com.soft.park.entity.FieldPermissionsEntity;
import com.soft.park.mapper.FieldPermissionsMapper;
import com.soft.park.service.IFieldPermissionsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.FieldPermissionsVO;
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
 * @date 2024-06-14 17:44:11
 * @description 字段权限表(FieldPermissions)表服务实现类
 */
@Service
@Slf4j
public class FieldPermissionsServiceImpl extends ServiceImpl<FieldPermissionsMapper, FieldPermissionsEntity> implements IFieldPermissionsService {

	@Autowired
	private FieldPermissionsMapper fieldPermissionsMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public FieldPermissionsDTO queryById(Long id) {
		FieldPermissionsEntity fieldPermissionsEntity = this.fieldPermissionsMapper.queryById(id);
		return BeanUtil.copy(fieldPermissionsEntity, FieldPermissionsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param fieldPermissionsVO 筛选条件
	 * @param pageRequest        分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<FieldPermissionsDTO> queryByPage(FieldPermissionsVO fieldPermissionsVO, PageRequest pageRequest) {
		long total = this.fieldPermissionsMapper.count(fieldPermissionsVO);
		List<FieldPermissionsEntity> fieldPermissionsEntityS = this.fieldPermissionsMapper.queryAllByLimit(fieldPermissionsVO, pageRequest);
		List<FieldPermissionsDTO> fieldPermissionsDTOS = BeanUtil.copyToList(fieldPermissionsEntityS, FieldPermissionsDTO.class);
		return new PageImpl<>(fieldPermissionsDTOS, pageRequest, total);
	}

	/**
	 * 新增数据
	 *
	 * @param fieldPermissionsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public FieldPermissionsDTO insert(FieldPermissionsVO fieldPermissionsVO) {
		FieldPermissionsEntity fieldPermissionsEntity = BeanUtil.copy(fieldPermissionsVO, FieldPermissionsEntity.class);
		this.fieldPermissionsMapper.insert(fieldPermissionsEntity);
		return BeanUtil.copy(fieldPermissionsEntity, FieldPermissionsDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param fieldPermissionsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public FieldPermissionsDTO update(FieldPermissionsVO fieldPermissionsVO) {
		FieldPermissionsEntity fieldPermissionsEntity = BeanUtil.copy(fieldPermissionsVO, FieldPermissionsEntity.class);
		this.fieldPermissionsMapper.update(fieldPermissionsEntity);
		return this.queryById(fieldPermissionsVO.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.fieldPermissionsMapper.deleteById(id) > 0;
	}

}
