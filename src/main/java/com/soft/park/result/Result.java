package com.soft.park.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/5/31 14:59
 * @description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@NoArgsConstructor
public class Result<T> {

	public static final int SUCCESS = 200;

	public static final int ERROR = 500;

	private int code;

	private boolean isSuccess;

	private String message;

	private T data;

	public T getData() {
		return data;
	}

	private Result(int code, boolean isSuccess, String message, T data) {
		this.code = code;
		this.isSuccess = isSuccess;
		this.message = message;
		this.data = data;
	}

	public static Result success() {
		return new Result(SUCCESS, true, "操作成功", true);
	}

	public static <T> Result success(T data) {
		return new Result(SUCCESS, true, null, data);
	}

	public static <T> Result success(String msg, T data) {
		return new Result(SUCCESS, true, msg, data);
	}

	public static Result error(int code, String msg) {
		return new Result(code, false, msg, null);
	}

	public static Result error() {
		return new Result(ERROR, false, "操作失败", false);
	}

	public static Result error(String msg) {
		return new Result(ERROR, false, msg, false);
	}

	public void setData(T data) {
		this.data = data;
	}

}

