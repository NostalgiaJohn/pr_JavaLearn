package com.fs.m_fileupload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpGoodServer {
	public static void main(String[] args) throws IOException {
		System.out.println("服务端代码启动...");
		
		// 1. 启动TCP服务端服务
		ServerSocket serverSocket = new ServerSocket(8848);
		
		// 2. 使用线程池
		ExecutorService tp = Executors.newFixedThreadPool(5);
		
		// 3. 循环
		while (true) {
			
			// 连接客户端
			Socket socket = serverSocket.accept();
			
			// 线程启动
			tp.submit(() -> {
				try {
					System.out.println(Thread.currentThread().getName());
					InputStream inputStream = socket.getInputStream();
					String fileName = UUID.randomUUID().toString().replace("-", "") + ".mp4";
					
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:/aaa/temp/" + fileName)));
				
					int length = -1;
					byte[] buf = new byte[1024 * 8];
					
					while ((length = inputStream.read(buf)) != -1) {
						bos.write(buf, 0, length);
					}
					
					bos.close();
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
	}
}
