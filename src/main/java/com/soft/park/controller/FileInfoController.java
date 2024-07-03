package com.soft.park.controller;

import com.soft.park.dto.FileInfoDTO;
import com.soft.park.result.Result;
import com.soft.park.service.IFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-07-03 10:32:48
 * @description 附件管理(FileInfo)控制层
 */
@RestController
@RequestMapping("/fileInfo")
public class FileInfoController {

	/**
	 * 服务对象
	 */
	@Autowired
	private IFileInfoService iFileInfoService;

	@GetMapping("/scan")
	public Result<FileInfoDTO> scanFile(){
		try {
			return Result.success(iFileInfoService.scanFile());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

