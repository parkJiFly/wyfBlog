package com.soft.park.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/7/3 17:09
 * @description
 */
@Component
public class FtpUtil {

	@Value("${ftp.host}")
	private String host;

	@Value("${ftp.port}")
	private int port;
	@Value("${ftp.user}")
	private String user;
	@Value("${ftp.password}")
	private String passwd;

	/**
	 * 获取FTP实例
	 * @return
	 */
	public FTPClient getFtpClient() {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(host, port);
			ftpClient.login(user,passwd);
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				ftpClient.disconnect();
				throw new IOException("连接失败 " + replyCode);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ftpClient;
	}

	/**
	 * 断联
	 * @param ftpClient
	 */
	public void disconnectFtpClient(FTPClient ftpClient) {
		if (ftpClient != null && ftpClient.isConnected()) {
			try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取根目录下文件
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public FTPFile[] listFiles(String path) throws IOException {
		FTPClient ftpClient = getFtpClient();
		FTPFile[] files = ftpClient.listFiles(path);
		disconnectFtpClient(ftpClient);
		return files;
	}

	/**
	 * 获取根目录下文件
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public List<FTPFile> listAllFiles(String path) throws IOException {
		FTPClient ftpClient = getFtpClient();
		List<FTPFile> list = new ArrayList<>();
		FTPFile[] files = ftpClient.listFiles(path);
		for (FTPFile file : files) {
			String filePath = path + "/" + file.getName();
			if (file.isDirectory()) {
				list.addAll(listAllFiles(filePath));
			} else {
				list.add(file);
			}
		}
		return list;
	}

}
