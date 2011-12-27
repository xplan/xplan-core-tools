package com.xplan.core;  

import org.junit.Test;

import junit.framework.Assert;
  
public class XplanOFC2UtilsTest {
	@Test
	public void testGetSetpByRange(){
		Integer result=XplanOFC2Utils.getSetpByRange(30);
		Integer com=2;
		Assert.assertEquals(com, result);
	}
}
