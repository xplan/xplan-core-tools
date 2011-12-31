package com.xplan.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;

import com.xplan.core.properties.XplanDateUtilsProperties;

/**
 * XplanDateUtils
 * 关于日期处理的工具类
 * Chivalrous Chivalrous 2011-12-26 下午4:45:04
 * 
 * @version 1.0.0
 * 
 */
public class XplanDateUtils {
	
	private static final Logger log =Logger.getLogger(XplanDateUtils.class);
	private static SimpleDateFormat format=null;
	
	/**
	 * 
	 * getByYesterday(传入一个日期字符串返回该日期的前一天通过GET("firsttime")、get("endTime"))   
	 * (type:"yyyy-mm-dd"或者自定义格式 – 可选)   
	 * @param time
	 * @return Map
	 *String   
	 * @exception    
	 * @since  1.0.0
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map getByYesterday(String time,String type){
		String yesterday = null;
		if(!"".equals(time)&&time!=null){
			format = new SimpleDateFormat(type);
			Calendar date = Calendar.getInstance();
			 Date dats = null;
						try {
							dats=format.parse(time);
						} catch (ParseException e) {
							// TODO Auto-generated catch block  
							e.printStackTrace();
						}
					date.setTime(dats);
			  date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);  
			  
			  yesterday = format.format(date.getTime());
		}else{
			 yesterday=null;
		}
		Map map = new Hashtable();
		map.put("firstTime", time);
		map.put("endTime", yesterday);
		
		return map;
	}
	/**
	 * 
	 * getByYesterday(传入一个日期字符串返回该日期的前一天通过GET("firsttime")、get("endTime"))   
	 * (注意该方法过滤了周6周7，如果是周6或者周7则为从周5推算 – 可选)   
	 * @param time
	 * @param type
	 * @param notAndWeek
	 * @return    
	 *Map   
	 * @exception    
	 * @since  1.0.0
	 */
	@SuppressWarnings({ "static-access", "unchecked","rawtypes" })
	public static Map getByYesterday(String time,String type,boolean notAndWeek){
		Map map = new Hashtable();
		format  = new SimpleDateFormat(type);
		Calendar ca = Calendar.getInstance();
		try {
			ca.setTime(format.parse(time));
			
			if((ca.get(ca.DAY_OF_WEEK)==XplanDateUtilsProperties.FRIDAY)){
				ca.set(Calendar.DATE, ca.get(Calendar.DATE)-1);
				map.put("firstTime", format.format(ca.getTime()));
				map.put("endTime", XplanDateUtils.getByYesterday(map.get("firstTime").toString(), "yyyy-mm-dd"));
			}else if(ca.get(ca.DAY_OF_WEEK)==XplanDateUtilsProperties.SATURDAY){
				ca.set(Calendar.DATE, ca.get(Calendar.DATE)-2);
				map.put("firstTime", format.format(ca.getTime()));
				map.put("endTime", XplanDateUtils.getByYesterday(map.get("firstTime").toString(), "yyyy-mm-dd"));
			}else{
				ca.set(Calendar.DATE, ca.get(Calendar.DATE)-1);
				map.put("firstTime", time);
				map.put("endTime", format.format(ca.getTime()));
			}
		} catch (ParseException e) {
			log.error("无法解析"+time+":"+e.getMessage());  
			e.printStackTrace();
		}
		return map;
		
	}
	
	 public static int getWorkingDay(java.util.Calendar d1, java.util.Calendar d2) {
		  int result = -1;
		  if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
		  java.util.Calendar swap = d1;
		  d1 = d2;
		  d2 = swap;
		  }

		  int betweendays = getDaysBetween(d1, d2);

		  
		  int charge_date = 0;
		  int charge_start_date = 0;//开始日期的日期偏移量
		  int charge_end_date = 0;//结束日期的日期偏移量
		  // 日期不在同一个日期内
		  int stmp;
		  int etmp;
		  stmp = 7 - d1.get(Calendar.DAY_OF_WEEK);
		  etmp = 7 - d2.get(Calendar.DAY_OF_WEEK);
		  if (stmp != 0 && stmp != 6) {// 开始日期为星期六和星期日时偏移量为0
		  charge_start_date = stmp - 1;
		  }
		  if (etmp != 0 && etmp != 6) {// 结束日期为星期六和星期日时偏移量为0
		  charge_end_date = etmp - 1;
		  }
		//  }
		  result = (getDaysBetween(XplanDateUtils.getNextMonday(d1), XplanDateUtils.getNextMonday(d2)) / 7)
		  * 5 + charge_start_date - charge_end_date;
		  //System.out.println("charge_start_date>" + charge_start_date);
		  //System.out.println("charge_end_date>" + charge_end_date);
		  //System.out.println("between day is-->" + betweendays);
		  return result;
		 }
	
	
	/**
	 * 
	 * getDaysBetween(得到二个日期之间的天数)   
	 * (这里描述这个方法适用条件 – 可选)   
	 * @param d1
	 * @param d2
	 * @return    
	 *int   
	 * @exception    
	 * @since  1.0.0
	 */
	 public  static int getDaysBetween(java.util.Calendar d1, java.util.Calendar d2) {
		  if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
		  java.util.Calendar swap = d1;
		  d1 = d2;
		  d2 = swap;
		  }
		  int days = d2.get(java.util.Calendar.DAY_OF_YEAR)
		  - d1.get(java.util.Calendar.DAY_OF_YEAR);
		  int y2 = d2.get(java.util.Calendar.YEAR);
		  if (d1.get(java.util.Calendar.YEAR) != y2) {
		  d1 = (java.util.Calendar) d1.clone();
		  do {
		  days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
		  d1.add(java.util.Calendar.YEAR, 1);
		  } while (d1.get(java.util.Calendar.YEAR) != y2);
		  }
		  return days;
		 }

	 public static Calendar getNextMonday(Calendar date) {
		  Calendar result = null;
		  result = date;
		  do {
		  result = (Calendar) result.clone();
		  result.add(Calendar.DATE, 1);
		  } while (result.get(Calendar.DAY_OF_WEEK) != 2);
		  return result;
		 } 
	 
	 
	 
	 
	 public static int getHolidays(Calendar d1,Calendar d2){
		  return XplanDateUtils.getDaysBetween(d1, d2)-XplanDateUtils.getWorkingDay(d1, d2);
		  
		 }
	 
	 
	 
	 public static String getChineseWeek(Calendar date) {
		  final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
		  "星期六" };

		  int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);

		  // System.out.println(dayNames[dayOfWeek - 1]);
		  return dayNames[dayOfWeek - 1];

		 }
}

