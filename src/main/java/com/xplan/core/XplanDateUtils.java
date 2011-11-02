package com.xplan.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * XplanDateUtils
 * 本团队关于日期处理的工具类
 * Chivalrous Chivalrous 2011-12-26 下午4:45:04
 * 
 * @version 1.0.0
 * 
 */
public class XplanDateUtils {
	
	/**
	 * 
	 * getByYesterday(传入一个日期字符串返回该日期的前一天)   
	 * (type:"yyyy-mm-dd"或者自定义格式 – 可选)   
	 * @param time
	 * @return    
	 *String   
	 * @exception    
	 * @since  1.0.0
	 */
	public static String getByYesterday(String time,String type){
		String yesterday = null;
		if(!"".equals(time)&&time!=null){
			SimpleDateFormat dft = new SimpleDateFormat(type);
			Calendar date = Calendar.getInstance();
			 Date dats = null;
						try {
							dats=dft.parse(time);
						} catch (ParseException e) {
							// TODO Auto-generated catch block  
							e.printStackTrace();
						}
					date.setTime(dats);
			  date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);  
			  
			  yesterday = dft.format(date.getTime());
		}else{
			 yesterday=null;
		}
		return yesterday;
	}
	
}
