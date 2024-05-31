package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.entity.UserEntity;
import com.soft.park.mapper.UserMapper;
import com.soft.park.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/5/31 11:40
 * @description
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements IUserService {

}
