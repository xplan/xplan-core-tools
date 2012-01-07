package com.xplan.core;  

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
  /**
   * 
   *    
   * ArrayListTest   
   * test ArrayList   
   * Chivalrous   
   * Chivalrous   
   * 2011-12-29 上午11:24:47   
   *  crate testing branch for testing working
   * @version 1.0.0   
   *
   */
public class ArrayListTest {
	
	 @Test
	public void testList(){
		List<Number> l = new ArrayList<Number>();	
		l.add(4);
		l.add(6);
		l.add(7);
		//test
		//test is teing 
		Assert.assertEquals(4, l.get(0));
		Assert.assertEquals(6, l.get(1));
		Assert.assertEquals(7, l.get(2));
	 }
}
