package com.soft.park.controller;

import com.soft.park.dto.UserDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IUserService;
import com.soft.park.vo.UserVO;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/4 15:40
 * @description
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService iUserService;

	@PostMapping("save-update")
	public Result saveOrUpdate(@RequestBody UserVO userVO) {
		UserDTO userDTO = iUserService.addUser(userVO);
		return Result.success(userDTO);
	}

}