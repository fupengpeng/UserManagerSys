package com.jiudianlianxian.util;

import java.io.UnsupportedEncodingException;

/**
 * 
 * @Title: Tools
 * @Description: 中文处理工具类
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: UserManagerSys
 * @author fupengpeng
 * @date 2017年8月17日 上午8:33:04
 *
 */
public class Tools {

	public static String getNewString(String input){
		
		String result = "";
		try {
			result = new String(input.getBytes("iso-8859-1"), "gb2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
}
