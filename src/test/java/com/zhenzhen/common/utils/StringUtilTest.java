package com.zhenzhen.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {
	@Test
	public void testGetValue() {
		String value = StringUtil.getValue("八维教育学院", 2);
		System.out.println(value);

	}

	@Test
	public void testNumber() {
		boolean b = StringUtil.isNumber("-123.123");
		System.out.println(b);

	}

	@Test
	public void testEmain() {
		boolean b = StringUtil.isEMail("348828809@qq.com");
		System.out.println(b);

	}

	@Test
	public void testPhone() {
		boolean b = StringUtil.isPhone("19710137879");
		System.out.println(b);

	}

	@Test
	public void testHasLength() {
		String src = "";
		boolean b = StringUtil.hasLength(src);
		System.out.println(b);
	}

	@Test
	public void testHasText() {
		String src = "";
		boolean b = StringUtil.hasText(src);
		System.out.println(b);
	}

	@Test
	public void testRandomChineseString() {
		String string = StringUtil.randomChineseString(3);
		System.out.println(string);
	}

	@Test
	public void testGenerateChineseName() {
		for (int i = 0; i < 6; i++) {
			String name = StringUtil.generateChineseName();
			System.out.println(name);
		}
	}
	@Test
	public void getPlaceholderValue() {
		String src="http://news.cnstock.com/news,yw-201908-4413224.htm";
		String regex="^\\d{7}+\\.+[a-z]+$";
		String placeholderValue = StringUtil.getPlaceholderValue(src, regex);
		System.out.println(placeholderValue);
	}
	@Test
	public void isHttpUrl() {
		boolean b = StringUtil.isHttpUrl("123456");
		boolean b1 = StringUtil.isHttpUrl("http://127.0.0.1/");
		System.out.println(b);
		System.out.println(b1);
	}
}
