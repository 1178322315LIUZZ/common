package com.zhenzhen.common.utils;

import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @ClassName: RandomUtil
 * @Description: 随机数工具类
 * @author: Lzz
 * @date: 2020年2月27日 下午4:28:51
 */
public class RandomUtil {
	// 方法1：返回min-max之间的随机整数（包含min和max值），例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对。 (5分)
	public static int random(int min, int max) {
		Random random = new Random();
		int i = random.nextInt(max - min + 1) + min;
		return i;
	}

	// 方法2：在最小值min与最大值max之间截取subs个不重复的随机数。例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。
	// (8分)
	public static int[] subRandom(int min, int max, int subs) {
		int[] x = new int[subs];
		HashSet<Integer> set = new HashSet<Integer>();
		// set.size()代表set集合长度不等于数组长度subs,就执行while
		while (set.size() != subs) {
			// 随机获取一个随机整数，调用方法1
			int i = random(min, max);
			// 把获取到的整数添加到set集合中
			set.add(i);
		}
		// 把set集合中的值遍历到数组中
		int k = 0;// k代表数组下标
		for (Integer integer : set) {
			x[k] = integer;
			k++;
		}
		// 返回一个数组
		return x;
	}

	// 方法3：返回1个1-9,a-Z之间的随机字符。 (8分)
	public static char randomCharacter() {
		String str = "123456789qwertyuioplkjhgfdsazxcvbnmMNBVCXZASDFGHJKLPOIUYTREWQ";
		// charAt()根据下标获取对应的值
		char c = str.charAt(random(0, str.length() - 1));
		return c;
	}

	// 方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)
	public static String randomString(int length) {
		// 定义字符串用来存储生成的随机字符串，相当于验证码
		String str = "";
		// 循环生成多个随机字符串
		for (int i = 0; i < length; i++) {
			// 调用方法3生成随机字符
			// 拼接成完整的一个验证码
			str += randomCharacter();
		}
		// 返回字符串
		return str;
	}
	//随机生成多位数
	public static String random(int length) {
		String random="";
		Random ran=new Random();
		for (int i = 0; i < length; i++) {
			int  ii= ran.nextInt(9);
			random+=ii;
		}
		return random;
	}
}