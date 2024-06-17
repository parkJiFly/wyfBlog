package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.ProfessionDTO;
import com.soft.park.entity.ProfessionEntity;
import com.soft.park.vo.ProfessionVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-17 19:40:15
 * @description 专业表(Profession)表服务接口
 */
public interface IProfessionService extends IService<ProfessionEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	ProfessionDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param professionVO 筛选条件
	 * @param pageRequest  分页对象
	 * @return 查询结果
	 */
	Page<ProfessionDTO> queryByPage(ProfessionVO professionVO, PageRequest pageRequest);

	/**
	 * 新增数据
	 *
	 * @param professionVO 实例对象
	 * @return 实例对象
	 */
	ProfessionDTO insert(ProfessionVO professionVO);

	/**
	 * 修改数据
	 *
	 * @param professionVO 实例对象
	 * @return 实例对象
	 */
	ProfessionDTO update(ProfessionVO professionVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
