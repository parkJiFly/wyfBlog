package com.soft.park.config;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/13 14:32
 * @description 实现分组校验
 */
public interface ValidGroup{
	interface Login extends ValidGroup{

	}
	interface SaveOrUpdate extends ValidGroup{

	}
	interface Delete extends ValidGroup{

	}
	interface Detail extends ValidGroup{

	}

}
