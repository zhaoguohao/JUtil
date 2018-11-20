package io.github.weechang.jutil.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author zhangwei
 * date 2018/7/24
 * time 16:33
 */
public class DateUtil {

    public DateUtil() {
    }

    public static long getServerTime() {
        return System.currentTimeMillis();
    }

    public static Timestamp getCurrentTime() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    public static String format(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String dateformat(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    public static String dmyformat(Date date) {
        return format(date, "dd/MM/yyyy");
    }

    public static String format(String format) {
        return format(new Date(), format);
    }

    public static String format(Date date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String dateFormat(long time) {
        return format(new Date(time), "yyyy-MM-dd HH:mm:ss");
    }

    public static String monthFormat(long time) {
        return format(new Date(time), "yyyyMM");
    }

    public static Date toLastDateTime(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            return calendar.getTime();
        }
    }

    public static Date toZeroDateTime(Date date) throws ParseException {
        String dateStr = format(date, "yyyy-MM-dd") + " 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = sdf.parse(dateStr);
        return date;
    }

    public static boolean isSameDay(Date dateA, Date dateB) {
        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(dateA);
        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(dateB);
        return calDateA.get(1) == calDateB.get(1) && calDateA.get(2) == calDateB.get(2) && calDateA.get(5) == calDateB.get(5);
    }
}
