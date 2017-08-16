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
 * @Description: 用户处理
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: UserManagerSys
 * @author fupengpeng
 * @date 2017年8月16日 下午2:40:33
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
		
		//得到用户希望展示的页面pageNow
		String s_pageNow = (String)request.getParameter("pageNow");
		int pageNow = Integer.parseInt(s_pageNow);
		//1.数据获取
		UserBeanCl userBeanCl = new UserBeanCl();
		List<User> list = userBeanCl.getUsersByPage(pageNow);
		int pageCount = userBeanCl.getPageCount();
		System.out.println("分页的实现----使用UserClServlet");
		//2.设置数据
		request.setAttribute("result", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow+"");
		//3.展示数据
		request.getRequestDispatcher("wel.jsp").forward(request, response);
	

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

}
