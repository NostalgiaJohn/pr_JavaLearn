package com.fs.f_ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * IP类演示
 */
public class Demo1 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);
		
		InetAddress byName = InetAddress.getByName("www.4399.com");
		System.out.println(byName);
		
		InetAddress[] allByName = InetAddress.getAllByName("www.taobao.com");
		for (InetAddress inetAddress : allByName) {
			System.out.println(inetAddress);
		}
	}
}
