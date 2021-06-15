package com.fs.h_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
流程：
	1. 创建ServerSocket服务器，同时监听指定端口
	2. 通过accept方法获取Socket连接，得到客户端Socket对象
	3. 通过Socket对象，获取InputStream，读取客户端发送数据
	4. 通过Socket对象，获取OutputStream，发送数据给客户端
	5. 关闭服务 
 */
public class TcpServer1 {
	public static void main(String[] args) throws IOException {
		System.out.println("服务器启动");
		System.out.println("----------------------");
		
		// 1. 创建ServerSocket服务器，同时监听指定端口
		ServerSocket serverSocket = new ServerSocket(8848);
		
		// 2. 通过accept方法获取Socket连接，得到客户端Socket对象
		Socket socket = serverSocket.accept();
		
		// 3. 通过Socket对象，获取InputStream，读取客户端发送数据
		InputStream inputStream = socket.getInputStream();
		
		// IO流操作
		byte[] buf = new byte[1024];
		int length = inputStream.read(buf);
		System.out.println(new String(buf, 0, length));
		
		// 4. 通过Socket对象，获取OutputStream，发送数据给客户端
		OutputStream outputStream = socket.getOutputStream();
		String str = "欢迎来到联盟";
		
		outputStream.write(str.getBytes());
		
		// 5. 关闭Socket服务 同时关闭当前Socket使用的输入字节流和输出字节流
		// Closing this socket will also close the socket's InputStream and OutputStream. 
		socket.close();
	}
}
