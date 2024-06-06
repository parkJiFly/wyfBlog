package com.soft.park.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import com.soft.park.dto.UserDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IUserService;
import com.soft.park.utils.RedisUtils;
import com.soft.park.utils.SaltMD5Utils;
import com.soft.park.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/5/31 9:57
 * @description
 */
@RestController
@AllArgsConstructor
@Tag(name = "登录部分", description = "登录操作等")
@RequestMapping("/login")
public class LoginController {

	@Resource
	private IUserService iUserService;

	/**
	 * 登录
	 * @return
	 */
	@PostMapping("/login")
	@Operation(summary = "登录操作")
	public Result<UserDTO> login(UserVO userVO) {
		return Result.success(iUserService.login(userVO));

	}

	/**
	 * 登出
	 * @return
	 */
	@GetMapping("/log-out")
	@Operation(summary = "登录操作")
	public Result logout() {
		if(StpUtil.isLogin()){
			StpUtil.logout();
		}
		return Result.success();
	}

	/**
	 * 登出
	 * @return
	 */
	@GetMapping("/get-verification")
	@Operation(summary = "获取验证码")
	public Result getVerification(HttpServletRequest request) throws IOException {
		// 随机4位数字，可重复
		RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
		GifCaptcha captcha = CaptchaUtil.createGifCaptcha(200, 100);
		captcha.setGenerator(randomGenerator);
		// 重新生成code
		captcha.createCode();
		//存放redis以供登录做校验
		String code = captcha.getCode();
		String remoteAddr;
		if (request.getHeader("x-forwarded-for") == null) {
			remoteAddr = request.getRemoteAddr();
		}else {
			remoteAddr = request.getHeader("x-forwarded-for");
		}
		String s = SaltMD5Utils.MD5(remoteAddr);
		String key = RedisUtils.get().keyBuilder("verification", s);
		RedisUtils.get().delete(key);
		RedisUtils.get().set(key,code);

		// 将GIF写入ByteArrayOutputStream
		ByteArrayOutputStream gifOutputStream = new ByteArrayOutputStream();
		captcha.write(gifOutputStream);
		String base64Gif = Base64.getEncoder().encodeToString(gifOutputStream.toByteArray());

		// 创建返回结果
		Map<String, String> result = new HashMap<>();
		result.put("value", s);
		result.put("captcha", base64Gif);
		return Result.success(result);
	}



}
