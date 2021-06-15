package com.fs.m_fileupload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
流程：
	1. 创建对应文件的输入字节流操作，这里可以使用缓冲
	2. 启动Socket，
	3. 获取Socket输出OutputStream对象，发送数据给服务器
	4. 边读边发
	5. 当文件读取结束，发送完毕，关闭客户端
 */
public class TcpClient {
	public static void main(String[] args) throws IOException {
		// 1. 创建对应文件的输入字节流操作，这里可以使用缓冲
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(new File("D:/aaa/1.mp4")));
		
		// 2. 启动Socket
		Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8848);
		
		// 3. 获取Socket输出OutputStream对象，发送数据给服务器
		OutputStream outputStream = socket.getOutputStream();
		
		int length = -1;
		byte[] buf = new byte[1024 * 8];
		
		
		// 4. 读取数据，发送数据
		while ((length = bis.read(buf)) != -1) {
			outputStream.write(buf, 0, length);
		}
		
		// 5. 关闭资源
		socket.close();
		bis.close();
	}
}
