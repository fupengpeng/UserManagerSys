package com.jiudianlianxian.util;

import java.io.UnsupportedEncodingException;

/**
 * 
 * @Title: Tools
 * @Description: ���Ĵ�������
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: UserManagerSys
 * @author fupengpeng
 * @date 2017��8��17�� ����8:33:04
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
