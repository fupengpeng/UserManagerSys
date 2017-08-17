<%@ page language="java"
	import="java.util.*,java.sql.*,com.jiudianlianxian.model.*"
	pageEncoding="gb2312"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'wel.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	
	function abc(){
	return window.confirm("确定要删除吗？");
	}
	
	</script>

</head>
<body bgcolor="pink">
	<!-- 引入图片 -->
	<img src="imgs/t.png">


	<%
		//防止用户非法登录 
		String u = (String) session.getAttribute("username");
		//如果用户没有登录，却还是要访问此页面，
		if (u == null) {
			//用户非法登录，提示并返回登录页面
			response.sendRedirect("login.jsp?error=1");
			return;
		}
	%>
	<center>
		登录成功！恭喜你！<%=u%> 
		<br>
		<a href="login.jsp">重新登录</a>
		<br>
		<br>
		<a href="main.jsp">返回主界面</a>
		<br>
		<hr>
		<br>
		<h1>用户信息</h1>
		<%
			//int pageNow = 0;
			//String s_pageNow = request.getParameter("pageNow");
			//if (s_pageNow != null) {
			//	pageNow = Integer.parseInt(s_pageNow);
			//}
			//调用UserBeanCl中的方法（创建一个UserBeanCl实例，然后调用它的某个方法），进行分页
			//UserBeanCl ubc = new UserBeanCl();
			//List al = ubc.getUsersByPage(pageNow); 
			//

			List list = (List) request.getAttribute("result");
		%>
		<table border="1">
			<tr>
				<td>用户ID</td>
				<td>用户名</td>
				<td>用户密码</td>
				<td>邮箱地址</td>
				<td>用户级别</td>
				<td>修改用户</td>
				<td>删除用户</td>
			</tr>
			<%
			
			//定义一个颜色数组
			String [] color = {"green","pink"};
				for (int i = 0; i < list.size(); i++) {
					User ub = (User) list.get(i);
			%>
			<tr bgcolor="<%=color[i%2] %>">
				<td><%=ub.getUserId()%></td>
				<td><%=ub.getUsername()%></td>
				<td><%=ub.getPasswd()%></td>
				<td><%=ub.getEmail()%></td>
				<td><%=ub.getGrade()%></td>
				<td><a href="updateUser.jsp?userid=<%=ub.getUserId() %>&username=<%=ub.getUsername() %>&passwd=<%=ub.getPasswd()%>&email=<%=ub.getEmail()%>&grade=<%=ub.getGrade()%>">修改用户</a></td>
				<td><a onclick="return abc()"  href="UserClServlet?flag=delUser&userId=<%=ub.getUserId() %>">删除用户</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<%
			String i_pageNow = (String) request.getAttribute("pageNow");
			System.out.println("pageNow=--=" + i_pageNow);
			int pageNow = Integer.parseInt(i_pageNow);
			System.out.println("pageNow--==" + pageNow);
			if (pageNow != 1) {
				out.println("<a href=UserClServlet?pageNow=" + (pageNow - 1)
						+ "&flag=fenye>上一页</a>");
			}
			int pageCount = (int) request.getAttribute("pageCount");
			for (int i = 1; i <= pageCount; i++) {
				out.println("<a href=UserClServlet?pageNow=" + i + "&flag=fenye>[" + i
						+ "]</a>");
			}
			if (pageNow != pageCount) {
				out.println("<a href=UserClServlet?pageNow=" + (pageNow + 1)
						+ "&flag=fenye>下一页</a>");
			}
		%>
		<br>
		<hr>
		<br>
		<img src="imgs/b.png">
	</center>
</body>
</html>
