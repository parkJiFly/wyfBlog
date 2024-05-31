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
 * @date 2024/5/31 9:57
 * @description
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class LoginController {

	@Resource
	private IUserService iUserService;

	/**
	 * 登录
	 * @param userVO
	 * @return
	 */
	@PostMapping("/login")
	public Result<UserDTO> login(@RequestBody UserVO userVO){
		return Result.success(iUserService.login(userVO));
	}
}
