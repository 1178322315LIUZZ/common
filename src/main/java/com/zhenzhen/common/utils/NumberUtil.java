package com.zhenzhen.common.utils;

/**
 * 数字处理类
 * @author Lzz18
 *
 */
public class NumberUtil {
	/**
	 * 
	 * @Title: getPercent 
	 * @Description: 百分比计算方法分
	 * @param current
	 * @param total
	 * @return int
	 * @return: int
	 */
	public static int getPercent(int current, int total){
		Double doo=(double) ((float)current/(float)total)*100;
		double as=Math.floor(doo);
		int ass=(new Double(as)).intValue();
		return ass;
	}
}
