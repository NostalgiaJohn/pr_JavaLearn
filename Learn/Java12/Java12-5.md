# 网络编程

#### 1 网络编程概述

##### C/S和B/S

```
C/S 
	客户端 服务器软件结构
	服务提供商给予用户服务需要准备的内容
		1. 各大平台的客户端
			Android iOS PC Windows Linux macOS
			QQ 微信
		2. 服务器提供服务
	软件更新:
		LOL服务器版本更新，个人本地软件也要进行更新操作。这个过程非常耗时。
		**热更新**
		
B/S
	浏览器 服务器软件结构
	服务提供商只要提供数据服务就OK，以及前端数据展示方式
		1. 浏览器提供商非常非常多
			谷歌，火狐，欧朋，Safari，Edge
		2. 服务器提供服务
	软件更新:
		服务器更新数据，浏览器刷新就ok了
```

##### 网络通信协议

```
协议：
	protocol协议
	网络通信协议是要求双方传递数据的计算机必须遵守的，按照对应的网络传输协议，才可以进入数据的交互和传递。

目前网络端数据传输比较常见的协议:
	UDP TCP/IP
```

![网络模型](https://i.loli.net/2021/06/15/vjyudQ2hreOTJG8.png)

##### UDP和TCP/IP区别

```
UDP
	1. 面向无连接，数据传递不算特别安全---相似：广播
	2. 因为面向无连接，传输速度快
	3. 因为面向无连接，数据传递存在丢包问题
	4. UDP没有客户端和服务器区别，都可以作为发送端和接收端
	UDP协议使用场景
		直播，网络游戏过程

TCP/IP
	1. 面向连接，数据传递较为安全---相似：电话
	2. 因为面向连接，所有传递速度较慢
	3. 面向连接，数据传递有保障
	4. TCP/IP协议是有明确的服务器和客户端概念
	TCP/IP协议使用场景
		登陆，数据下载，文件传输
```

##### 网络编程的三要素

```
1. 协议
	两个在于网络情况下的计算机数据传递，都需要对应的协议来完成。

2. IP地址
	Internet Protocol Address
	当前计算机在网络中的一个地址编号，类似于手机号号码
IP地址有IPv4协议和IPv6协议
IPv4是一个32位的二进制数，通常展示效果是a.b.c.d 例如 192.168.1.1
	a.b.c.d 各代表0 ~ 255的数字，目前已经消耗殆尽 42亿个
IPv6
	IPv6是能够保证地球上的每一粒沙子都有一个IP地址。
	128位地址长度，16字节一组
	8组 0x0 ~ 0xFFFF

3. 端口号
	端口号是当前应用程序在计算机中的一个编号。可以让计算机明确知道，当前的数据是基于那一个程序使用，或者数据从哪一个程序出现的。
	端口号是一个short类型 0 ~ 65535
	0~1024不能用于自定义端口号使用，特定的系统端口号
```

#### 2 IP类

```
SUN公司提供给开发使用的IP地址类
	InetAddress
常用方法:
	InetAddress getLocalhost();
		获取本机IP地址类对象
	InetAddress getByName(String str);
		根据指定的主机名获取对应的IP地址对象
	InetAddress[] getAllByName(String str);
		获取指定主机名，或者域名对应的所有IP地址类对象
```

```java
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

```

#### 3 UDP协议数据传输

##### UDP数据传输方式

```
User Datagram Protocol 
	数据传递采用数据包方式传递，所有的数据要进行打包操作，并且没有对应的客户端服务器概念，有且只有发送段和接收端
	
Socket 套接字
	数据需要进行传递操作，在数据传递的两台计算机当中必须有对应的Socket。这里采用UDP协议，那么必须有一个UDP协议的Socket
	DatagramSocket();
		创建一个发送端UDP协议Socket对象
	DatagramSocket(int port);
		创建一个接收端UDP协议的Socket对象，这里需要【监听】指定端口
		
发送端数据包的打包方法：
	DatagramPacket DatagramPacket(byte[] buf, int length, InetAddress address, int port);
	buf: 需要传递数据的字节数组
	length：是当前字节数组中数据容量字节数
	address：接收端IP地址对象
	port: 接收端对应的端口号

接收端数据包接收方式
	这里需要准备一个空的数据包
	DatagramPacket DatagramPacket(byte[] buf, int length);
	buf: 字节缓冲数组，通常是1024整数倍
	length: 当前字节缓冲数组的容量
```

##### 发送端

```
流程:
	1. 创建UDP服务器对应的发送端Socket
	2. 准备对应数据包，需要带有指定数据
	3. 发送数据 send
	4. 关闭UDP发送端
```

```java
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

```

##### 接收端

```
流程：	
	1. 打开UDP服务，并且监听指定端口	
	2. 创建新的空数据包	
	3. 通过Socket接收数据 	
	4. 关闭UDP服务接收端
```

```java
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
```

##### UDP数据传递丢失问题

```
1. 网络不够好，稳定性不行，带宽不够
2. 电脑性能不好
```

##### FeiQ

```
网络传输都有自己的传输规格，如果软件接受到的数据是自己的规格，那么可以读取数据
如果不是，丢弃！！！
FeiQ (飞秋)
    version:time:sender:ip:flag:content
    版本:时间:发送者名字:发送人IP:标记:内容
    数据是一个String类型

    而且使用的协议是UDP协议
```

```java
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

```

#### 4 TCP

##### TCP概述

```
	TCP相对于UDP比较稳定的传输协议，这里存在三次握手，保证连接状态，同时有明确的客户端和服务端之分
	TCP服务中需要服务器端先启动，需要监听指定端口，等待客户端连接。
	客户端主动连接服务器，和服务器连接之后，才可以进行数据交互，服务器不能主动连接客户端的。

TCP操作而言，Java中提供了两个Socket
	1. 服务端Socket 
		java.net.ServerSocket;
		创建对应的ServerSocket开启服务器，等待客户端连接
	2. 客户端Socket
		java.net.Socket
		创建客户端Scoket，并且连接服务器，同时将Socket发送给服务器绑定注册。
```

![tcp三次握手](https://i.loli.net/2021/06/15/f7zvFeNXiau4sO6.png)

##### Socket 客户端Socket

```
给客户端提供数据传输的符合TCP/IP要求的Socket对象

构造方法 Constructor
	Socket(String host, int port);
		host是服务器IP地址，port对应服务器程序的端口号
		通过指定的服务器IP地址和端口号，获取TCP连接对象

成员方法 Method	
	InputStream getInputStream();
		获取Socket对象输入字节流，可以从服务器获取对应的数据
		InputStream是一个资源，需要在程序退出是关闭
		Read
	
	OutputStream getOutputStream();
		获取Sokcet对象输出字节流，可以发送数据到服务器
		OutputStream是一个资源，需要在程序退出是关闭
		Write
	
	void close();
		关闭客户端Socket
	
	void shutdownOutput();
		禁止当前Socket发送数据

TCP/IP协议对应的Socket是给予IO流实现的。
```

##### ServerSocket服务端Socket

```
在服务端开启Socket服务器
构造方法 Constructor：
	ServerSocket(int port);
		开启ServerSocket服务器，并且明确当前服务端口是谁

成员方法 Method：
	Socket accept();
		监听并且连接，得到一个Socket对象，同时该方法是一个阻塞方法，会处于一个始终的监听状态
		返回的是Socket，也就是客户端Socket对象，获取到当前Socket对象，相对于获取到客户端连接，同时使用的Socket和客户端一致。
```

##### TCP协议代码演示

![TCP客户端与服务端输入输出关系](https://i.loli.net/2021/06/15/CMou2IErhbXzfD3.png)

###### 服务器代码

```
流程：
	1. 创建ServerSocket服务器，同时监听指定端口
	2. 通过accept方法获取Socket连接，得到客户端Socket对象
	3. 通过Socket对象，获取InputStream，读取客户端发送数据
	4. 通过Socket对象，获取OutputStream，发送数据给客户端
	5. 关闭服务
```

```java
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
```

###### 客户端代码

```
流程:
	1. 创建Socket服务，同时明确连接服务器的IP地址和对应端口号
	2. 通过Socket对象，获取对应的OutputStream对象，发送数据给服务器
	3. 通过Socket对象，获取对应的InputStream对象，接收服务器发送数据
	4. 关闭服务
```

```java
package com.fs.h_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		Socket socket = new Socket("172.29.57.197",8848);
		
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

```

#### 文件上传操作

###### 分析过程

![文件上传过程细节](https://i.loli.net/2021/06/15/G4y6EQYBSKk2LFc.png)

###### 客户端程序

```
流程：
	1. 创建对应文件的输入字节流操作，这里可以使用缓冲
	2. 启动Socket，
	3. 获取Socket输出OutputStream对象，发送数据给服务器
	4. 边读边发
	5. 当文件读取结束，发送完毕，关闭客户端
```

```java
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

```

###### 4.7.3 服务端程序

```
流程：
	1. 开启服务端服务，创建ServerSocket对象
	2. 明确保存文件的位置，创建对应文件夹的输出缓冲字节流
	3. 读取数据，写入文件
	4. 关闭服务器
```

```java
package com.qfedu.d_fileupload;

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
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(
						new File("D:/aaa/temp.mp4")));
		
		// 3. 获取Socket对应的输入流
		InputStream inputStream = socket.getInputStream();
		
		// 4. 边读边写
		int length = -1;
		byte[] buf = new byte[1024 * 8];
		
		while ((length = inputStream.read(buf)) != -1) {
			bos.write(buf, 0, length);
		}
		
		// 5. 关闭资源
		bos.close();
		socket.close();
	}
}
```

###### 4.7.4 目前服务端代码问题

```
1. 保存的文件名都是一致的，无法保存多个文件。
	这里可以考虑使用UUID作为文件名
2. 服务端代码肯定不能执行完一个上传功能就结束

3. 服务端代码不可能只有一个上传文件功能
	多线程
```

#### 5. 作业

```
1. 尝试实现使用TCP完成一个局域网聊天室
	a. 发送者的IP地址
	b. 接收人的IP地址
	c. 要求一个服务端，两个客户端

2. 复习
3. 代码三遍
```

