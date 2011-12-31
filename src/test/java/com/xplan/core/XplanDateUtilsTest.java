package com.xplan.core;  

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.xplan.core.properties.XplanDateUtilsProperties;
  /**
   * XplanDateUtilsTest   
   * XplanDateUtils的单元测试类
   * Chivalrous   
   * Chivalrous   
   * 2011-12-26 下午5:11:47   
   *    
   * @version 1.0.0   
   *
   */
public class XplanDateUtilsTest {
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testGetByYesterday(){
		Map result=XplanDateUtils.getByYesterday("2011-05-06","yyyy-mm-dd");
		org.junit.Assert.assertEquals("2011-05-05", result.get("endTime"));
	}
	@SuppressWarnings("static-access")
	@Test
	public void testGetByYesterdays() throws ParseException{
		Calendar ca = Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
		
		ca.setTime(format.parse("2011-10-13"));
		//ca.set(Calendar.DATE, ca.get(Calendar.DATE)-1);
		System.out.println(ca.get(ca.DAY_OF_WEEK)==XplanDateUtilsProperties.WEDNESDAY);
		
	}
	
	@Test
	 public  void testGetDaysBetween() {
		  try {

		  String strDateStart = "2006-10-1";
		  String strDateEnd = "2006-10-14";
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  Date date_start = sdf.parse(strDateStart);
		  Date date_end = sdf.parse(strDateEnd);
		  
		  Calendar cal_start = Calendar.getInstance();
		  Calendar cal_end = Calendar.getInstance();
		  cal_start.setTime(date_start);
		  cal_end.setTime(date_end);
		int s=  XplanDateUtils.getDaysBetween(cal_start, cal_end);
		  System.out.println(s);
		  } catch (Exception e) {
		  // TODO: handle exception
		  }
		 }
	
	
	
	
}
