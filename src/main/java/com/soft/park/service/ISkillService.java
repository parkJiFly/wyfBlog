package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.SkillDTO;
import com.soft.park.entity.SkillEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.SkillVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-18 17:42:30
 * @description 技术能力情况表(Skill)表服务接口
 */
public interface ISkillService extends IService<SkillEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	SkillDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param skillVO     筛选条件
	 * @return 查询结果
	 */
	ResultPage<SkillDTO> queryByPage(SkillVO skillVO);

	/**
	 * 新增数据
	 *
	 * @param skillVO 实例对象
	 * @return 实例对象
	 */
	SkillDTO insert(SkillVO skillVO);

	/**
	 * 修改数据
	 *
	 * @param skillVO 实例对象
	 * @return 实例对象
	 */
	SkillDTO update(SkillVO skillVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
