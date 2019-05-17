package com.cardplus.mobile.cardplus.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import com.cardplus.mobile.cardplus.net.pojo.Times;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * 创建时间： 2019/1/4 9:06
 * 描述：    时间工具类
 */

@SuppressWarnings("unused")
public class DateUtil {
    /**
     * 时间转时间戳
     *
     * @param str str
     * @return 时间
     * @throws ParseException
     */
    public static String dateToStamp(String str) throws ParseException {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        Date date = format.parse(str);
        return String.valueOf(date.getTime());
    }

    /**
     * 时间戳转Date
     *
     * @param str str 时间
     * @return
     */
    public static Date stringToDate(String str) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 时间戳转Date
     *
     * @param str str 时间
     * @return
     */
    public static Date stringToMillDate(String str) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 时间戳转Date
     *
     * @param str str 时间
     * @return Date
     */
    public static Date stringToMDate(String str) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = Long.valueOf(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String longToDate(long lt) {
        String res;
        @SuppressLint("SimpleDateFormat")
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        if (String.valueOf(lt).length() == 10)
            date = new Date(lt * 1000);
        else
            date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String longToDate_(long lt) {
        //
        //1551690609

        //1557266940000

        //1551690609
        String res;
        Date date;
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String longToDateD(long lt) {
        //
        //1551690609

        //1557266940000

        //1551690609
        String res;
        Date date;
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        date = new Date();
        date.setTime(lt * 1000L);
        res = simpleDateFormat.format(date);
        LogUtil.e("res:" + res + " lt:" + lt);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String longToDateY(long lt) {
        String res;
        Date date;
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        if (String.valueOf(lt).length() == 10)
            date = new Date(lt * 1000L);
        else
            date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }


    /*
     * 将时间戳转换为时间
     */
    public static String dateToString(Date date) {
        String res;
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");
        res = simpleDateFormat.format(date);
        return res;
    }


    /**
     * 获取当前年月日 星期几
     *
     * @return
     */
    public static String stringData() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
//        c.getCardInfo(Calendar.SECOND)
//        c.getCardInfo(Calendar.HOUR)
//        c.getCardInfo(Calendar.MINUTE)
        if ("1".equals(mWay)) {
            mWay = "天";
        } else if ("2".equals(mWay)) {
            mWay = "一";
        } else if ("3".equals(mWay)) {
            mWay = "二";
        } else if ("4".equals(mWay)) {
            mWay = "三";
        } else if ("5".equals(mWay)) {
            mWay = "四";
        } else if ("6".equals(mWay)) {
            mWay = "五";
        } else if ("7".equals(mWay)) {
            mWay = "六";
        }
        return mMonth + "月" + mDay + "日" + " 星期" + mWay;
    }

    /**
     * 获取当前年月
     *
     * @return
     */
    public static String stringYearMonth() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        return mYear + "-" + mMonth + "-" + mDay;
    }

    /**
     * 获取当前年月
     *
     * @return
     */
    public static String stringYearMonthDay() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        return mYear + "-" + mMonth + "-" + mDay;
    }

    /**
     * 获取当前月
     *
     * @return
     */
    public static int getMonth() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return c.get(Calendar.MONTH) + 1;// 获取当前月份
    }

    /**
     * 获取当前年
     *
     * @return
     */
    public static int getYear() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return c.get(Calendar.YEAR);
    }

    /**
     * 获取当前日
     *
     * @return
     */
    public static int getDay() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return c.get(Calendar.DATE);
    }

    /**
     * 获取当前分钟
     *
     * @return
     */
    public static int getM() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return c.get(Calendar.MINUTE);
    }

    /**
     * 获取当前日
     *
     * @return
     */
    public static int getHour() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return c.get(Calendar.HOUR_OF_DAY);
    }


    /**
     * @param str 判断所选择时间周期的类型
     * @return
     */
    public static String getMonth(String str) {
        String month = null;
        if ("Jan".equals(str)) {
            month = "1";
        } else if ("Feb".equals(str)) {
            month = "2";
        } else if ("Mar".equals(str)) {
            month = "3";
        } else if ("Apr".equals(str)) {
            month = "4";
        } else if ("May".equals(str)) {
            month = "5";
        } else if ("Jun".equals(str)) {
            month = "6";
        } else if ("Jul".equals(str)) {
            month = "7";
        } else if ("Aug".equals(str)) {
            month = "8";
        } else if ("Sep".equals(str)) {
            month = "9";
        } else if ("Oct".equals(str)) {
            month = "10";
        } else if ("Nov".equals(str)) {
            month = "11";
        } else if ("Dec".equals(str)) {
            month = "12";
        }
        return month + "月";
    }

    /**
     * 时间戳数组转具体时间
     *
     * @param batchCycleS List<String>
     * @return
     */
    public static String getBatchDateS(List<Times> batchCycleS) {

        Collections.sort(batchCycleS);
        StringBuilder cycleBuilder = new StringBuilder();

        int dateSize = batchCycleS.size();
        if (dateSize == 1) {
            cycleBuilder.append("(");
            cycleBuilder.append(batchCycleS.get(0).getDay());
            cycleBuilder.append("日)");
        } else {
            for (int i = 0; i < dateSize; i++) {
                if (i < 3) {
                    if (i == 0) {
                        cycleBuilder.append("(");
                        cycleBuilder.append(batchCycleS.get(i).getDay());
                    } else if (i == dateSize - 1) {
                        cycleBuilder.append("、");
                        cycleBuilder.append(batchCycleS.get(i).getDay());
                        cycleBuilder.append("日)");
                    } else {
                        cycleBuilder.append("、");
                        cycleBuilder.append(batchCycleS.get(i).getDay());
                    }
                } else {
                    if (dateSize == 4) {// 总天数为4
                        cycleBuilder.append("、");
                        cycleBuilder.append(batchCycleS.get(i).getDay());
                        cycleBuilder.append("日)");
                    } else {// 总天数超过4
                        cycleBuilder.append("-");
                        cycleBuilder.append(batchCycleS.get(dateSize - 1).getDay());
                        cycleBuilder.append("日)");
                        break;
                    }
                }
            }
        }
        return cycleBuilder.toString();
    }


    /**
     * 判断是否在某个时间段内
     *
     * @return boolean
     */
    public static boolean whetherTime() {
        // 为了您的账户安全，请在9:00-21:30使用收该功能
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date current;
        Date start;
        Date end;
        try {
            current = sdf.parse(sdf.format(new Date()));
            start = sdf.parse("9:00");
            end = sdf.parse("21:30");
            return current.after(start) && current.before(end);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }


}
