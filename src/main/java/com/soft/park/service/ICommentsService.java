package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.CommentsDTO;
import com.soft.park.entity.CommentsEntity;
import com.soft.park.result.ResultPage;
import com.soft.park.vo.CommentsVO;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-25 18:11:59
 * @description 评论表(Comments)表服务接口
 */
public interface ICommentsService extends IService<CommentsEntity> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	CommentsDTO queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param commentsVO 筛选条件
	 * @return 查询结果
	 */
	ResultPage<CommentsDTO> queryByPage(CommentsVO commentsVO);

	/**
	 * 新增数据
	 *
	 * @param commentsVO 实例对象
	 * @return 实例对象
	 */
	CommentsDTO insert(CommentsVO commentsVO);

	/**
	 * 修改数据
	 *
	 * @param commentsVO 实例对象
	 * @return 实例对象
	 */
	CommentsDTO update(CommentsVO commentsVO);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

}
