package com.zhenzhen.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class TimeUtil {

	/**
	 * 将日期格式化成String类型
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatTime(Date date,String pattern){
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 将String类型转化成日期格式
	 * @param date
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date ParseTime(String date,String pattern) throws ParseException{
		return new SimpleDateFormat(pattern).parse(date);
	}

	/*
	* 将LocalDatetime转换成String
	* */
	public static String formatLocalDatetime(LocalDateTime data,String pattern){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String localTime = df.format(data);
		return localTime;
	}

}
