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
 * Title: LoginClServlet
 * Description: ��¼���������
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: UserManagerSys
 * @author fupengpeng
 * @date 2017��8��16�� ����11:35:07
 *
 */
@WebServlet("/LoginClServlet")
public class LoginClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ��û���������
		String u = request.getParameter("username");
		String p = request.getParameter("passwd");
		System.out.println("username = " + u + "    password = " + p);
		UserBeanCl userBeanCl = new UserBeanCl();
		if (userBeanCl.checkUser(u, p)) {
//			response.sendRedirect("wel.jsp");//ת�����ת��Ч�ʲ��Ǻܸ�
			System.out.println("����LoginClServlet");
			
			//����ת��wel��jspҳ��ʱ���Ͱ�Ҫ��ʾ�����ݣ���wel��jsp׼����
			//1.׼������
			int pageNow = 1;
			List<User> list = userBeanCl.getUsersByPage(pageNow);
			int pageCount = userBeanCl.getPageCount();
			
			//2.��������
			request.setAttribute("result", list);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow+"");
			
			System.out.println("pageNow==" + pageNow);
			
			request.getRequestDispatcher("wel.jsp").forward(request, response);//ת����Ч�ʸߣ�ͬʱhttp����Ĳ����ȶ��󻹿�������һҲ��ʹ��
			
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
