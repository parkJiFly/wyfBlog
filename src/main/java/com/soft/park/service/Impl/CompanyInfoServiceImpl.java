package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.CompanyInfoDTO;
import com.soft.park.entity.CompanyInfoEntity;
import com.soft.park.mapper.CompanyInfoMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.ICompanyInfoService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.CompanyInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 18:15:16
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
		CompanyInfoEntity companyInfoEntity = this.getById(id);
		return BeanUtil.copy(companyInfoEntity, CompanyInfoDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param companyInfoVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<CompanyInfoDTO> queryByPage(CompanyInfoVO companyInfoVO) {
		Page<CompanyInfoEntity> Page = new Page<>(companyInfoVO.getPageNo(), companyInfoVO.getPageSize());
		Page<CompanyInfoEntity> entityPage = this.page(Page);

		ResultPage<CompanyInfoDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, CompanyInfoDTO.class);
		return resultPage;
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
		super.saveOrUpdate(companyInfoEntity);
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
		super.saveOrUpdate(companyInfoEntity);
		return BeanUtil.copy(companyInfoEntity, CompanyInfoDTO.class);
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
