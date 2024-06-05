package com.soft.park.exception;

import lombok.Data;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/5 15:28
 * @description 自定义错误类型
 */
@Data
public class CusException extends RuntimeException{
	private int errorCode;
	private String errorMsg;

	public CusException(){
		super();
	}

	public CusException(String errorMsg){
		super(errorMsg);
		this.errorMsg = errorMsg;
	}

	public CusException(int errorCode,String errorMsg){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
}
