package com.soft.park.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.park.entity.OrderByEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-07-09 14:16:04
 * @description 到期表(OrderBy)mapper层
 */
@Mapper
public interface OrderByMapper extends BaseMapper<OrderByEntity> {

}

