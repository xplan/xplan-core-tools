package com.xplan.core;  

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
  
public class CompareUtils {
	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void compareUtilsTest(){
		List<Number> list = new ArrayList();  
		 list.add(12);
		 list.add(23);
		 list.add(45);
		 Collections.sort(list, new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				Number n1 = (Number)o1;
				Number n2=(Number)o2;
				if(n1.doubleValue()>n2.doubleValue()){
					return 1;
				}else{
					if(n1.doubleValue()==n2.doubleValue()){
						return 0;
					}else{
						return -1;
					}
				}
			}
		 }); 
		  for(int i = 0; i < list.size(); i++){  
		   System.out.println("the srot:" + list.get(i).doubleValue());  
		  }  
		
	}
	
}
