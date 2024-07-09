package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.entity.OrderByEntity;
import com.soft.park.mapper.OrderByMapper;
import com.soft.park.service.IOrderByService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-07-09 14:16:04
 * @description 到期表(OrderBy)表服务实现类
 */
@Service
@Slf4j
public class OrderByServiceImpl extends ServiceImpl<OrderByMapper, OrderByEntity> implements IOrderByService {
    @Autowired
    private OrderByMapper orderByMapper;

}
