package com.soft.park.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.dto.CompanyInfoDTO;
import com.soft.park.result.Result;
import com.soft.park.service.ICompanyInfoService;
import com.soft.park.vo.CompanyInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:45:45
 * @description 公司信息表(CompanyInfo)控制层
 */
@RestController
@RequestMapping("/companyInfo")
public class CompanyInfoController {

	/**
	 * 服务对象
	 */
	@Autowired
	private ICompanyInfoService iCompanyInfoService;

	/**
	 * 分页查询
	 *
	 * @param companyInfoVO 筛选条件
	 * @return 查询结果
	 */
	@GetMapping("/list-page")
	public Result<IPage<CompanyInfoDTO>> queryByPage(CompanyInfoVO companyInfoVO) {
		return Result.success(this.iCompanyInfoService.queryByPage(companyInfoVO));
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("/detail")
	public Result queryById(@RequestParam("id") Long id) {
		return Result.success(this.iCompanyInfoService.queryById(id));
	}

	/**
	 * 新增数据
	 *
	 * @param companyInfoVO 实体
	 * @return 新增结果
	 */
	@PostMapping("/add")
	public Result add(@RequestBody CompanyInfoVO companyInfoVO) {
		return Result.success(this.iCompanyInfoService.insert(companyInfoVO));
	}

	/**
	 * 编辑数据
	 *
	 * @param companyInfoVO 实体
	 * @return 编辑结果
	 */
	@PostMapping("/update")
	public Result update(@RequestBody CompanyInfoVO companyInfoVO) {
		return Result.success(this.iCompanyInfoService.update(companyInfoVO));
	}

	/**
	 * 删除数据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	@GetMapping("/delete")
	public Result deleteById(Long id) {
		return Result.success(this.iCompanyInfoService.deleteById(id));
	}

}

