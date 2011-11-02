package com.xplan.core.exception;  
  
public class XplanDateException extends Exception{
	private static final long serialVersionUID = 2689663735576311668L;
	public XplanDateException() {
		super();  
		// TODO Auto-generated constructor stub
	}

	public XplanDateException(String message, Throwable cause) {
		super(message, cause);  
		// TODO Auto-generated constructor stub
	}

	public XplanDateException(String message) {
		super(message);  
		// TODO Auto-generated constructor stub
	}

	public XplanDateException(Throwable cause) {
		super(cause);  
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * getByXplanDateException(XplanDateUtils)   
	 * (getByYesterday抛出的异常定义 – 可选)   
	 * @return    
	 *XplanDateException   
	 * @exception    
	 * @since  1.0.0
	 */
	public static XplanDateException getByXplanDateException(){
		
		return new XplanDateException("日期字符串不能为空！");
	}
	
	
}
