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
		
		//获取标识值，决定做什么操作
		String flag = request.getParameter("flag");
		UserBeanCl userBeanCl = new UserBeanCl();
		System.out.println("flag = " + flag);
		
		if (flag.equals("fenye")) {
			//得到用户希望展示的页面pageNow
			String s_pageNow = (String)request.getParameter("pageNow");
			int pageNow = Integer.parseInt(s_pageNow);
			//1.数据获取
			List<User> list = userBeanCl.getUsersByPage(pageNow);
			int pageCount = userBeanCl.getPageCount();
			System.out.println("分页的实现----使用UserClServlet");
			//2.设置数据
			request.setAttribute("result", list);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow+"");
			//3.展示数据
			request.getRequestDispatcher("wel.jsp").forward(request, response);
		}else if (flag.equals("delUser")) {
			//去数据库删除用户
			//1.获取要删除掉用户的id
			String userId = request.getParameter("userId");
			if (userBeanCl.delUserById(userId)) {
				request.getRequestDispatcher("suc.jsp").forward(request, response);
				System.out.println("删除成功");
			}else {
				request.getRequestDispatcher("err.jsp").forward(request, response);
				System.out.println("删除失败");
			}
		}else if (flag.equals("addUser")) {
			//去数据库添加用户
			//1.获取要添加的用户信息
			String username = request.getParameter("username");
			String passwd = request.getParameter("passwd");
			String email = request.getParameter("email");
			String grade = request.getParameter("grade");
			System.out.println("username = " + username);
			if (userBeanCl.addUserById(username, passwd, email, grade)) {
				request.getRequestDispatcher("suc.jsp").forward(request, response);
				System.out.println("添加成功");
			}else {
				request.getRequestDispatcher("err.jsp").forward(request, response);
				System.out.println("添加失败");
			}
		}else if (flag.equals("updateUser")) {
			//去数据库添加用户
			//1.获取要添加的用户信息
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String passwd = request.getParameter("passwd");
			String email = request.getParameter("email");
			String grade = request.getParameter("grade");
			System.out.println("username = " + username);
			if (userBeanCl.updateUserById(userid,username, passwd, email, grade)) {
				request.getRequestDispatcher("suc.jsp").forward(request, response);
				System.out.println("修改成功");
			}else {
				request.getRequestDispatcher("err.jsp").forward(request, response);
				System.out.println("修改失败");
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
