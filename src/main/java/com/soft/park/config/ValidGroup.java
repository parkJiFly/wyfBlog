package com.soft.park.config;

import javax.validation.groups.Default;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/13 14:32
 * @description 实现分组校验
 */
public interface ValidGroup extends Default {
	interface Login extends ValidGroup{

	}
	interface SaveOrUpdate extends ValidGroup{

	}
	interface Delete extends ValidGroup{

	}
	interface Detail extends ValidGroup{

	}

}
