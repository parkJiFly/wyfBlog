package com.soft.park.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

	public FTPClient getFtpClient() {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(host, port);
			ftpClient.login(user,passwd);
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				ftpClient.disconnect();
				throw new IOException("Failed to connect to FTP server. Reply code: " + replyCode);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ftpClient;
	}

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

	public FTPFile[] listFiles(String path) throws IOException {
		FTPClient ftpClient = getFtpClient();
		FTPFile[] files = ftpClient.listFiles(path);
		disconnectFtpClient(ftpClient);
		return files;
	}

}
