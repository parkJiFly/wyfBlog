package com.soft.park.scheduled;

import cn.hutool.json.JSONObject;
import com.soft.park.service.IFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/7/3 11:44
 * @description
 */
@Component
public class FileScanTask {

	@Autowired
	private IFileInfoService iFileInfoService;

	// ANSI转义码
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";

	@Scheduled(cron = "0 * 8 * * ?")
	public void newQueryMonitorRealData() throws Exception {
		Map<String,List<JSONObject>> map = iFileInfoService.scanFile();

		// 打印 map 内容到控制台
		if (map.isEmpty()) {
			System.out.println(ANSI_RED + "当前无文件" + ANSI_RESET);
		} else {
			for (Map.Entry<String, List<JSONObject>> entry : map.entrySet()) {
				System.out.println(ANSI_RED + "File: " + entry.getKey() + ANSI_RESET);
				List<JSONObject> jsonList = entry.getValue();
				if (jsonList.isEmpty()) {
					System.out.println(ANSI_RED + "文件数据为空" + ANSI_RESET);
				} else {
					for (JSONObject jsonObject : jsonList) {
						System.out.println(ANSI_RED + jsonObject.toStringPretty() + ANSI_RESET);
					}
				}
				System.out.println(); // 分隔不同文件的数据
			}
		}

		System.out.println("---------------------------------------------------------------------");

	}
}
