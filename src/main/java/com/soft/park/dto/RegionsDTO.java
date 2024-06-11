package com.soft.park.dto;

import com.soft.park.entity.RegionsEntity;
import com.soft.park.utils.TreeObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-06-11 16:07:40
 * @description 区域表(Regions)DTO类
 */
@Data
@Slf4j
public class RegionsDTO extends RegionsEntity implements TreeObject<String> {

	/**
	 * 子节点
	 */
	private List<RegionsDTO> regionsDTOList;

	@Override
	public String id() {
		return null;
	}

	@Override
	public String parentId() {
		return null;
	}

	@Override
	public void setChildren(List list) {

	}

	@Override
	public List getChildren() {
		return null;
	}

}

