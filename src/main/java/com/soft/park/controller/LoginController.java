package com.soft.park.controller;

import com.soft.park.dto.UserDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
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
@Tag(name = "登录部分", description = "登录操作等")
@RequestMapping
public class LoginController {

	@Resource
	private IUserService iUserService;

	/**
	 * 登录
	 *
	 * @param userName
	 * @param password
	 * @param type
	 * @return
	 */
	@PostMapping("/login")
	@Operation(summary = "登录操作")
	public Result<UserDTO> login(String userName, String password, String type) {
		return Result.success(iUserService.login(userName, password, type));

	}

}
