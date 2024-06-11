package com.soft.park.utils;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/11 20:24
 * @description
 */
public interface TreeObject<T> {
	T id();
	T parentId();
	void setChildren(List list);
	List getChildren();
}
