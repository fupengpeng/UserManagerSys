package com.jiudianlianxian.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiudianlianxian.model.User;
import com.jiudianlianxian.model.UserBeanCl;

/**
 * 
 * @Title: UserClServlet
 * @Description: �û�����
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: UserManagerSys
 * @author fupengpeng
 * @date 2017��8��16�� ����2:40:33
 *
 */
@WebServlet("/UserClServlet")
public class UserClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�õ��û�ϣ��չʾ��ҳ��pageNow
		String s_pageNow = (String)request.getParameter("pageNow");
		int pageNow = Integer.parseInt(s_pageNow);
		//1.���ݻ�ȡ
		UserBeanCl userBeanCl = new UserBeanCl();
		List<User> list = userBeanCl.getUsersByPage(pageNow);
		int pageCount = userBeanCl.getPageCount();
		System.out.println("��ҳ��ʵ��----ʹ��UserClServlet");
		//2.��������
		request.setAttribute("result", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow+"");
		//3.չʾ����
		request.getRequestDispatcher("wel.jsp").forward(request, response);
	

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

}
