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
		
		//��ȡ��ʶֵ��������ʲô����
		String flag = request.getParameter("flag");
		UserBeanCl userBeanCl = new UserBeanCl();
		System.out.println("flag = " + flag);
		
		if (flag.equals("fenye")) {
			//�õ��û�ϣ��չʾ��ҳ��pageNow
			String s_pageNow = (String)request.getParameter("pageNow");
			int pageNow = Integer.parseInt(s_pageNow);
			//1.���ݻ�ȡ
			List<User> list = userBeanCl.getUsersByPage(pageNow);
			int pageCount = userBeanCl.getPageCount();
			System.out.println("��ҳ��ʵ��----ʹ��UserClServlet");
			//2.��������
			request.setAttribute("result", list);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow+"");
			//3.չʾ����
			request.getRequestDispatcher("wel.jsp").forward(request, response);
		}else if (flag.equals("delUser")) {
			//ȥ���ݿ�ɾ���û�
			//1.��ȡҪɾ�����û���id
			String userId = request.getParameter("userId");
			if (userBeanCl.delUserById(userId)) {
				request.getRequestDispatcher("suc.jsp").forward(request, response);
				System.out.println("ɾ���ɹ�");
			}else {
				request.getRequestDispatcher("err.jsp").forward(request, response);
				System.out.println("ɾ��ʧ��");
			}
		}else if (flag.equals("addUser")) {
			//ȥ���ݿ�����û�
			//1.��ȡҪ��ӵ��û���Ϣ
			String username = request.getParameter("username");
			String passwd = request.getParameter("passwd");
			String email = request.getParameter("email");
			String grade = request.getParameter("grade");
			System.out.println("username = " + username);
			if (userBeanCl.addUserById(username, passwd, email, grade)) {
				request.getRequestDispatcher("suc.jsp").forward(request, response);
				System.out.println("��ӳɹ�");
			}else {
				request.getRequestDispatcher("err.jsp").forward(request, response);
				System.out.println("���ʧ��");
			}
		}else if (flag.equals("updateUser")) {
			//ȥ���ݿ�����û�
			//1.��ȡҪ��ӵ��û���Ϣ
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String passwd = request.getParameter("passwd");
			String email = request.getParameter("email");
			String grade = request.getParameter("grade");
			System.out.println("username = " + username);
			if (userBeanCl.updateUserById(userid,username, passwd, email, grade)) {
				request.getRequestDispatcher("suc.jsp").forward(request, response);
				System.out.println("�޸ĳɹ�");
			}else {
				request.getRequestDispatcher("err.jsp").forward(request, response);
				System.out.println("�޸�ʧ��");
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
