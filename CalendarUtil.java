package calendar;

import com.sun.deploy.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
    static Calendar calendar = Calendar.getInstance();
    // 不足10自动补0
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    // 不补0
    public static final String YYYY_M_D_HH_MM = "yyyy-M-d HH:mm";
    // 不足10自动补0
    public static final String YYYY年M月D日HH_MM = "yyyy年M月d日 HH:mm";
    // 不补0
    public static final String YYYY年MM月DD日HH_MM = "yyyy年MM月dd日 HH:mm";

    /*
     *  获取年份
     * */
    public static int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    /*
     *  获取月份，从0开始，最终值+1
     * */
    public static int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    /*
     *  获取日
     * */
    public static int getDay() {
        return calendar.get(Calendar.DATE);
    }

    /*
     *  获取小时
     *  @param filed
     *  Calendar.HOUR 获取12小时制
     *  Calendar.HOUR_OF_DAY 获取24小时制
     * */
    public static int getHour(int filed) {
        return calendar.get(filed);
    }

    /*
     *  获取分钟
     * */
    public static int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    /*
     *  获取秒
     * */
    public static int getSecond() {
        return calendar.get(Calendar.SECOND);
    }

    /*
     *  获取毫秒
     * */
    public static int getMillSecond() {
        return calendar.get(Calendar.MILLISECOND);
    }


    /*
     *  获取现在是本月的第几天
     *  即为day
     * */
    public static int getDayOfMonth() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /*
     *  获取现在是本周的第几天1-7，周日为本周的第一天
     * */
    public static int getDayOfWeek() {
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /*
     *  获取今天是今年的第几天
     * */
    public static int getDayOfYear() {
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /*
     *  获取今天本月的第几周
     * */
    public static int getDayOfWeekInMonth() {
        return calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    }


    /*
     *  获取本周是本月第几周
     * */
    public static int getWeekOfMonth() {
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /*
     *  获取本周是本年第几周
     * */
    public static int getWeekOfYear() {
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /*
     *  获取本月/年的最大天数
     *  Calendar.DAY_OF_MONTH 本月最大天数
     *  Calendar.DAY_OF_YEAR 本年最大天数
     * */
    public static int getMaxDay(int field) {
        return calendar.getActualMaximum(field);
    }

    /*
     *  获取当前时间的时间戳
     * */
    public static long getTimeInMillis() {
        return calendar.getTimeInMillis();
    }

    /*
     *  获取当前Date
     * */
    public static Date getDate() {
        return calendar.getTime();
    }

    /*
     *  在当前日期的基础之上，添加或者减少value 后的时间
     *  遵循日历规则
     *  @param field 对应字段
     *  Calendar.YEAR 年份
     *  Calendar.MONTH 月份
     *  Calendar.DAY 天
     *  Calendar.DAY_OF_HOUR 小时
     *  Calendar.MINUTE 分
     *  Calendar.SECOND 秒
     * */
    public static void add(int field, int value) {
        calendar.add(field, value);
    }

    /*
     *  在当前日期的基础之上，设置对应field的值
     *  遵循日历规则
     *  @param field 对应字段
     *  Calendar.YEAR 年份
     *  Calendar.MONTH 月份
     *  Calendar.DAY 天
     *  Calendar.DAY_OF_HOUR 小时
     *  Calendar.MINUTE 分
     *  Calendar.SECOND 秒
     * */
    public static void set(int field, int value) {
        calendar.set(field, value);
    }

    public static void set(int year, int month, int day) {
        calendar.set(year, month, day);
    }

    public static void set(int year, int month, int day, int hour, int minute, int second) {
        calendar.set(year, month, day, hour, minute, second);
    }

    public static void setTime(Date date) {
        calendar.setTime(date);
    }

    /*
     * date转String
     *
     * */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /*
     * long转String
     * @param timeStamps 10/13位时间戳
     * */
    public static String longToString(long timeStamps, String pattern) throws Exception {
        int length = String.valueOf(timeStamps).length();
        System.out.println("length:" + length);
        if (length == 10) {
            timeStamps = timeStamps * 1000L;
            length = 13;
        }
        if (length != 13) {
            throw new Exception("请传入10或者13位时间戳");
        }
        Date date = new Date(timeStamps);
        return dateToString(date, pattern);
    }

    /*
     * str转Date
     * */
    public static Date stringToDate(String str, String pattern) throws Exception {
        if (str == null || pattern == null) throw new Exception("请传入正确的时间字符串");
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(str);
    }

}
