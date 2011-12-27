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
	
	
	
	
	
	
}
