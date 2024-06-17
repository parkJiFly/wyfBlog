package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.CompanyInfoDTO;
import com.soft.park.entity.CompanyInfoEntity;
import com.soft.park.vo.CompanyInfoVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:12
 * @description 公司信息表(CompanyInfo)表服务接口
 */
public interface ICompanyInfoService extends IService<CompanyInfoEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	CompanyInfoDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param companyInfoVO 筛选条件
	 * @param pageRequest   分页对象
	 * @return 查询结果
	 */
	Page<CompanyInfoDTO> queryByPage(CompanyInfoVO companyInfoVO, PageRequest pageRequest);

	/**
	 * 新增数据
	 *
	 * @param companyInfoVO 实例对象
	 * @return 实例对象
	 */
	CompanyInfoDTO insert(CompanyInfoVO companyInfoVO);

	/**
	 * 修改数据
	 *
	 * @param companyInfoVO 实例对象
	 * @return 实例对象
	 */
	CompanyInfoDTO update(CompanyInfoVO companyInfoVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
