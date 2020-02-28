package com.zhenzhen.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.File;
import java.util.List;
public class StreamUtilTest {

	@Test
	public void testReadInputStream() throws Exception {
		 List<String> list = StreamUtil.read(new File("E:\\hello.txt"));
		    for (String string : list) {
				System.out.println(string);
			}
	}

	@Test
	public void testReadString() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadFile() {
		fail("Not yet implemented");
	}

}
