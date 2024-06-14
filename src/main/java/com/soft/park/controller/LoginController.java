package com.soft.park.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import com.soft.park.config.ValidGroup;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/5/31 9:57
 * @description
 */
@RestController
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
	public Result<UserDTO> login(@Validated({ValidGroup.Login.class}) @RequestBody UserVO userVO) {
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
		//设置过期时间为一分钟
		// 获取当前时间
		Date currentDate = new Date();

		// 创建一个 Calendar 实例并设置为当前时间
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);

		// 增加20分钟
		calendar.add(Calendar.MINUTE, 20);

		// 获取增加一分钟后的 Date 对象
		Date dateAfterOneMinute = calendar.getTime();
		RedisUtils.get().expireAt(key,dateAfterOneMinute);

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
