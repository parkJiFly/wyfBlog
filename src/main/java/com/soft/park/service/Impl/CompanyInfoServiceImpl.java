package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.CompanyInfoDTO;
import com.soft.park.entity.CompanyInfoEntity;
import com.soft.park.mapper.CompanyInfoMapper;
import com.soft.park.service.ICompanyInfoService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.CompanyInfoVO;
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
 * @date 2024-06-17 19:40:12
 * @description 公司信息表(CompanyInfo)表服务实现类
 */
@Service
@Slf4j
public class CompanyInfoServiceImpl extends ServiceImpl<CompanyInfoMapper, CompanyInfoEntity> implements ICompanyInfoService {

	@Autowired
	private CompanyInfoMapper companyInfoMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public CompanyInfoDTO queryById(Long id) {
		CompanyInfoEntity companyInfoEntity = this.companyInfoMapper.queryById(id);
		return BeanUtil.copy(companyInfoEntity, CompanyInfoDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param companyInfoVO 筛选条件
	 * @param pageRequest   分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<CompanyInfoDTO> queryByPage(CompanyInfoVO companyInfoVO, PageRequest pageRequest) {
		long total = this.companyInfoMapper.count(companyInfoVO);
		List<CompanyInfoEntity> companyInfoEntityS = this.companyInfoMapper.queryAllByLimit(companyInfoVO, pageRequest);
		List<CompanyInfoDTO> companyInfoDTOS = BeanUtil.copyToList(companyInfoEntityS, CompanyInfoDTO.class);
		return new PageImpl<>(companyInfoDTOS, pageRequest, total);
	}

	/**
	 * 新增数据
	 *
	 * @param companyInfoVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public CompanyInfoDTO insert(CompanyInfoVO companyInfoVO) {
		CompanyInfoEntity companyInfoEntity = BeanUtil.copy(companyInfoVO, CompanyInfoEntity.class);
		this.companyInfoMapper.insert(companyInfoEntity);
		return BeanUtil.copy(companyInfoEntity, CompanyInfoDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param companyInfoVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public CompanyInfoDTO update(CompanyInfoVO companyInfoVO) {
		CompanyInfoEntity companyInfoEntity = BeanUtil.copy(companyInfoVO, CompanyInfoEntity.class);
		this.companyInfoMapper.update(companyInfoEntity);
		return this.queryById(companyInfoVO.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.companyInfoMapper.deleteById(id) > 0;
	}

}
