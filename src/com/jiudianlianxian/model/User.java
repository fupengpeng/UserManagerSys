package com.jiudianlianxian.model;


/**
 * 
 * Title: User
 * Description: ������һ������
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: UserManagerSys
 * @author fupengpeng
 * @date 2017��8��16�� ����8:34:48
 *
 */
public class User {
	
	private int userId;
	private String username;
	private String passwd;
	private int grade;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	

}
