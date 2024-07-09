package com.soft.park.controller;

import com.soft.park.service.IOrderByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-07-09 14:16:03
 * @description 到期表(OrderBy)控制层
 */
@RestController
@RequestMapping("/orderBy")
public class OrderByController {
    /**
     * 服务对象
     */
    @Autowired
    private IOrderByService iOrderByService;


}

