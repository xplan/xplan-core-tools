package com.xplan.core;  

import org.junit.Test;
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
	
	@Test
	public void testGetByYesterday(){
		String result=XplanDateUtils.getByYesterday("2011-05-06","yyyy-mm-dd");
		org.junit.Assert.assertEquals("2011-05-05", result);
	}
	
}
