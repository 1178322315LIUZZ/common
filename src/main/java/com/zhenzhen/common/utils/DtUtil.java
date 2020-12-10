package com.zhenzhen.common.utils;

import com.zhenzhen.common.utils.ModelPeriodUnitEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期时间工具类
 *
 * @author wen
 * @date 2019/3/7
 */
public class DtUtil {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(DtUtil.class);

    /**
     * 粒度定义
     * <p>
     * 日粒度
     */
    public static final int DAY = 1;

    /**
     * 周粒度
     */
    public static final int WEEK = 2;

    /**
     * 旬粒度
     */
    public static final int TEN_DAYS = 3;

    /**
     * 月粒度
     */
    public static final int MONTH = 4;

    /**
     * 季粒度
     */
    public static final int SEASON = 5;

    /**
     * 半年粒度
     */
    public static final int HALF_YEAR = 6;

    /**
     * 年粒度
     */
    public static final int YEAR = 7;

    /**
     * 日期时间字符串格式定义
     */
    public static final String ISO_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期字符串格式定义
     */
    public static final String ISO_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 月-日-年(后两位) 格式
     */
    public static final String MONTH_DAY_SHORT_YEAR_PATTERN = "yyyy-MM-dd";

    /**
     * 解析模式数组
     */
    private static final String[] PARSE_PATTERNS = {"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm","yyyy-MM-dd HH",
            "yyyy-MM-dd HH:mm:ss.SSS","yyyy-MM-dd HH:mm:ss.SS", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd"};

    /**
     * 返回yyyyMMdd时间字符串
     * @param
     * @return
     */
    public static String getyyyyMMddStr()
    {
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return date;
    }
    /**
     * 返回yyyyMMddHHmmss时间字符串
     * @param
     * @return
     */
    public static String getyyyyMMddHHmmssStr()
    {
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return date;
    }

    String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
    /*判断符合日期格式*/
    public static boolean isDate(String dateStr)
    {
        try {
            DateUtils.parseDate(dateStr, PARSE_PATTERNS);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     * 获取系统当前yyyy-MM-dd日期对象
     *
     * @return 当前日期
     */
    public static Date getNowDate() {
        Date date = isoDateStrToDate(getCurrentIsoDateStr());
        return date;
    }

    /**
     * 获取系统当前yyyy-MM-dd HH:mm:ss日期时间对象
     *
     * @return 当前日期
     */
    public static Date getNowDateTime() {
        Date date = isoDatetimeStrToDate(getCurrentIsoDateTimeStr());
        return date;
    }


    /**
     * 获取系统当前yyyy-MM-dd日期字符串
     *
     * @return 当前日期
     */
    public static String getCurrentIsoDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(ISO_DATE_PATTERN);
        return sdf.format(new Date());
    }

    /**
     * 获取系统当前yyyy-MM-dd HH:mm:ss日期时间字符串
     *
     * @return 当前日期时间
     */
    public static String getCurrentIsoDateTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(ISO_DATETIME_PATTERN);
        return sdf.format(new Date());
    }

    /**
     * 获取系统当前指定格式的日期时间字符串
     *
     * @param pattern 日期时间格式
     * @return 日期时间字符串
     */
    public static String getCurrentDtStrForGivenPattern(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

    /**
     * 将指定Java的Date对象按照yyyy-MM-dd格式转换为字符串
     *
     * @return yyyy-MM-dd格式的字符串
     */
    public static String datetimeToIsoDateStr(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat(ISO_DATE_PATTERN);
        return sdf.format(dt);
    }

    /**
     * 将指定Java的Date对象按照yyyy-MM-dd HH:mm:ss格式转换为字符串
     *
     * @param dt Java的Date对象
     * @return yyyy-MM-dd HH:mm:ss字符串
     */
    public static String datetimeToIsoDatetimeStr(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat(ISO_DATETIME_PATTERN);
        return sdf.format(dt);
    }

    /**
     * 将指定日期按照指定格式转换为字符串
     *
     * @param dt      Java的Date对象
     * @param pattern 模式字符串
     * @return 将Java的Date对象按照pattern转换后的字符串
     */
    public static String dateToString(Date dt, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(dt);
    }

    /**
     * 将yyyy-MM-dd格式的字符串转为Java的Date对象
     *
     * @param isoDateStr yyyy-MM-dd格式的字符串
     * @return Java的Date对象
     */
    public static Date isoDateStrToDate(String isoDateStr) {
        Date dt = null;
        SimpleDateFormat sdf = new SimpleDateFormat(ISO_DATE_PATTERN);
        try {
            dt = sdf.parse(isoDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss格式的字符串转为Java的Date对象
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss格式的字符串
     * @return Java的Date对象
     */
    public static Date isoDatetimeStrToDate(String isoDatetimeStr) {
        Date dt = null;
        SimpleDateFormat sdf = new SimpleDateFormat(ISO_DATETIME_PATTERN);
        try {
            dt = sdf.parse(isoDatetimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    /**
     * 将MM-dd-yy格式的字符串转为Java的Date对象
     *
     * @param monthDayShortYearStr MM-dd-yy格式的字符串
     * @return Java的Date对象
     */
    public static Date monthDayShortYearStrToDate(String monthDayShortYearStr) {
        Date dt = null;
        SimpleDateFormat sdf = new SimpleDateFormat(MONTH_DAY_SHORT_YEAR_PATTERN);
        try {
            dt = sdf.parse(monthDayShortYearStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    /**
     * 获取指定Java的Date对象的年份字符串
     *
     * @param dt Java的Date对象
     * @return 年份字符串
     */
    public static String getYearStr(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(dt);
    }

    /**
     * 获取yyyy-MM-dd字符串的年份字符串
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @return 年份字符串
     */
    public static String getYearStrFromIsoDateStr(String isoDateStr) {
        return getYearStr(isoDateStrToDate(isoDateStr));
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss字符串的年份字符串
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss字符串
     * @return 年份字符串
     */
    public static String getYearStrFromIsoDatetimeStr(String isoDatetimeStr) {
        return getYearStr(isoDatetimeStrToDate(isoDatetimeStr));
    }

    /**
     * 获取指定Java的Date对象的月份字符串
     *
     * @param dt Java的Date对象
     * @return 月份字符串
     */
    public static String getMonthStr(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return sdf.format(dt);
    }

    /**
     * 获取yyyy-MM-dd字符串的月份字符串
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @return 月份字符串
     */
    public static String getMonthStrFromIsoDateStr(String isoDateStr) {
        return getMonthStr(isoDateStrToDate(isoDateStr));
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss字符串的月份字符串
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss字符串
     * @return 月份字符串
     */
    public static String getMonthStrFromIsoDatetimeStr(String isoDatetimeStr) {
        return getMonthStr(isoDatetimeStrToDate(isoDatetimeStr));
    }

    /**
     * 获取指定Java的Date对象的日字符串
     *
     * @param dt Java的Date对象
     * @return 日字符串
     */
    public static String getDayStr(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(dt);
    }

    /**
     * 获取yyyy-MM-dd字符串的日字符串
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @return 日字符串
     */
    public static String getDayStrFromIsoDateStr(String isoDateStr) {
        return getDayStr(isoDateStrToDate(isoDateStr));
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss字符串的日字符串
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss字符串
     * @return 日字符串
     */
    public static String getDayStrFromIsoDatetimeStr(String isoDatetimeStr) {
        return getDayStr(isoDatetimeStrToDate(isoDatetimeStr));
    }

    /**
     * 获取MM-dd-yy字符串的年份
     *
     * @param monthDayShortYearStr MM-dd-yy字符串
     * @return 年份字符串
     */
    public static String getYearStrFromMonthDayShortYearStr(String monthDayShortYearStr) {
        return getYearStr(monthDayShortYearStrToDate(monthDayShortYearStr));
    }

    /**
     * 获取MM-dd-yy字符串的月份
     *
     * @param monthDayShortYearStr MM-dd-yy字符串
     * @return 月份字符串
     */
    public static String getMonthStrFromMonthDayShortYearStr(String monthDayShortYearStr) {
        return getMonthStr(monthDayShortYearStrToDate(monthDayShortYearStr));
    }

    /**
     * 获取MM-dd-yy字符串的日
     *
     * @param monthDayShortYearStr MM-dd-yy字符串
     * @return 日字符串
     */
    public static String getDayStrFromMonthDayShortYearStr(String monthDayShortYearStr) {
        return getDayStr(monthDayShortYearStrToDate(monthDayShortYearStr));
    }

    /**
     * 获取指定Java的Date对象的月末日期时间
     *
     * @param dt Java的Date对象
     * @return 月末日期时间
     */
    public static Date getMonthEnd(Date dt) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        int maxDay = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), maxDay);
        return gc.getTime();
    }

    /**
     * 获取指定Java的Date对象的月末日期时间字符串
     *
     * @param dt Java的Date对象
     * @return 月末日期时间字符串
     */
    public static String getMonthEndStr(Date dt) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        int maxDay = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), maxDay);
        SimpleDateFormat sdf = new SimpleDateFormat(ISO_DATE_PATTERN);
        return sdf.format(gc.getTime());
    }

    /**
     * 获取yyyy-MM-dd日期时间字符串的月末日期
     *
     * @param isoDateStr yyyy-MM-dd日期时间字符串
     * @return 月末日期
     */
    public static Date getMonthEnd(String isoDateStr) {
        return getMonthEnd(isoDateStrToDate(isoDateStr));
    }

    /**
     * 获取yyyy-MM-dd日期字符串的月末yyyy-MM-dd日期字符串
     *
     * @param isoDateStr yyyy-MM-dd日期字符串
     * @return 月末yyyy-MM-dd日期字符串
     */
    public static String getMonthEndStrForIsoDateStr(String isoDateStr) {
        return getMonthEndStr(isoDateStrToDate(isoDateStr));
    }

    /**
     * 获取yyyy-MM-dd字符串的季度末日期yyyy-MM-dd字符串
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @return 季度末日期字符串
     */
    public static String getSeasonEndStrFromIsoDateStr(String isoDateStr) {
        String result = "";
        switch (Integer.parseInt(getMonthStrFromIsoDateStr(isoDateStr))) {
            case 1:
            case 2:
            case 3:
                result = getYearStrFromIsoDateStr(isoDateStr) + "-03-31";
                break;
            case 4:
            case 5:
            case 6:
                result = getYearStrFromIsoDateStr(isoDateStr) + "-06-30";
                break;
            case 7:
            case 8:
            case 9:
                result = getYearStrFromIsoDateStr(isoDateStr) + "-09-30";
            case 10:
            case 11:
            case 12:
                result = getYearStrFromIsoDateStr(isoDateStr) + "-12-31";
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss字符串的季度末日期yyyy-MM-dd字符串
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss字符串
     * @return 季度末日期字符串
     */
    public static String getSeasonEndStrFromIsoDatetimeStr(String isoDatetimeStr) {
        String result = "";
        switch (Integer.parseInt(getMonthStrFromIsoDatetimeStr(isoDatetimeStr))) {
            case 1:
            case 2:
            case 3:
                result = getYearStrFromIsoDatetimeStr(isoDatetimeStr) + "-03-31";
                break;
            case 4:
            case 5:
            case 6:
                result = getYearStrFromIsoDatetimeStr(isoDatetimeStr) + "-06-30";
                break;
            case 7:
            case 8:
            case 9:
                result = getYearStrFromIsoDatetimeStr(isoDatetimeStr) + "-09-30";
            case 10:
            case 11:
            case 12:
                result = getYearStrFromIsoDatetimeStr(isoDatetimeStr) + "-12-31";
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 获取yyyy-MM-dd字符串的半年末日期字符串
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @return 半年末日期字符串
     */
    public static String getHalfYearEndStrFromIsoDateStr(String isoDateStr) {
        if (Integer.parseInt(getMonthStrFromIsoDateStr(isoDateStr)) <= 6) {
            return getYearStrFromIsoDateStr(isoDateStr) + "06-30";
        } else {
            return getYearStrFromIsoDateStr(isoDateStr) + "12-31";
        }
    }

    /**
     * 获取yyyy-MM-dd字符串的半年末日期字符串
     *
     * @param isoDatetimeStr yyyy-MM-dd字符串
     * @return 半年末日期字符串
     */
    public static String getHalfYearEndStrFromIsoDatetimeStr(String isoDatetimeStr) {
        if (Integer.parseInt(getMonthStrFromIsoDateStr(isoDatetimeStr)) <= 6) {
            return getYearStrFromIsoDatetimeStr(isoDatetimeStr) + "06-30";
        } else {
            return getYearStrFromIsoDatetimeStr(isoDatetimeStr) + "12-31";
        }
    }

    /**
     * 获取yyyy-MM-dd字符串的年末日期字符串
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @return 日期字符串
     */
    public static String getYearEndStrFromIsoDateStr(String isoDateStr) {
        return getYearStrFromIsoDateStr(isoDateStr) + "12-31";
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss字符串的年末日期字符串
     *
     * @param isoDatetimeStr yyyy-MM-dd字符串
     * @return 日期字符串
     */
    public static String getYearEndStrFromIsoDatetimeStr(String isoDatetimeStr) {
        return getYearStrFromIsoDatetimeStr(isoDatetimeStr) + "12-31";
    }

    /**
     * 将Java的Date对象加上指定的月数并返回新的Date对象
     *
     * @param dt     Java的Date对象
     * @param addend 加的月数
     * @return 新的Date对象
     */
    public static Date addMonth(Date dt, int addend) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(Calendar.MONTH, addend);
        //System.err.println("addend:"+addend+"---"+gc.getTime());
        return gc.getTime();
    }

    /**
     * 将Java的Date对象加上指定的年数并返回新的Date对象
     *
     * @param dt     Java的Date对象
     * @param addend 加的年数
     * @return 新的Date对象
     */
    public static Date addYear(Date dt, int addend) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(Calendar.YEAR, addend);
        return gc.getTime();
    }

    /**
     * 将yyyy-MM-dd字符串加上指定的月数后返回新的Date对象
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @param addend     加的月数
     * @return 新的Date对象
     */
    public static Date addMonthFromIsoDateStr(String isoDateStr, int addend) {
        return addMonth(isoDateStrToDate(isoDateStr), addend);
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss字符串加上指定的月数后返回新的Date对象
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss字符串
     * @param addend         加的月数
     * @return 新的Date对象
     */
    public static Date addMonthFromIsoDatetimeStr(String isoDatetimeStr, int addend) {
        return addMonth(isoDateStrToDate(isoDatetimeStr), addend);
    }

    /**
     * 将Java的Date对象加上指定的天数并返回新的Date对象
     *
     * @param dt     Java的Date对象
     * @param addend 加的天数
     * @return 新的Date对象
     */
    public static Date addDay(Date dt, int addend) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(Calendar.DATE, addend);
        return gc.getTime();
    }

    /**
     * 将yyyy-MM-dd字符串加上指定的天数后返回新的Date对象
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @param addend     加的天数
     * @return 新的Date对象
     */
    public static Date addDayFromIsoDateStr(String isoDateStr, int addend) {
        return addDay(isoDateStrToDate(isoDateStr), addend);
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss字符串加上指定的天数后返回新的Date对象
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss字符串
     * @param addend         加的天数
     * @return 新的Date对象
     */
    public static Date addDayFromIsoDatetimeStr(String isoDatetimeStr, int addend) {
        return addDay(isoDateStrToDate(isoDatetimeStr), addend);
    }

    /**
     * 将Java的Date对象加上指定的秒数并返回新的Date对象
     *
     * @param dt     Java的Date对象
     * @param addend 加的秒数
     * @return 新的Date对象
     */
    public static Date addSecond(Date dt, int addend) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        gc.add(Calendar.SECOND, addend);
        return gc.getTime();
    }

    /**
     * 判断Java的Date对象是否是月末
     *
     * @param dt Java的Date对象
     * @return 是否是月末
     */
    public static boolean isMonthEnd(Date dt) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        return gc.getActualMaximum(Calendar.DAY_OF_MONTH) == gc.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 判断yyyy-MM-dd字符串是否是月末
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @return 是否是月末
     */
    public static boolean isMonthEndForIsoDateStr(String isoDateStr) {
        return isMonthEnd(isoDateStrToDate(isoDateStr));
    }

    /**
     * 判断yyyy-MM-dd HH:mm:ss字符串是否是月末
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss字符串
     * @return 是否是月末
     */
    public static boolean isMonthEndForIsoDatetimeStr(String isoDatetimeStr) {
        return isMonthEnd(isoDatetimeStrToDate(isoDatetimeStr));
    }

    /**
     * 判断Java的Date对象是否是季度末
     *
     * @param dt Java的Date对象
     * @return 是否是季度末
     */
    public static boolean isSeasonEnd(Date dt) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        int month = gc.get(Calendar.MONTH) + 1;
        if (month == 3 || month == 6 || month == 9 || month == 12) {
            return isMonthEnd(dt);
        } else {
            return false;
        }
    }

    /**
     * 判断yyyy-MM-dd字符串是否是月末
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @return 是否是月末
     */
    public static boolean isSeasonEndForIsoDateStr(String isoDateStr) {
        return isSeasonEnd(isoDateStrToDate(isoDateStr));
    }

    /**
     * 判断yyyy-MM-dd HH:mm:ss字符串是否是月末
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss字符串
     * @return 是否是月末
     */
    public static boolean isSeasonEndForIsoDatetimeStr(String isoDatetimeStr) {
        return isSeasonEnd(isoDatetimeStrToDate(isoDatetimeStr));
    }

    /**
     * 判断Java的Date对象是否是半年末
     *
     * @param dt Java的Date对象
     * @return 是否是半年末
     */
    public static boolean isHalfYearEnd(Date dt) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        int month = gc.get(Calendar.MONTH);
        if (month == 6 || month == 12) {
            return isMonthEnd(dt);
        } else {
            return false;
        }
    }

    /**
     * 判断yyyy-MM-dd字符串是否是半年末
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @return 是否是半年末
     */
    public static boolean isHalfYearEndForIsoDateStr(String isoDateStr) {
        return isHalfYearEnd(isoDateStrToDate(isoDateStr));
    }

    /**
     * 判断yyyy-MM-dd HH:mm:ss字符串是否是半年末
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss字符串
     * @return 是否是半年末
     */
    public static boolean isHalfYearEndForIsoDatetimeStr(String isoDatetimeStr) {
        return isHalfYearEnd(isoDatetimeStrToDate(isoDatetimeStr));
    }

    /**
     * 判断Java的Date对象是否是年末
     *
     * @param dt Java的Date对象
     * @return 是否是年末
     */
    public static boolean isYearEnd(Date dt) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        return gc.getActualMaximum(Calendar.DAY_OF_YEAR) == gc.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 判断yyyy-MM-dd字符串是否是年末
     *
     * @param isoDateStr yyyy-MM-dd字符串
     * @return 是否是年末
     */
    public static boolean isYearEndForIsoDateStr(String isoDateStr) {
        return isYearEnd(isoDateStrToDate(isoDateStr));
    }

    /**
     * 判断yyyy-MM-dd HH:mm:ss字符串是否是年末
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss字符串
     * @return 是否是年末
     */
    public static boolean isYearEndForIsoDatetimeStr(String isoDatetimeStr) {
        return isYearEnd(isoDatetimeStrToDate(isoDatetimeStr));
    }

    /**
     * 返回yyyy-MM-dd日期字符串的上旬末的yyyy-MM-dd日期字符串
     *
     * @param isoDateStr yyyy-MM-dd日期字符串
     * @return 上旬末的yyyy-MM-dd日期字符串
     */
    public static String getLastXunEndStrForIsoDateStr(String isoDateStr) {
        String lastXunEndStr = "";
        int day = Integer.parseInt(getDayStrFromIsoDateStr(isoDateStr));
        if (day <= 10) {
            lastXunEndStr = getMonthStr(addMonthFromIsoDateStr(isoDateStr, -1));
        } else if (day <= 20) {
            lastXunEndStr = getYearStrFromIsoDateStr(isoDateStr) + "-" + getMonthStrFromIsoDateStr(isoDateStr) + "-10";
        } else {
            lastXunEndStr = getYearStrFromIsoDateStr(isoDateStr) + "-" + getMonthStrFromIsoDateStr(isoDateStr) + "-20";
        }
        return lastXunEndStr;
    }

    /**
     * 返回yyyy-MM-dd日期字符串的上年末的yyyy-MM-dd日期字符串
     *
     * @param isoDateStr yyyy-MM-dd日期字符串
     * @return 上年末的yyyy-MM-dd日期字符串
     */
    public static String getLastYearEndStrForIsoDateStr(String isoDateStr) {
        String lastYearEnd;
        int year = Integer.parseInt(getYearStrFromIsoDateStr(isoDateStr));
        lastYearEnd = year + "-12-31";
        return lastYearEnd;
    }

    /**
     * 返回yyyy-MM-dd日期字符串的上月末的yyyy-MM-dd日期字符串
     *
     * @param isoDateStr yyyy-MM-dd日期字符串
     * @return 上年末的yyyy-MM-dd日期字符串
     */
    public static String getLastMonthEndStrForIsoDateStr(String isoDateStr) {
        if (StringUtils.isEmpty(isoDateStr)) {
            return "";
        } else {
            return getMonthEndStr(addMonthFromIsoDateStr(isoDateStr, -1));
        }
    }

    /**
     * 获取yyyy-MM-dd日期字符串的上日yyyy-MM-dd日期字符串
     *
     * @param isoDateStr yyyy-MM-dd日期字符串
     * @return 上日yyyy-MM-dd日期字符串
     */
    public static String getLastDayStrForIsoDateStr(String isoDateStr) {
        if (StringUtils.isEmpty(isoDateStr)) {
            return "";
        } else {
            return datetimeToIsoDateStr(addDay(isoDateStrToDate(isoDateStr), -1));
        }
    }

    /**
     * 获取yyyy-MM-dd日期字符串的一个季度前的月末yyyy-MM-dd日期字符串
     *
     * @param isoDateStr yyyy-MM-dd日期字符串
     * @return yyyy-MM-dd日期字符串
     */
    public static String getLastSeasonEndStrForIsoDateStr(String isoDateStr) {
        for (int i = 0; i < 3; i++) {
            isoDateStr = getMonthEndStrForIsoDateStr(isoDateStr);
        }
        return isoDateStr;
    }

    /**
     * 获取yyyy-MM-dd日期字符串的元月1号yyyy-MM-dd日期字符串
     *
     * @param isoDateStr yyyy-MM-dd日期字符串
     * @return yyyy-MM-dd日期字符串
     */
    public static String getYearBeginForIsoDateStr(String isoDateStr) {
        String year = getYearEndStrFromIsoDateStr(isoDateStr);
        return year + "-01-01";
    }

    /**
     * 比较两个Java的Date对象的大小
     *
     * @param dt01 Java的Date对象
     * @param dt02 Java的Date对象
     * @return 比较结果 dt01早于dt02：-1 等于dt02：0 晚于dt02：1
     */
    public static int compareDate(Date dt01, Date dt02) {
        GregorianCalendar gc01 = new GregorianCalendar();
        GregorianCalendar gc02 = new GregorianCalendar();
        gc01.setTime(dt01);
        gc02.setTime(dt02);

        if (gc01.before(gc02)) {
            return -1;
        } else if (gc01.after(gc02)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 比较两个yyyy-MM-dd日期字符串的日期大小
     *
     * @param isoDateStr01 yyyy-MM-dd日期字符串
     * @param isoDateStr02 yyyy-MM-dd日期字符串
     * @return 比较结果 isoDateStr01早于isoDateStr02：-1 等于isoDateStr02：0 晚于isoDateStr02：1
     */
    public static int compareIsoDateStr(String isoDateStr01, String isoDateStr02) {
        return compareDate(isoDateStrToDate(isoDateStr01), isoDateStrToDate(isoDateStr02));
    }

    /**
     * 比较两个yyyy-MM-dd HH:mm:ss日期时间字符串的日期大小
     *
     * @param isoDatetimeStr01 yyyy-MM-dd HH:mm:ss日期时间字符串
     * @param isoDatetimeStr02 yyyy-MM-dd HH:mm:ss日期时间字符串
     * @return 比较结果 isoDatetimeStr01早于isoDatetimeStr02：-1 等于isoDatetimeStr02：0 晚于isoDatetimeStr02：1
     */
    public static int compareIsoDatetimeStr(String isoDatetimeStr01, String isoDatetimeStr02) {
        return compareDate(isoDateStrToDate(isoDatetimeStr01), isoDateStrToDate(isoDatetimeStr02));
    }

    /**
     * 计算两个Java的Date对象相差的月数
     *
     * @param startDt Java的Date对象
     * @param endDt   Java的Date对象
     * @return 相差的月数
     */
    public static int diffMonths(Date startDt, Date endDt) {
        GregorianCalendar startGc = new GregorianCalendar();
        GregorianCalendar endGc = new GregorianCalendar();
        startGc.setTime(startDt);
        endGc.setTime(endDt);
        return ((startGc.get(Calendar.YEAR) - endGc.get(Calendar.YEAR)) * 12) + (startGc.get(Calendar.MONTH) - endGc.get(Calendar.MONTH));
    }

    /**
     * 计算两个yyyy-MM-dd日期字符串相差的月数
     *
     * @param startIsoDateStr yyyy-MM-dd日期字符串
     * @param endIsoDateStr   yyyy-MM-dd日期字符串
     * @return 相差的月数
     */
    public static int diffMonthsForIsoDateStr(String startIsoDateStr, String endIsoDateStr) {
        return diffMonths(isoDateStrToDate(startIsoDateStr), isoDateStrToDate(endIsoDateStr));
    }

    /**
     * 计算两个yyyy-MM-dd HH:mm:ss日期时间字符串相差的月数
     *
     * @param startIsoDatetimeStr yyyy-MM-dd HH:mm:ss日期时间字符串
     * @param endIsoDatetimeStr   yyyy-MM-dd HH:mm:ss日期时间字符串
     * @return 相差的月数
     */
    public static int diffMonthsForIsoDatetimeStr(String startIsoDatetimeStr, String endIsoDatetimeStr) {
        return diffMonths(isoDatetimeStrToDate(startIsoDatetimeStr), isoDatetimeStrToDate(endIsoDatetimeStr));
    }

    /**
     * 计算两个Java的Date对象相差的天数
     *
     * @param startDt Java的Date对象
     * @param endDt   Java的Date对象
     * @return 相差的天数
     */
    public static int diffDays(Date startDt, Date endDt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDay = null;
        Date endDay = null;
        try {
            startDay = sdf.parse(sdf.format(startDt));
            endDay = sdf.parse(sdf.format(endDt));
        } catch (ParseException e) {
            logger.error("SimpleDateFormat进行parse时发生异常：", e);
            e.printStackTrace();
        }
        return (int) ((endDay.getTime() - startDay.getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * 计算两个yyyy-MM-dd日期字符串相差的天数
     *
     * @param startIsoDateStr yyyy-MM-dd日期字符串
     * @param endIsoDateStr   yyyy-MM-dd日期字符串
     * @return 相差的天数
     */
    public static int diffDaysForIsoDateStr(String startIsoDateStr, String endIsoDateStr) {
        return diffDays(isoDateStrToDate(startIsoDateStr), isoDateStrToDate(endIsoDateStr));
    }

    /**
     * 计算两个yyyy-MM-dd HH:mm:ss日期时间字符串相差的天数
     *
     * @param startIsoDatetimeStr yyyy-MM-dd HH:mm:ss日期时间字符串
     * @param endIsoDatetimeStr   yyyy-MM-dd HH:mm:ss日期时间字符串
     * @return 相差的天数
     */
    public static int diffDaysForIsoDatetimeStr(String startIsoDatetimeStr, String endIsoDatetimeStr) {
        return diffDays(isoDatetimeStrToDate(startIsoDatetimeStr), isoDatetimeStrToDate(endIsoDatetimeStr));
    }

    /**
     * 计算两个Java的Date对象相差的秒数
     *
     * @param startDt Java的Date对象
     * @param endDt   Java的Date对象
     * @return 相差的秒数
     */
    public static int diffSeconds(Date startDt, Date endDt) {
        return (int) ((endDt.getTime() - startDt.getTime()) / 1000);
    }

    /**
     * 将日期时间字符串转换为Java的Date对象,如字符串为空或不合法则返回系统当前日期
     *
     * @param dtStr 日期时间字符串
     * @return Java的Date对象
     */
    public static Date chgStrToDt(String dtStr) {
        Date dt = null;
        try {
            dt = DateUtils.parseDate(dtStr, PARSE_PATTERNS);
        } catch (ParseException e) {
            logger.error("Date Format error [" + dtStr + " ] , return current date!!!", e);
            e.printStackTrace();
            dt = new Date();
        }
        return dt;
    }

    /**
     * 将Java的Date对象转换为Sql的Date对象
     *
     * @param dt Java的Date对象
     * @return Sql的Date对象
     */
    public static java.sql.Date chgJavaDtToSqlDt(Date dt) {
        return new java.sql.Date(dt.getTime());
    }

    /**
     * 将日期时间字符串转换为Sql的Date对象
     *
     * @param dtStr 日期时间字符串
     * @return Sql的Date对象
     */
    public static java.sql.Date chgDtStrToSqlDt(String dtStr) {
        return new java.sql.Date(chgStrToDt(dtStr).getTime());
    }

    /**
     * 判断Java的Date对象是否是指定粒度的末日期，精确到日
     *
     * @param dt          Java的Date对象
     * @param granularity 粒度
     * @return 是否是指定粒度的末日期
     */
    public static boolean isEndForGivenGranularity(Date dt, int granularity) {
        boolean result = false;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        switch (granularity) {
            case DAY:
                result = true;
                break;
            case WEEK:
                result = (Calendar.SUNDAY == gc.get(Calendar.DAY_OF_WEEK));
            case TEN_DAYS:
                int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
                if (dayOfMonth == 10 || dayOfMonth == 20 || gc.getActualMaximum(Calendar.DAY_OF_MONTH) == dayOfMonth) {
                    result = true;
                }
                break;
            case MONTH:
                result = gc.getActualMaximum(Calendar.DAY_OF_MONTH) == gc.get(Calendar.DAY_OF_MONTH);
                break;
            case SEASON:
                if ((gc.get(Calendar.MONTH) + 1) % 3 == 0 && gc.getActualMaximum(Calendar.DAY_OF_MONTH) == gc.get(Calendar.DAY_OF_MONTH)) {
                    result = true;
                }
                break;
            case HALF_YEAR:
                if ((gc.get(Calendar.MONTH) + 1) % 6 == 0 && gc.getActualMaximum(Calendar.DAY_OF_MONTH) == gc.get(Calendar.DAY_OF_MONTH)) {
                    result = true;
                }
                break;
            case YEAR:
                if (gc.get(Calendar.MONTH) == 11 && gc.getActualMaximum(Calendar.DAY_OF_MONTH) == gc.get(Calendar.DAY_OF_MONTH)) {
                    result = true;
                }
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 判断给定的yyyy-MM-dd日期字符串是否是指定粒度的末日期，精确到日
     *
     * @param isoDateStr  yyyy-MM-dd日期字符串
     * @param granularity 粒度
     * @return 判断结果
     */
    public static boolean isEndIsoDateStrForGivenGranularity(String isoDateStr, int granularity) {
        return isEndForGivenGranularity(isoDateStrToDate(isoDateStr), granularity);
    }

    /**
     * 判断给定的yyyy-MM-dd HH:mm:ss日期时间字符串是否是指定粒度的末日期，精确到日
     *
     * @param isoDatetimeStr yyyy-MM-dd HH:mm:ss日期时间字符串
     * @param granularity    粒度
     * @return 判断结果
     */
    public static boolean isEndIsoDatetimeStrForGivenGranularity(String isoDatetimeStr, int granularity) {
        return isEndForGivenGranularity(isoDatetimeStrToDate(isoDatetimeStr), granularity);
    }

    /**
     * 根据指定的粒度比较Java的Date对象的大小
     *
     * @param dt01        Java的Date对象
     * @param dt02        Java的Date对象
     * @param granularity 粒度
     * @return 在指定粒度下dt01晚于dt02：1 早于dt02：-1 等于dt02：0
     */
    public static int compareDtForGivenGranularity(Date dt01, Date dt02, int granularity) {
        Date tempDt01 = getMonthEnd(dt01);
        Date tempDt02 = getMonthEnd(dt02);
        long result = tempDt01.getTime() - tempDt02.getTime();
        return result > 0 ? 1 : result < 0 ? -1 : 0;
    }

    /**
     * 根据指定的粒度比较给定的yyyy-MM-dd日期字符串的大小
     *
     * @param isoDateStr01 yyyy-MM-dd日期字符串
     * @param isoDateStr02 yyyy-MM-dd日期字符串
     * @param granularity  粒度
     * @return 在指定粒度下isoDateStr01晚于isoDateStr02：1 早于isoDateStr02：-1 等于isoDateStr02：0
     */
    public static int compareIsoDateStrForGivenGranularity(String isoDateStr01, String isoDateStr02, int granularity) {
        return compareDtForGivenGranularity(isoDateStrToDate(isoDateStr01), isoDateStrToDate(isoDateStr02), granularity);
    }

    /**
     * 根据指定的粒度比较给定的yyyy-MM-dd HH:mm:ss日期时间字符串的大小
     *
     * @param isoDatetimeStr01 yyyy-MM-dd HH:mm:ss日期时间字符串
     * @param isoDatetimeStr02 yyyy-MM-dd HH:mm:ss日期时间字符串
     * @param granularity      粒度
     * @return 在指定粒度下isoDatetimeStr01晚于isoDatetimeStr02：1 早于isoDatetimeStr02：-1 等于isoDatetimeStr02：0
     */
    public static int compareIsoDatetimeStrForGivenGranularity(String isoDatetimeStr01, String isoDatetimeStr02, int granularity) {
        return compareDtForGivenGranularity(isoDatetimeStrToDate(isoDatetimeStr01), isoDatetimeStrToDate(isoDatetimeStr02), granularity);
    }

    /**
     * 获取指定Java的Date对象在指定粒度的期初日期
     *
     * @param dt          Java的Date对象
     * @param granularity 粒度
     * @return Java的Date对象
     */
    public static Date getBeginDtForGivenGranularity(Date dt, int granularity) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        switch (granularity) {
            case WEEK:
                gc.add(Calendar.DATE, -1);
                gc.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                break;
            case TEN_DAYS:
                int dtDay = gc.get(Calendar.DAY_OF_MONTH);
                int firstTenDays = dtDay > 20 ? 21 : dtDay > 10 ? 11 : 1;
                gc.set(Calendar.DAY_OF_MONTH, firstTenDays);
                break;
            case MONTH:
                gc.set(Calendar.MONTH, 1);
                break;
            case SEASON:
                int dtMonth = gc.get(Calendar.MONTH) + 1;
                int firstMonth = dtMonth < 4 ? 1 : dtMonth < 7 ? 4 : dtMonth < 10 ? 7 : 10;
                gc.set(gc.get(Calendar.YEAR), firstMonth - 1, 1);
                break;
            case HALF_YEAR:
                int firstHalfYear = gc.get(Calendar.MONTH) < 6 ? 1 : 7;
                gc.set(gc.get(Calendar.YEAR), firstHalfYear - 1, 1);
                break;
            case YEAR:
                gc.set(gc.get(Calendar.YEAR), 0, 1);
                break;
            default:
                break;
        }
        return gc.getTime();
    }

    /**
     * 获取指定Java的Date对象在指定粒度的期末日期
     *
     * @param dt          Java的Date对象
     * @param granularity 粒度
     * @return Java的Date对象
     */
    public static Date getEndDtForGivenGranularity(Date dt, int granularity) {
        int endDay;
        int endMonth;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        int dtYear = gc.get(Calendar.YEAR);
        int dtMonth = gc.get(Calendar.MONTH) + 1;
        int dtDay = gc.get(Calendar.DAY_OF_MONTH);

        switch (granularity) {
            case WEEK:
                gc.add(Calendar.DATE, 6);
                gc.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                break;
            case TEN_DAYS:
                endDay = dtDay < 11 ? 10 : dtDay < 21 ? 20 : gc.getActualMaximum(Calendar.DAY_OF_MONTH);
                gc.set(Calendar.DAY_OF_MONTH, endDay);
                break;
            case MONTH:
                gc.set(Calendar.DAY_OF_MONTH, gc.getActualMaximum(Calendar.DAY_OF_MONTH));
                break;
            case SEASON:
                endMonth = dtMonth < 4 ? 3 : dtMonth < 7 ? 6 : dtMonth < 10 ? 9 : 12;
                gc.set(Calendar.MONTH, endMonth - 1);
                gc.set(Calendar.DAY_OF_MONTH, 1);
                gc.set(Calendar.DAY_OF_MONTH, gc.getActualMaximum(Calendar.DAY_OF_MONTH));
                break;
            case HALF_YEAR:
                endMonth = dtMonth < 7 ? 6 : 12;
                endDay = dtMonth < 7 ? 30 : 31;
                gc.set(dtYear, endMonth - 1, endDay);
                break;
            case YEAR:
                gc.set(dtYear, 11, 31);
                break;
            default:
                break;
        }
        return gc.getTime();
    }

    /**
     * 计算指定日期指定粒度的相差期数
     *
     * @param dt01        Java的Date对象
     * @param dt02        Java的Date对象
     * @param granularity 粒度
     * @return 指定粒度的相差期数
     */
    public static int subGranularity(Date dt01, Date dt02, int granularity) {
        GregorianCalendar gc1 = new GregorianCalendar();
        GregorianCalendar gc2 = new GregorianCalendar();
        Date tmpDt1 = getEndDtForGivenGranularity(dt01, granularity);
        Date tmpDt2 = getEndDtForGivenGranularity(dt02, granularity);
        gc1.setTime(tmpDt1);
        gc2.setTime(tmpDt2);
        int result = 0;

        switch (granularity) {
            case DAY:
                result = (int) ((tmpDt1.getTime() - tmpDt2.getTime()) / (24 * 60 * 60 * 1000));
                break;
            case WEEK:
                result = (gc1.get(Calendar.YEAR) - gc2.get(Calendar.YEAR)) * 52 + gc1.get(Calendar.WEEK_OF_YEAR) - gc2.get(Calendar.WEEK_OF_YEAR);
                break;
            case TEN_DAYS:
                result = (gc1.get(Calendar.YEAR) - gc2.get(Calendar.YEAR)) * 36;
                result += (gc1.get(Calendar.MONTH) - gc2.get(Calendar.MONTH)) * 3;
                int dayOfMon1 = gc1.get(Calendar.DAY_OF_MONTH);
                int dayOfMon2 = gc2.get(Calendar.DAY_OF_MONTH);
                int tenDaysOfMon1 = dayOfMon1 < 11 ? 1 : dayOfMon1 < 21 ? 2 : 3;
                int tenDaysOfMon2 = dayOfMon2 < 11 ? 1 : dayOfMon2 < 21 ? 2 : 3;
                result += (tenDaysOfMon1 - tenDaysOfMon2);
                break;
            case MONTH:
                result = (gc1.get(Calendar.YEAR) - gc2.get(Calendar.YEAR)) * 12 + gc1.get(Calendar.MONTH) - gc2.get(Calendar.MONTH);
                break;
            case SEASON:
                result = (gc1.get(Calendar.YEAR) - gc2.get(Calendar.YEAR)) * 4 + (gc1.get(Calendar.MONTH) - gc2.get(Calendar.MONTH)) / 3;
                break;
            case HALF_YEAR:
                result = (gc1.get(Calendar.YEAR) - gc2.get(Calendar.YEAR)) * 2 + (gc1.get(Calendar.MONTH) - gc2.get(Calendar.MONTH)) / 6;
                break;
            case YEAR:
                result = (gc1.get(Calendar.YEAR) - gc2.get(Calendar.YEAR));
                break;
            default:
                break;
        }

        return result;
    }

    /**
     * 计算指定日期字符串指定粒度相差的期数
     *
     * @param dtStr1      日期字符串
     * @param dtStr2      日期字符串
     * @param granularity 粒度
     * @return 相差的期数
     */
    public static int subGranularity(String dtStr1, String dtStr2, int granularity) {
        return subGranularity(chgStrToDt(dtStr1), chgStrToDt(dtStr2), granularity);
    }

    /**
     * 返回指定粒度，指定时间段内的所有日期字符串列表
     *
     * @param strDt1      起始日期字符串
     * @param strDt2      结束日期字符串
     * @param granularity 粒度
     * @param includeEnd  是否加最后一个日期
     * @return 日期字符串列表
     */
    public static List<String> getIsoDateStrList(String strDt1, String strDt2, int granularity, boolean includeEnd) {
        Date beginDt = chgStrToDt(strDt1);
        Date endDt = chgStrToDt(strDt2);
        Date tmpDate;
        int granSize = subGranularity(endDt, beginDt, granularity);

        if (granSize < 0) {
            granSize *= -1;
            tmpDate = beginDt;
            beginDt = endDt;
            endDt = tmpDate;
        }
        List<String> result = new ArrayList<>(granSize);
        for (int i = 0; i < granSize; i++) {
            result.add(datetimeToIsoDateStr(addForGivenGranularity(beginDt, granularity, i, true)));

        }
        // 判断是否加最后一个日期
        tmpDate = addForGivenGranularity(beginDt, granularity, granSize, true);
        if (compareDtForGivenGranularity(tmpDate, endDt, DAY) == 0 || !includeEnd) {
            result.add(datetimeToIsoDateStr(tmpDate));
        }
        return result;
    }

    /**
     * 获取指定范围内，指定数量的日期字符串列表
     *
     * @param beginDate 起始日期
     * @param endDate   结束日期
     * @param num       数组中的元素个数
     * @return 日期字符串列表
     */
    public static List<String> getIsoDateStrList(Date beginDate, Date endDate, int num) {
        long diffSeconds = diffSeconds(beginDate, endDate);
        long beginMillSeconds = beginDate.getTime(), endMillSeconds = endDate.getTime();
        long interval = diffSeconds / num;
        List<String> dateStrList = new ArrayList<>();
        Date curr;
        while (endMillSeconds > beginMillSeconds) {
            curr = new Date(beginMillSeconds);
            dateStrList.add(datetimeToIsoDateStr(curr));
            beginMillSeconds += interval;
        }
        return dateStrList;
    }

    /**
     * 计算指定Java的Date对象在指定粒度下加上指定粒度数后的日期
     *
     * @param dt                          Java的Date对象
     * @param granularity                 粒度
     * @param addend                      加数
     * @param isGetEndForGivenGranularity 是否获取该粒度末的日期，true会再进行一步转换粒度末日期的操作，false不转换
     * @return Java的Date对象
     */
    public static Date addForGivenGranularity(Date dt, int granularity, int addend, boolean isGetEndForGivenGranularity) {
        Date result = null;
        int maxDay = 0;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);

        switch (granularity) {
            case DAY:
                gc.add(Calendar.DATE, addend);
                break;
            case WEEK:
                gc.add(Calendar.DATE, addend * 7);
                break;
            case TEN_DAYS:
                int dayOfTenDays = dayOfMonth < 11 ? dayOfMonth : dayOfMonth < 21 ? dayOfMonth - 10 : dayOfMonth - 20;
                int tenDaysOfMonth = dayOfMonth < 11 ? 0 : dayOfMonth < 21 ? 1 : 2;

                //计算调整月数及旬数
                int modiMonths = addend / 3;
                int modiTenDays = addend % 3;
                if (addend < 0) {
                    modiMonths -= 1;
                    modiTenDays += 3;
                }
                modiTenDays += tenDaysOfMonth;
                gc.add(Calendar.MONTH, modiMonths + modiTenDays / 3);

                //计算调整后天数
                int factDay = dayOfTenDays + modiTenDays % 3 * 10;
                switch (modiTenDays % 3) {
                    case 0:
                        dayOfMonth = factDay < 10 ? factDay : 10;
                        break;
                    case 1:
                        dayOfMonth = factDay < 20 ? factDay : 20;
                        break;
                    default:
                        maxDay = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
                        dayOfMonth = factDay < maxDay ? factDay : maxDay;
                        break;
                }
                gc.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                break;
            case MONTH:
                gc.add(Calendar.MONTH, addend);
                gc.set(Calendar.DAY_OF_MONTH, 1);
                maxDay = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
                gc.set(Calendar.DAY_OF_MONTH, dayOfMonth < maxDay ? dayOfMonth : maxDay);
                break;
            case SEASON:
                gc.add(Calendar.MONTH, addend * 3);
                gc.set(Calendar.DAY_OF_MONTH, 1);
                maxDay = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
                gc.set(Calendar.DAY_OF_MONTH, dayOfMonth < maxDay ? dayOfMonth : maxDay);
                break;
            case HALF_YEAR:
                gc.add(Calendar.MONTH, addend * 6);
                gc.set(Calendar.DAY_OF_MONTH, 1);
                maxDay = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
                gc.set(Calendar.DAY_OF_MONTH, dayOfMonth < maxDay ? dayOfMonth : maxDay);
                break;
            case YEAR:
                gc.add(Calendar.YEAR, addend);
                break;
            default:
                break;
        }
        if (isGetEndForGivenGranularity) {
            result = getEndDtForGivenGranularity(gc.getTime(), granularity);
        } else {
            result = gc.getTime();
        }
        return result;
    }

    /**
     * 计算指定日期指定粒度后的日期，日期将转换为粒度末日期
     *
     * @param dt          指定日期
     * @param granularity 粒度
     * @param addend      加的粒度数
     * @return 新的日期
     */
    public static Date addForGivenGranularity(Date dt, int granularity, int addend) {
        return addForGivenGranularity(dt, granularity, addend, true);
    }

    /**
     * 计算指定字符串日期n期后日期
     *
     * @param dtStr                       日期字符串
     * @param granularity                 粒度
     * @param addend                      加的粒度数
     * @param isGetEndForGivenGranularity 是否包含最后一个日期
     * @return 日期字符串
     */
    public static String addForGivenGranularity(String dtStr, int granularity, int addend, boolean isGetEndForGivenGranularity) {
        return datetimeToIsoDateStr(addForGivenGranularity(chgStrToDt(dtStr), granularity, addend, isGetEndForGivenGranularity));
    }

    /**
     * 计算指定字符串日期n期后期末日期
     *
     * @param dtStr       日期字符串
     * @param granularity 粒度
     * @param addend      加的粒度数
     * @return 日期字符串
     */
    public static String addForGivenGranularity(String dtStr, int granularity, int addend) {
        return addForGivenGranularity(dtStr, granularity, addend, true);
    }

    /**
     * 根据粒度，取中文日期
     *
     * @param dt          Java的Date对象
     * @param granularity 粒度
     * @return 中文日期
     */
    public static String getChineseDtForGivenGranularity(Date dt, int granularity) {
        StringBuffer result = new StringBuffer(32);
        String strDayChn = "日";
        String strWeekChn = "周";
        String strTenDayChn = "旬";
        String strMonthChn = "月";
        String strSeasonChn = "季度";
        String strHalfYearChn = "半年";
        String strYearChn = "年";
        String strNo = "第";
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);

        int intYear = gc.get(Calendar.YEAR);
        int intMonth = gc.get(Calendar.MONTH) + 1;
        int intDay = gc.get(Calendar.DAY_OF_MONTH);

        switch (granularity) {
            case DAY:
                result.append(intYear).append(strYearChn);
                result.append(intMonth).append(strMonthChn);
                result.append(intDay).append(strDayChn);
                break;
            case WEEK:
                result.append(intYear).append(strYearChn);
                result.append(intMonth).append(strMonthChn);
                result.append(strNo).append(gc.get(Calendar.WEEK_OF_MONTH)).append(strWeekChn);
                break;
            case TEN_DAYS:
                result.append(intYear).append(strYearChn);
                result.append(intMonth).append(strMonthChn);

                String tenday = intDay < 11 ? "上" : intDay < 21 ? "中" : "下";
                result.append(tenday).append(strTenDayChn);
                break;
            case MONTH:
                result.append(intYear).append(strYearChn);
                result.append(intMonth).append(strMonthChn);
                break;
            case SEASON:
                result.append(intYear).append(strYearChn);
                String season = intMonth < 4 ? "一" : intMonth < 7 ? "二" : intMonth < 10 ? "三" : "四";
                result.append(strNo).append(season).append(strSeasonChn);
                break;
            case HALF_YEAR:
                result.append(intYear).append(strYearChn);
                String halfyear = intMonth < 7 ? "上" : "下";
                result.append(halfyear).append(strHalfYearChn);
                break;
            case YEAR:
                result.append(intYear).append(strYearChn);
                break;
            default:
                break;
        }
        return result.toString();
    }


    /**
     * 转换指定日期格式为中文日期格式
     *
     * @param dtStr       日期字符串
     * @param granularity 粒度
     * @return 中文日期格式
     */
    public static String getChineseDtForGivenGranularity(String dtStr, int granularity) {
        String result;

        try {
            Date dt = DateUtils.parseDate(dtStr, PARSE_PATTERNS);
            result = getChineseDtForGivenGranularity(dt, granularity);
        } catch (ParseException e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断给定日期是本年指定粒度的第几期
     *
     * @param dt          Java的Date对象
     * @param granularity 粒度
     * @return 给定日期是本年指定粒度的第几期
     */
    public static int getNumOfYear(Date dt, int granularity) {
        int result = 0;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        int intMonth = gc.get(Calendar.MONTH) + 1;
        int intDay = gc.get(Calendar.DAY_OF_MONTH);

        switch (granularity) {
            case DAY:
                result = gc.get(Calendar.DAY_OF_YEAR);
                break;
            case WEEK:
                result = gc.get(Calendar.WEEK_OF_YEAR);
                break;
            case TEN_DAYS:
                result = intMonth * 3 + intDay / 10 + 1;
                break;
            case MONTH:
                result = intMonth;
                break;
            case SEASON:
                result = intMonth / 4 + 1;
                break;
            case HALF_YEAR:
                result = intMonth / 7 + 1;
                break;
            case YEAR:
                result = 1;
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 判断给定日期是本年指定粒度的第几期
     *
     * @param dtStr       日期字符串
     * @param granularity 粒度
     * @return 给定日期是本年指定粒度的第几期
     */
    public static int getNumOfYear(String dtStr, int granularity) {
        return getNumOfYear(chgStrToDt(dtStr), granularity);
    }

    /**
     * 取最近上一个粒度日期
     *
     * @param granularity 粒度
     * @return 日期字符串
     */
    public static String getRecntlyDate(int granularity) {
        return (addForGivenGranularity(addForGivenGranularity(getCurrentIsoDateStr(), DAY, 1), granularity, -1));
    }

    /**
     * 取指定日期最近上一个粒度日期
     *
     * @param dtStr       日期字符串
     * @param granularity 粒度
     * @return 日期字符串
     */
    public static String getRecntlyDate(String dtStr, int granularity) {
        return (addForGivenGranularity(addForGivenGranularity(dtStr, DAY, 1), granularity, -1));
    }

    public static void main(String[] args)
    {
        /*System.out.println(DtUtil.diffDays(DtUtil.chgStrToDt("2019-12-30 11"),
                DtUtil.chgStrToDt("2019-12-30 12")));*/
        System.out.println(DtUtil.diffMonths(DtUtil.chgStrToDt("2019-12-30 00:00:00"),
                DtUtil.chgStrToDt("2020-01-31 00:00:00")));
    }

    public static Date getFirstTaskDate(Date firstPlanDate, int period, ModelPeriodUnitEnum periodUnitEnum, Date start)
    {
        Date firstTaskTime = start;//第一次任务时间


        if(!firstPlanDate.before(firstTaskTime)){
            //如果首排日期在当前日期之后或相等则首排日期为第一次任务日期，
            firstTaskTime = firstPlanDate;
        }
        else {
            switch (periodUnitEnum) {
                case DAY:
                    //如果首排日期在当前日期之前:需要计算两个时间相差天数
                    //如果这个天数不是周期的倍数则这个天数需要补齐成为这个周期的倍数

                    //计算相差天数
                    int diffDays = DtUtil.diffSeconds(firstPlanDate, firstTaskTime);
                    int tempDays = diffDays / 86400;
                    diffDays = diffDays % 86400 > 0 ? tempDays + 1 : tempDays;
                    //计算需要加上多少天
                    int requireAddDays = diffDays;
                    int yu = diffDays % period;
                    if (yu > 0)
                        requireAddDays += period - yu;
                    firstTaskTime = DtUtil.addDay(firstPlanDate, requireAddDays);
                    break;
                case MONTH:
                    while(firstPlanDate.before(firstTaskTime)){
                        firstPlanDate = DtUtil.addMonth(firstPlanDate, period);
                    }
                    firstTaskTime = firstPlanDate;
                    break;
                case YEAR:
                    while(firstPlanDate.before(firstTaskTime)){
                        firstPlanDate = DtUtil.addYear(firstPlanDate, period);
                    }
                    firstTaskTime = firstPlanDate;
                    break;
            }
        }
        return firstTaskTime;
    }
}
