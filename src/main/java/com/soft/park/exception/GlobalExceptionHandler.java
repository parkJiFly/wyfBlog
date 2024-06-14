package com.soft.park.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.soft.park.result.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/5 15:26
 * @description
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 处理自定义的业务异常
	 *
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = CusException.class)
	@ResponseBody
	public Result bizExceptionHandler(HttpServletRequest req, CusException e) {
		log.error("发生业务异常！原因是：{}", e.getErrorMsg());
		return Result.error(e.getErrorCode(), e.getErrorMsg());
	}

	/**
	 * 处理其余业务异常
	 *
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result ExceptionHandler(HttpServletRequest req, Exception e) {
		log.error("发生异常！原因是：{}", e.toString());
		if (e instanceof NotLoginException) {    // 如果是自定义返回异常
			NotLoginException ee = (NotLoginException) e;
			return Result.error(ee.getMessage());
		}
		return Result.error(e.getMessage());
	}

	/**
	 * 注解异常校验
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result handleValidationException(MethodArgumentNotValidException ex) {
		StringBuilder errorMessage = new StringBuilder();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			errorMessage.append(error.getDefaultMessage()).append("; ");
		});
		return Result.error(errorMessage.toString());
	}

}
