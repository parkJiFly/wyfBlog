package com.soft.park.exception;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/5 15:36
 * @description
 */

public interface BaseErrorInfoInterface {
	/**
	 *  错误码
	 * @return
	 */
	String getResultCode();

	/**
	 * 错误描述
	 * @return
	 */
	String getResultMsg();
}
