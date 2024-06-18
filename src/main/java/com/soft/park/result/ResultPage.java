package com.soft.park.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/18 13:47
 * @description
 */
@Data
@NoArgsConstructor
public class ResultPage<T> {
	private Long total;

	private Long size;

	private Long current;

	List<T> records;

	public ResultPage(Long current, Long size, Long total) {
		this.current = current;
		this.size = size;
		this.total = total;
	}

	public ResultPage(Long current, Long size, Long total, List<T> records) {
		this.current = current;
		this.size = size;
		this.total = total;
		this.records = records;
	}
}
