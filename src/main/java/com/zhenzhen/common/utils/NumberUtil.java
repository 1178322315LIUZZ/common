package com.zhenzhen.common.utils;

/**
 * ���ִ�����
 * @author Lzz18
 *
 */
public class NumberUtil {
	/**
	 * 
	 * @Title: getPercent 
	 * @Description: �ٷֱȼ���
	 * @param current
	 * @param total
	 * @return
	 * @return: int
	 */
	public static int getPercent(int current, int total){
		Double doo=(double) ((float)current/(float)total)*100;
		double as=Math.floor(doo);
		int ass=(new Double(as)).intValue();
		return ass;
	}
}
