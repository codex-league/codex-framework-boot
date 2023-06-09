/**
 *
 */
package pub.codex.common.core.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期、时间类
 *
 * @ author sys
 */
public class DateUtil {
	// ======================日期格式化常量=====================//

	public static final String YYYY_MM_DDHHMMSS = "yyyy-MM-dd HH:mm:ss";

	public static final String YYYY_MM_DDHHMMSS_59 = "yyyy-MM-dd 23:59:59";

	public static final String YYYY_MM_DDHHMMSS_0 = "yyyy-MM-dd 00:00:00";

	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	public static final String YYYY_MM = "yyyy-MM";

	public static final String YYYY = "yyyy";

	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";

	public static final String YYYYMMDD = "yyyyMMdd";

	public static final String YYYYMM = "yyyyMM";

	public static final String YYYYMMDDHHMMSS_1 = "yyyy/MM/dd HH:mm:ss";

	public static final String YYYY_MM_DD_1 = "yyyy/MM/dd";

	public static final String YYYY_MM_1 = "yyyy/MM";

	public static final String DD = "dd";

	/**
	 * 日期转换
	 *
	 * @param time
	 * @param fmt  : yyyy-MM-dd HH:mm:ss
	 * @return
	 * @ author sys
	 */
	public static String formatTime(Timestamp time, String fmt) {
		if (time == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
		return myFormat.format(time);
	}

	/**
	 * 获取系统当前时间（秒）
	 *
	 * @return
	 * @ author sys
	 */
	public static Timestamp getTime() {
		SimpleDateFormat myFormat = new SimpleDateFormat(YYYY_MM_DDHHMMSS);
		Calendar calendar = Calendar.getInstance();
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 获取系统当前时间（毫秒）
	 *
	 * @return
	 */
	public static long getTimestamp() {
		return new Date().getTime();
	}

    /**
     * date转long，专门用于list集合中，时间范围筛选时的比较前的转换
     *
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static long dateStr2Long(String dateStr) {
		dateStr = dateStr.replace("Z", " UTC");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        long dateLong = 0;
        try {
            dateLong = sdf.parse(dateStr).getTime();
        } catch (ParseException e) {
            return dateLong;
        }
        return dateLong;
    }

	/**
	 * date转long，专门用于list集合中，时间范围筛选时的比较前的转换
	 *
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static long dateStrToLong(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long dateLong = 0;
		try {
			dateLong = sdf.parse(dateStr).getTime();
		} catch (ParseException e) {
			return dateLong;
		}
		return dateLong;
	}

    /**
     * timestamp转long，专门用于list集合中，时间范围筛选时的比较前的转换
     *
     * @param timestamp
     * @return
     */
    public static long timestamp2Long(Timestamp timestamp) {
        return timestamp.getTime();
    }

	/**
	 * 获取当前日期最开始一刻(时间 00:00:00)
	 *
	 * @return
	 * @ author sys
	 */
	public static Timestamp getDateFirst() {
		SimpleDateFormat myFormat = new SimpleDateFormat(YYYY_MM_DDHHMMSS_0);
		Calendar calendar = Calendar.getInstance();
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

    /**
     * 获取当前日期的最后一刻(时间 23:59:59)
     *
     * @return
     * @ author sys
     */
    public static Timestamp getDateLast() {
        SimpleDateFormat myFormat = new SimpleDateFormat(YYYY_MM_DDHHMMSS_59);
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

	/**
	 * 获取当前日期
	 *
	 * @return
	 * @ author sys
	 */
	public static Timestamp getDateCurrent() {
		SimpleDateFormat myFormat = new SimpleDateFormat(YYYY_MM_DDHHMMSS);
		Calendar calendar = Calendar.getInstance();
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 获取当前日期
	 *
	 * @return
	 * @ author sys
	 */
	public static Date getDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	/**
	 * yyyy-MM-dd HH:mm:ss 转换成 Timestamp
	 *
	 * @param timeString
	 * @return
	 * @ author sys
	 */
	public static Timestamp getTime(String timeString) {
		return Timestamp.valueOf(timeString);
	}

	/**
	 * 自定义格式的字符串转换成日期
	 *
	 * @param timeString
	 * @param fmt
	 * @return
	 * @throws Exception
	 * @ author sys
	 */
	public static Timestamp getTime(String timeString, String fmt) throws Exception {
		SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
		Date date = myFormat.parse(timeString);
		myFormat = new SimpleDateFormat(YYYY_MM_DDHHMMSS);
		return getTime(myFormat.format(date));
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @param fmt
	 * @return
	 * @throws Exception
	 * @ author sys
	 */
	public static String formatDate(Date date, String fmt) throws Exception {
		if (date == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
		return myFormat.format(date);
	}

	/**
	 * 格式化日期
	 *
	 * @param
	 * @param fmt
	 * @return
	 * @throws Exception
	 * @ author sys
	 */
	public static String formatDate(String timeString, String timeStringfmt, String fmt) throws Exception {
		SimpleDateFormat myFormat = new SimpleDateFormat(timeStringfmt);
		Date date = myFormat.parse(timeString);
		myFormat = new SimpleDateFormat(fmt);
		return myFormat.format(date);
	}

    /**
     * 获取格式化当前日期
     *
     * @return
     */
	public static String getDateByFormat(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		return df.format(new Date());
	}

	/**
	 * 返回日期或者时间，如果传入的是日期，返回日期的 00:00:00 时间
	 *
	 * @param timeString
	 * @return
	 * @throws Exception
	 * @ author sys
	 */
	public static Timestamp getDateFirst(String timeString) throws Exception {
		if (timeString == null || timeString.equals("")) {
			return null;
		}
		if (timeString.length() > 10) {
			return getTime(timeString, YYYY_MM_DDHHMMSS);
		} else {
			return getTime(timeString, YYYY_MM_DD);
		}
	}

	/**
	 * 返回日期或者时间，如果传入的是日期，返回日期的 23:59:59 时间
	 *
	 * @param timeString
	 * @return
	 * @throws Exception
	 * @ author sys
	 */
	public static Timestamp getDateLast(String timeString) throws Exception {
		if (timeString == null || timeString.equals("")) {
			return null;
		}
		if (timeString.length() > 10) {
			return getTime(timeString, YYYY_MM_DDHHMMSS);
		} else {
			return getTime(timeString + " 23:59:59", YYYY_MM_DDHHMMSS);
		}
	}

	/**
	 * 获取本周周一时间，返回格式 yyyy-MM-dd 00:00:00
	 *
	 * @return
	 * @ author sys
	 */
	public static Timestamp getMonday() {
		Calendar calendar = Calendar.getInstance();
		int dayofweek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		calendar.add(Calendar.DATE, -dayofweek + 1);
		SimpleDateFormat myFormat = new SimpleDateFormat(YYYY_MM_DDHHMMSS_0);
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 获取本周周日时间，返回格式 yyyy-MM-dd 23:59:59
	 *
	 * @return
	 * @ author sys
	 */
	public static Timestamp getSunday() {
		Calendar calendar = Calendar.getInstance();
		int dayofweek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		calendar.add(Calendar.DATE, -dayofweek + 7);
		SimpleDateFormat myFormat = new SimpleDateFormat(YYYY_MM_DDHHMMSS_59);
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 增加天数
	 *
	 * @param time
	 * @param day
	 * @return
	 * @ author sys
	 */
	public static Timestamp addDay(Timestamp time, Long day) {
		Timestamp time2 = new Timestamp(time.getTime() + day * 1000 * 60 * 60 * 24);
		return time2;
	}

	/**
	 * 比较 2 个日期格式的字符串
	 *
	 * @param str1 格式 ：yyyyMMdd
	 * @param str2 格式 ：yyyyMMdd
	 * @return
	 * @ author sys
	 */
	public static Integer compareDate(String str1, String str2) throws Exception {
		return Integer.parseInt(str1) - Integer.parseInt(str2);
	}

	/**
	 * 2 个时间的相差天数
	 *
	 * @param time1
	 * @param time2
	 * @return
	 * @ author sys
	 */
	public static Integer getDay(Timestamp time1, Timestamp time2) {
		Long dayTime = (time1.getTime() - time2.getTime()) / (1000 * 60 * 60 * 24);
		return dayTime.intValue();
	}

	/**
	 * 获取系统当前时间（分）
	 *
	 * @return
	 * @ author sys
	 */
	public static String getMinute() {
		SimpleDateFormat myFormat = new SimpleDateFormat(YYYYMMDDHHMM);
		return myFormat.format(new Date());
	}

	/**
	 * 获取系统当前时间
	 *
	 * @return
	 * @ formatStyle  时间格式
	 * @ author sys
	 */
	public static String getDateTime() {
		return DateUtil.getDateTime(YYYYMMDDHHMMSS);
	}

	/**
	 * 获取系统当前时间
	 *
	 * @return
	 * @ formatStyle  时间格式
	 * @ author sys
	 */
	public static String getDateTime(String formatStyle) {
		if (formatStyle == null || "".equals(formatStyle)) {
			formatStyle = YYYYMMDDHHMMSS;
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(formatStyle);
		return myFormat.format(new Date());
	}

	/**
	 * 格式化时间成yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 * @ formatStyle  时间格式
	 * @ author sys
	 */
	public static String formatDateTime(String time) throws ParseException {
		return DateUtil.formatDateTime(time, YYYY_MM_DDHHMMSS);
	}

	/**
	 * 格式化时间成yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 * @ formatStyle  时间格式
	 * @ author sys
	 */
	public static String formatDateTime(String time, String timeStr) throws ParseException {
		if (timeStr == null || "".equals(timeStr)) {
			timeStr = YYYY_MM_DDHHMMSS;
		}
		Date date = new SimpleDateFormat(YYYYMMDDHHMMSS).parse(time);
		SimpleDateFormat myFormat = new SimpleDateFormat(timeStr);
		return myFormat.format(date);
	}

	/**
	 * 转换成时间 字符串格式必须为 yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd
	 *
	 * @return
	 * @throws ParseException
	 * @ author sys
	 */
	public static Date parseToDate(String val) throws ParseException {
		Date date = null;
		if (val != null && val.trim().length() != 0 && !val.trim().toLowerCase().equals("null")) {
			val = val.trim();
			if (val.length() > 10) {
				SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DDHHMMSS);
				date = sdf.parse(val);
			}
			if (val.length() <= 10) {
				SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
				date = sdf.parse(val);
			}
		}
		return date;
	}

	/**
	 * 获取上月的第一天 yyyy-MM-dd 00:00:00 和最后一天 yyyy-MM-dd 23:59:59
	 *
	 * @return
	 * @ author sys
	 */
	@SuppressWarnings("static-access")
	public static Map<String, String> getPreMonth() {
		SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DDHHMMSS_59);

		Calendar cal = Calendar.getInstance();
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, -1);
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first_prevM = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first_prevM).append(" 00:00:00");
		day_first_prevM = str.toString(); //上月第一天

		calendar.add(cal.MONTH, 1);
		calendar.set(cal.DATE, 1);
		calendar.add(cal.DATE, -1);
		String day_end_prevM = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_end_prevM).append(" 23:59:59");
		day_end_prevM = endStr.toString();  //上月最后一天

		Map<String, String> map = new HashMap<String, String>();
		map.put("prevMonthFD", day_first_prevM);
		map.put("prevMonthPD", day_end_prevM);
		return map;
	}

	/**
	 * 获取本月的第一天 yyyy-MM-dd 00:00:00
	 *
	 * @return
	 * @ author sys
	 */
	public static String getNowMonth() {
		SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD);

		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, 0);
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first_prevM = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first_prevM).append(" 00:00:00");
		day_first_prevM = str.toString(); //本月第一天
		return day_first_prevM;
	}

	/**
	 * 获取本月的第一天 yyyy-MM-dd 00:00:00
	 *
	 * @return
	 * @ author sys
	 */
	public static Timestamp getNowMonth1() {
		SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD);

		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, 0);
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first_prevM = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first_prevM).append(" 00:00:00");
		day_first_prevM = str.toString(); //本月第一天
		SimpleDateFormat df1 = new SimpleDateFormat(YYYY_MM_DDHHMMSS);
		Timestamp timestamp = null;
		try {
			timestamp = new Timestamp(df1.parse(day_first_prevM).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	/**
	 * 获取本月的最后一天 yyyy-MM-dd 23:59:59
	 *
	 * @return
	 * @ author sys
	 */
	public static Timestamp getLastDayMonth1() {

		SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD);

		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, 0);
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, gcLast.getActualMaximum(Calendar.DAY_OF_MONTH));
		String day_first_prevM = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first_prevM).append(" 23:59:59");
		day_first_prevM = str.toString();
		SimpleDateFormat df1 = new SimpleDateFormat(YYYY_MM_DDHHMMSS);
		Timestamp timestamp = null;
		try {
			timestamp = new Timestamp(df1.parse(day_first_prevM).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	/**
	 * 获取上周周一时间，返回格式 yyyy-MM-dd 00:00:00
	 *
	 * @return
	 * @ author sys
	 */
	@SuppressWarnings("static-access")
	public static Timestamp getPreMonday() {
		Calendar calendar = Calendar.getInstance();
		int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayofweek);
		if (dayofweek == 1) {
			calendar.add(calendar.WEEK_OF_MONTH, -1);
		}

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.add(calendar.WEEK_OF_MONTH, -1);

		SimpleDateFormat myFormat = new SimpleDateFormat(YYYY_MM_DDHHMMSS_0);
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 获取上周周日时间，返回格式 yyyy-MM-dd 23:59:59
	 *
	 * @return
	 * @ author sys
	 */
	@SuppressWarnings("static-access")
	public static Timestamp getPreSunday() {
		Calendar calendar = Calendar.getInstance();
		int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
		if (dayofweek != 1) {
			calendar.add(calendar.WEEK_OF_MONTH, +1);
		}

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		calendar.add(calendar.WEEK_OF_MONTH, -1);

		SimpleDateFormat myFormat = new SimpleDateFormat(YYYY_MM_DDHHMMSS_59);
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 字符串日期加n天
	 *
	 * @param date       日期
	 * @param days       加的天数
	 * @param dateFormat 字符串日期格式
	 * @return
	 */
	public static String addDay(String date, int days, String dateFormat) {
		if (dateFormat == null || "".equals(dateFormat)) {
			dateFormat = YYYYMMDD;
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			Calendar cd = Calendar.getInstance();
			cd.setTime(formatter.parse(date));
			cd.add(Calendar.DATE, days);
			return formatter.format(cd.getTime());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 计算两个字符串的时间相差的时间
	 *
	 * @param
	 * @return
	 */
	public static Long getDayNum(String beforeDate, String afterDate) {
		SimpleDateFormat df = new SimpleDateFormat(YYYYMMDD);
		long result = 0;
		try {
			long to = df.parse(afterDate).getTime();
			long from = df.parse(beforeDate).getTime();
			result = (to - from) / (1000 * 60 * 60 * 24);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 计算日期两个差的月份
	 *
	 * @param beforeDate 格式 yyyyMM
	 * @param afterDate  格式 yyyyMM
	 * @return
	 */
	public static int getMonthNum(String beforeDate, String afterDate) {

		int yearNum = Integer.parseInt(afterDate.substring(0, 4))
				- Integer.parseInt(beforeDate.substring(0, 4));

		int resultMonthNum = 0;

		if (yearNum > 0) {
			resultMonthNum = Integer.parseInt(afterDate.substring(4)) +
					(12 - Integer.parseInt(beforeDate.substring(4))) + 12 * (yearNum - 1);
		} else if (yearNum == 0) {
			resultMonthNum = Integer.parseInt(afterDate.substring(4))
					- Integer.parseInt(beforeDate.substring(4));
		}

		return resultMonthNum;

	}

	/**
	 * 计算两个字符串的时间相差多少秒
	 *
	 * @param beforeDate 格式 yyyyMMddHHmmss
	 * @param afterDate  格式 yyyyMMddHHmmss
	 * @return
	 */
	public static Long getSecondNum(String beforeDate, String afterDate) {
		SimpleDateFormat df = new SimpleDateFormat(YYYYMMDDHHMMSS);
		long result = 0;
		try {
			long to = df.parse(afterDate).getTime();
			long from = df.parse(beforeDate).getTime();
			result = (to - from) / (1000);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取指定年月的第一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth1(String year, String month) {
		Calendar cal = Calendar.getInstance();
		//设置年份
		cal.set(Calendar.YEAR, Integer.valueOf(year));
		//设置月份
		cal.set(Calendar.MONTH, Integer.valueOf(month) - 1);
		//获取某月最小天数
		int firstDay = cal.getMinimum(Calendar.DATE);
		//设置日历中月份的最小天数
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}

	/**
	 * 获取当年的第一天
	 *
	 * @return
	 */
	public static Timestamp getFirstDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		//设置月份
		cal.set(Calendar.MONTH, 0);
		//获取某月最小天数
		int firstDay = cal.getMinimum(Calendar.DATE);
		//设置日历中月份的最小天数
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DDHHMMSS_0);
		Date parse = null;
		try {
			parse = sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Timestamp(parse.getTime());
	}

	/**
	 * 获取当年的最后一天
	 *
	 * @return
	 */
	public static Timestamp getLastDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH,cal.getActualMaximum(Calendar.MONTH));
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DDHHMMSS_59);
		Date parse = null;
		try {
			parse = sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Timestamp(parse.getTime());
	}

	/**
	 * 获取指定年月的最后一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth1(String year, String month) {
		Calendar cal = Calendar.getInstance();
		//设置年份
		cal.set(Calendar.YEAR, Integer.valueOf(year));
		//设置月份
		cal.set(Calendar.MONTH, Integer.valueOf(month) - 1);

		//获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		//设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}

	/***
	 * 返回true为时间在昨天
	 * @param oldTime
	 * @param newTime
	 * @return
	 * @throws ParseException
	 */
	public static boolean isYeatereday(Date oldTime, Date newTime) throws ParseException {
		if(newTime==null){
			newTime=new Date();
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String todayStr = format.format(newTime);
		Date today = format.parse(todayStr);
		if((today.getTime()-oldTime.getTime())>0 && (today.getTime()-oldTime.getTime())<=86400000) {
			return true;
		}
		return false;
	}

	/**
	 * 自定义取值，Date类型转为String类型
	 *
	 * @param date    日期
	 * @param pattern 格式化常量
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String dateToStr(Date date, String pattern) {
		SimpleDateFormat format = null;
		if (null == date)
			return null;
		format = new SimpleDateFormat(pattern, Locale.getDefault());
		return format.format(date);
	}

	/**
	 * 将字符串转换成Date类型的时间
	 * @return java.util.Date
	 */
	public static Date strToDate(String s, String pattern) {
		if (s == null) {
			return null;
		}
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			date = sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 根据yyyy-MM获取该月每天的日期
	 * @param searchMonth
	 * @return List<dd></>
	 */
	public static List<Long> getMonthDate(String searchMonth){
		List<Long> list = new ArrayList();
		Calendar aCalendar = Calendar.getInstance();
		int yearParam = Integer.parseInt(searchMonth.substring(0, searchMonth.indexOf("-")));
		int monthParam = Integer.parseInt(searchMonth.substring(searchMonth.indexOf("-") + 1));
		aCalendar.set(yearParam,monthParam-1,1);
		int year = aCalendar.get(Calendar.YEAR);//年份
		int month = aCalendar.get(Calendar.MONTH) + 1;//月份
		int day = aCalendar.getActualMaximum(Calendar.DATE);
		for (Long i = 1L; i <= day; i++) {
			list.add(i);
		}
		return list;
	}

	/**
	 * 获取从该日开始的本月所有日期
	 * @param today
	 * @return
	 */
	public static List<Date> getTodayMonthDate(Date today) {
		List<Date> dateList = new ArrayList<>();

		Calendar dEnd = Calendar.getInstance();
		dEnd.setTime(today);
		dEnd.add(Calendar.MONTH, 1);
		dEnd.set(Calendar.DAY_OF_MONTH, 1);
		dEnd.add(Calendar.DATE, -1);

		Calendar cStart = Calendar.getInstance();
		cStart.setTime(today);

		dateList.add(today);
		while (dEnd.getTime().after(cStart.getTime())) {
			cStart.add(Calendar.DAY_OF_MONTH, 1);
			dateList.add(cStart.getTime());
		}

		return dateList;
	}
		/**
	 * 获取过去第几天的日期
	 *
	 * @param past
	 * @return
	 */
	public static Timestamp getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DDHHMMSS_0);
		try {
			return new Timestamp(format.parse(format.format(today)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getStringTime() {
		return DateUtil.getDateTime(YYYY_MM_DDHHMMSS);
	}
}
