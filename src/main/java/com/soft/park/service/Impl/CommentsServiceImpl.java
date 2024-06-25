package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.CommentsDTO;
import com.soft.park.entity.CommentsEntity;
import com.soft.park.mapper.CommentsMapper;
import com.soft.park.result.ResultPage;
import com.soft.park.service.ICommentsService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.utils.ToolUtil;
import com.soft.park.vo.CommentsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-25 18:11:59
 * @description 评论表(Comments)表服务实现类
 */
@Service
@Slf4j
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, CommentsEntity> implements ICommentsService {

	@Autowired
	private CommentsMapper commentsMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public CommentsDTO queryById(Long id) {
		CommentsEntity commentsEntity = this.getById(id);
		return BeanUtil.copy(commentsEntity, CommentsDTO.class);
	}

	/**
	 * 分页查询
	 *
	 * @param commentsVO 筛选条件
	 * @return 查询结果
	 */
	@Override
	public ResultPage<CommentsDTO> queryByPage(CommentsVO commentsVO) {
		Page<CommentsEntity> Page = new Page<>(commentsVO.getPageNo(), commentsVO.getPageSize());
		Page<CommentsEntity> entityPage = this.page(Page);

		ResultPage<CommentsDTO> resultPage = ToolUtil.convertEntityPageToToPage(entityPage, CommentsDTO.class);
		return resultPage;
	}

	/**
	 * 新增数据
	 *
	 * @param commentsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public CommentsDTO insert(CommentsVO commentsVO) {
		CommentsEntity commentsEntity = BeanUtil.copy(commentsVO, CommentsEntity.class);
		super.saveOrUpdate(commentsEntity);
		return BeanUtil.copy(commentsEntity, CommentsDTO.class);
	}

	/**
	 * 修改数据
	 *
	 * @param commentsVO 实例对象
	 * @return 实例对象
	 */
	@Override
	public CommentsDTO update(CommentsVO commentsVO) {
		CommentsEntity commentsEntity = BeanUtil.copy(commentsVO, CommentsEntity.class);
		super.saveOrUpdate(commentsEntity);
		return BeanUtil.copy(commentsEntity, CommentsDTO.class);
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Long id) {
		return this.commentsMapper.deleteById(id) > 0;
	}

}
