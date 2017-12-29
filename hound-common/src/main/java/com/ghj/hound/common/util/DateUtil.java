package com.ghj.hound.common.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date parseDateRuntime(String dateString, String... patterns) {
		try {
			return DateUtils.parseDate(dateString, patterns);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String format(Date date, String format) {
		if(date == null) return null;
		return new SimpleDateFormat(format).format(date);
	}
	
	public static String formatDate(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 将Long的秒数转化为 'HH:mm:ss'格式的字符串
	 * @param time
	 * @return
	 */
	public static String secToTime(Long sec) {
		if(sec == null) return "";
        String timeStr = null;
        long hour = 0;
        long minute = 0;
        long second = 0;
        if (sec <= 0)
            return "00:00:00";
        else {
            minute = sec / 60;
            if (minute < 60) {
                second = sec % 60;
                timeStr = "00:" + unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour >= 24)
                    return "24:00:00";
                minute = minute % 60;
                second = sec - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }
	/**
	 * 将'HH:mm:ss'格式的字符串转化为 Long的秒数
	 * @param time
	 * @return
	 */
	public static Long timeToSec(String timeStr) {
	    if(timeStr == null || timeStr.trim().length() == 0) return null;
        long hour = 0;
        long minute = 0;
        long second = 0;
        String [] times = timeStr.split(":");
        
        if( times.length == 3){
        	hour = Long.parseLong(times[0]);
        	minute = Long.parseLong(times[1]);
        	//second = Long.parseLong(times[2]);
        	return hour*3600 + minute*60 + second;
        } else {
        	return null;
        }
    }
    public static String unitFormat(long i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Long.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
    
    /**
     * 根据传参的Date，返回Date所在天的当天最先一秒的Date<br>
     * 即00:00:00
     */
    public static Date getDateStart(Date date) {
        if (date == null) {
            return null;
        }
        Calendar dateEnd = Calendar.getInstance();
        dateEnd.setTime(date);
        dateEnd.set(Calendar.HOUR_OF_DAY, 00);  
        dateEnd.set(Calendar.MINUTE, 00);  
        dateEnd.set(Calendar.SECOND, 00);  
        dateEnd.set(Calendar.MILLISECOND, 000);  
        return dateEnd.getTime();  
    }
    
    /**
     * 根据传参的Date，返回Date所在天的当天最后一秒的Date<br>
     * 即23:59:59
     */
    public static Date getDateEnd(Date date) {
        if (date == null) {
            return null;
        }
        Calendar dateEnd = Calendar.getInstance();
        dateEnd.setTime(date);
        dateEnd.set(Calendar.HOUR_OF_DAY, 23);  
        dateEnd.set(Calendar.MINUTE, 59);  
        dateEnd.set(Calendar.SECOND, 59);  
        dateEnd.set(Calendar.MILLISECOND, 999);  
        return dateEnd.getTime();  
    }
    
    public static Date transform(Date date, String format) {
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
    	try {
			return formatter.parse(formatter.format(date));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
    }
}
