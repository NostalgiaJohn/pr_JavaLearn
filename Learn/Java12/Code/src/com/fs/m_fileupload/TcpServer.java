package com.fs.m_fileupload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
流程：
	1. 开启服务端服务，创建ServerSocket对象
	2. 明确保存文件的位置，创建对应文件夹的输出缓冲字节流
	3. 读取数据，写入文件
	4. 关闭服务器
 */
public class TcpServer {
	public static void main(String[] args) throws IOException {
		// 1. 开启服务端服务，创建ServerSocket对象
		ServerSocket serverSocket = new ServerSocket(8848);
		
		Socket socket = serverSocket.accept();
		
		// 2. 明确保存文件的位置，创建对应文件夹的输出缓冲字节流
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:/aaa/temp.mp4")));
		
		// 3. 读取数据，写入文件
		InputStream inputStream = socket.getInputStream();
		
		// 边读边写
		int length = -1;
		byte[] buf = new byte[1024 * 8];
		
		while((length = inputStream.read(buf)) != -1) {
			bos.write(buf, 0, length);
		}
		
		// 4. 关闭服务器
		bos.close();
		socket.close();
	}
}
