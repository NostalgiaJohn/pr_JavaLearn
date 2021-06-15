package com.fs.g_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
流程：
	1. 打开UDP服务，并且监听指定端口
	2. 创建新的空数据包
	3. 通过Socket接收数据 receive
	4. 关闭UDP服务接收端
 */
public class ReceiveDemo1 {
	public static void main(String[] args) throws IOException {
		System.out.println("接收端启动");
		// 创建Socket监听端口
		DatagramSocket socket = new DatagramSocket(8848);
		
		// 准备空数据包
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		
		// 接收数据
		socket.receive(packet);
		
		// 确定接收到的字节长度
		int length = packet.getLength();
		
		System.out.println(new String(buf, 0, length));
		
		// 关闭socket
		socket.close();
	}
}
