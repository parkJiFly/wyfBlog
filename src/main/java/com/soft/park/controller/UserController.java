package com.soft.park.controller;

import cn.hutool.core.util.ObjectUtil;
import com.soft.park.config.ValidGroup;
import com.soft.park.dto.UserDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IUserService;
import com.soft.park.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/4 15:40
 * @description
 */
@RestController
@AllArgsConstructor
@Tag(name = "用户Controller", description = "有关用户的操作")
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService iUserService;

	/**
	 * 新增用户信息
	 * @param userVO
	 * @return
	 */
	@PostMapping("save-update")
	@Operation(summary = "新增用户")
	public Result saveOrUpdate(@Validated({ValidGroup.SaveOrUpdate.class}) @RequestBody UserVO userVO) {
		UserDTO userDTO = iUserService.addUser(userVO);
		return Result.success(userDTO);
	}

	/**
	 * 根据ID查看用户详情
	 * @param id
	 * @return
	 */
	@GetMapping("/detail")
	@Operation(summary = "查看用户详情")
	public Result detail(@RequestParam("id") Long id){
		UserDTO userDTO = iUserService.detail(id);
		if(ObjectUtil.isNull(userDTO)){
			return Result.error("没有当前用户");
		}
		return Result.success(userDTO);
	}

}
