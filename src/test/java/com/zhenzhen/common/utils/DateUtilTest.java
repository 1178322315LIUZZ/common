package com.zhenzhen.common.utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;

import org.junit.Test;

public class DateUtilTest {

	//月末
		@Test
		public void testEndMonth() {
			Date date = DateUtil.getEndMonth(new Date());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(df.format(date));
		}
		
		//月初
		@Test
		public  void testInitMonth() {
			
			//Date date = DateUtil.getInitMonth(new Date());
			Date date = DateUtil.getInitMonth(new Date(9999999999991l));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(df.format(date));
		}

		@Test
		public void testRandomDate() {
			//获取日历类
			Calendar c = Calendar.getInstance();
			c.set(2010, 0, 1);//为日历类设置
			Date date = DateUtil.randomDate(c.getTime(), new Date());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(df.format(date));
		}

}
