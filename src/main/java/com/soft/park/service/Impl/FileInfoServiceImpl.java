package com.soft.park.service.Impl;

import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.entity.FileInfoEntity;
import com.soft.park.mapper.FileInfoMapper;
import com.soft.park.service.IFileInfoService;
import com.soft.park.utils.FtpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-07-03 10:32:49
 * @description 附件管理(FileInfo)表服务实现类
 */
@Service
@Slf4j
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfoEntity> implements IFileInfoService {

	@Autowired
	private FileInfoMapper fileInfoMapper;

	@Value("${file.upload.path}")
	private String savePath;

	@Value("${file.view.path}")
	private String viewPath;

	@Autowired
	private FtpUtil ftpUtil;

	@Override
	public Map<String, List<JSONObject>> scanFile() throws Exception {
		FTPClient ftpClient = ftpUtil.getFtpClient();
		if (ftpClient.isConnected()) {
			System.out.println("ftp连接成功");
		} else {
			System.out.println("ftp连接失败");
		}
		FTPFile[] ftpFiles = ftpUtil.listFiles("/");
		for (int i = 0; i < ftpFiles.length; i++) {
			System.out.println(ftpFiles[i].getName());
		}
		//获取csv文件
		CsvReader reader = CsvUtil.getReader();

		Map<String, List<JSONObject>> jsonObjectMap = new HashMap<>();
		for (FTPFile file : ftpFiles) {
			if (file.isFile() && file.getName().endsWith(".csv")) {
				InputStream inputStream = ftpClient.retrieveFileStream(file.getName());
				if (inputStream == null) {
					System.out.println("Failed to retrieve file: " + file.getName());
					continue;
				}
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

				List<JSONObject> list = new ArrayList<>();
				List<CsvRow> rows = reader.read(bufferedReader).getRows();
				List<String> rawNameList = new ArrayList<>();
				// 打印每一行数据
				for (int i = 0; i < rows.size(); i++) {
					if (i == 0) {
						rawNameList = rows.get(i).getRawList();
					} else {
						List<String> rawList = rows.get(i).getRawList();
						JSONObject jsonObject = new JSONObject();
						for (int j = 0; j < rawNameList.size(); j++) {
							jsonObject.set(rawNameList.get(j), rawList.get(j));
						}
						list.add(jsonObject);
					}
				}
				jsonObjectMap.put(file.getName().substring(0, file.getName().lastIndexOf(".")), list);
				inputStream.close();
				bufferedReader.close(); // 一定要关闭
			}
		}

		// 断开连接
		ftpUtil.disconnectFtpClient(ftpClient);
		return jsonObjectMap;

	}

}
