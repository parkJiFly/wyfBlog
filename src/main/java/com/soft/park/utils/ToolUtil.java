package com.soft.park.utils;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.soft.park.result.ResultPage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/18 13:48
 * @description
 */
public class ToolUtil {

	/**
	 * 分页转换
	 * @param entityPage
	 * @param voClass
	 * @return
	 * @param <E>
	 * @param <T>
	 */
	public static <E, T> ResultPage<T> convertEntityPageToToPage(IPage<E> entityPage, Class<T> voClass) {
		List<E> entityList = entityPage.getRecords();
		List<T> voList = entityList.stream()
				.map(entity -> {
					T vo = null;
					try {
						vo = voClass.getDeclaredConstructor().newInstance();
						BeanUtil.copyProperties(entity, vo);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return vo;
				})
				.collect(Collectors.toList());

		ResultPage<T> voPage = new ResultPage<>(entityPage.getCurrent(), entityPage.getSize(), entityPage.getTotal());
		voPage.setRecords(voList);
		return voPage;
	}
}
