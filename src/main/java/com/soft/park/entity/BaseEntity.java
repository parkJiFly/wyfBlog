package com.soft.park.entity;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/18 14:11
 * @description
 */
@Data
@Slf4j
public class BaseEntity {

	/**
	 * ID
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	@TableField(exist = false)
	private Long pageSize;

	@TableField(exist = false)
	private Long pageNo;

	public Long getPageSize() {
		if (ObjectUtil.isEmpty(pageSize)) {
			pageSize = 10L;
		}
		return pageSize;
	}

	public Long getPageNo() {
		if (ObjectUtil.isEmpty(pageNo)) {
			pageNo = 0L;
		}
		return pageNo;
	}

}
