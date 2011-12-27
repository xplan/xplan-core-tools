package com.xplan.core;  

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	@Test
	public void testGetByYesterdays() throws ParseException{
		Calendar ca = Calendar.getInstance();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
		
		ca.setTime(format.parse("2011-10-13"));
		//ca.set(Calendar.DATE, ca.get(Calendar.DATE)-1);
		System.out.println(ca.get(ca.DAY_OF_WEEK)==XplanDateUtilsProperties.WEDNESDAY);
		
	}
	
	
}
