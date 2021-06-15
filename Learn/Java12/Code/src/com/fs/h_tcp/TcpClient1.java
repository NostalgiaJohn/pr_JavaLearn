package com.fs.h_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
流程:
	1. 创建Socket服务，同时明确连接服务器的IP地址和对应端口号
	2. 通过Socket对象，获取对应的OutputStream对象，发送数据给服务器
	3. 通过Socket对象，获取对应的InputStream对象，接收服务器发送数据
	4. 关闭服务
 */
public class TcpClient1 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端启动");
		System.out.println("------------------------");
		
		// 1. 创建Socket服务，同时明确连接服务器的IP地址和对应端口号
		Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(),8848);
		
		// 2. 通过Socket对象，获取对应的OutputStream对象，发送数据给服务器
		OutputStream outputStream = socket.getOutputStream();
		
		outputStream.write("你好服务器".getBytes());
		
		// 3. 通过Socket对象，获取对应的InputStream对象，接收服务器发送数据
		InputStream inputStream = socket.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int length = inputStream.read(buf);
		System.out.println(new String(buf, 0, length));
		
		// 4. 关闭服务
		socket.close();
	}
}
