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
 * Description: 登录处理控制器
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: UserManagerSys
 * @author fupengpeng
 * @date 2017年8月16日 上午11:35:07
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
		//得到用户名和密码
		String u = request.getParameter("username");
		String p = request.getParameter("passwd");
		System.out.println("username = " + u + "    password = " + p);
		UserBeanCl userBeanCl = new UserBeanCl();
		if (userBeanCl.checkUser(u, p)) {
//			response.sendRedirect("wel.jsp");//转向，相比转发效率不是很高
			System.out.println("经过LoginClServlet");
			
			//在跳转到wel。jsp页面时，就把要显示的数据，给wel。jsp准备好
			//1.准备数据
			int pageNow = 1;
			List<User> list = userBeanCl.getUsersByPage(pageNow);
			int pageCount = userBeanCl.getPageCount();
			
			//2.设置数据
			request.setAttribute("result", list);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow+"");
			
			System.out.println("pageNow==" + pageNow);
			
			request.getRequestDispatcher("wel.jsp").forward(request, response);//转发，效率高，同时http请求的参数等对象还可以在下一也面使用
			
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
