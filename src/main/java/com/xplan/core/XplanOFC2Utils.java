package com.xplan.core;  
  /**
   * 
   *    
   * XplanOFC2Utils   
   * open flash chat 工具类   
   * Chivalrous   
   * Chivalrous   
   * 2011-12-27 上午11:25:03   
   *    
   * @version 1.0.0   
   *
   */
public class XplanOFC2Utils {
	
	/**
	 * 
	 * getSetpByRange(根据最大值返回OFC特别的步长)   
	 * (这里描述这个方法适用条件 – 可选)   
	 * @param max
	 * @return    
	 *Integer   
	 * @exception    
	 * @since  1.0.0
	 */
	public static Integer getSetpByRange(Integer max){
		Integer setp =0;
		if(max>=30){
			setp=2;
		}
		if(max>=60){
			setp=4;
		}
		if(max>=100){
			setp=10;
		}
		if(max>=200){
			setp=20;
		}
		if(max>=300){
			setp=30;
		}
		return setp;
	}
	
	
}
