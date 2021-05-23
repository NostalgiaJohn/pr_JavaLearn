# I/O练习

###### 1. 获取文件中各英文字母出现了几次，区分大小写。

```java
package com.fs.g_io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Demo0 {
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader(new File("文件位置"));
		
		int[] counts = new int[52];
		char[] buf = new char[1024];
		int length = -1;
		
		length = fileReader.read(buf);
		
		for (int i = 0; i < length; i++) {
			if(buf[i] >= 'A' && buf[i] <= 'Z') {
				counts[buf[i]-65] += 1;
			} else if (buf[i] >= 'a' && buf[i] <= 'z') {
				counts[buf[i] - 71] += 1;
			}
		}
		
		System.out.println(Arrays.toString(counts));
		
		fileReader.close();
	}
}

```

