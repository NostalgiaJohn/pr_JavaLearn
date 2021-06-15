package com.fs.g_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
流程:
	1. 创建UDP服务器对应的发送端Socket
	2. 准备对应数据包，需要带有指定数据
	3. 发送数据 send
	4. 关闭UDP发送端
 */
public class SenderDemo1 {
	public static void main(String[] args) throws IOException {
		System.out.println("发送端启动");
		// 创建对应的Socket
		DatagramSocket socket = new DatagramSocket();
		
		// 准备数据包
		byte[] bytes = "今天继续学习...".getBytes();
		DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8848);
		
		// 发送数据包
		socket.send(packet);
		System.out.println("数据发送完毕");
		
		// 关闭UDP发送端
		socket.close();
	}
}
