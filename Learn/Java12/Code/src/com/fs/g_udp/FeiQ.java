/*
 * 给自己的飞秋发消息
 * --可以给同一局域网安装飞秋的用户，广播（发送相同消息）
 */
package com.fs.g_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class FeiQ {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		
		String data = getData("Welcome to Java World!!!");
		DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(), data.getBytes().length
				, InetAddress.getLocalHost(), 2425);
		
		socket.send(datagramPacket);
		
		socket.close();
		
	}
	
	/**
	 * 传入数据，转换成FeiQ可以识别的数据
	 * version:time:sender:ip:flag:content
	 * 
	 * @param message 字符串类型内容
	 * @return 符合FeiQ格式要求的字符串
	 */
	public static String getData(String message) {
		StringBuilder stb = new StringBuilder();
		
		stb.append("1.0:");
		stb.append(System.currentTimeMillis() + ":");
		stb.append("Anonymous:");
		stb.append("10.1.1.1:");
		stb.append("32:");
		stb.append(message);
		
		return stb.toString();
	} 
}
