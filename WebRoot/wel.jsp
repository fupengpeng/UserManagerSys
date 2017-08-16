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

</head>
<body>
	<center>
		登陆成功！恭喜你！<%=request.getParameter("uname")%><br> <a
			href="login.jsp">重新登陆</a>
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

            String i_pageNow = (String)request.getAttribute("pageNow");
			System.out.println("pageNow=--=" + i_pageNow);
			int pageNow = Integer.parseInt(i_pageNow);
		    System.out.println("pageNow--==" + pageNow);
			List list = (List) request.getAttribute("result");
		%>
		<table border="1">
			<tr>
				<td>用户ID</td>
				<td>用户名</td>
				<td>用户密码</td>
				<td>用户级别</td>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
					User ub = (User) list.get(i);
			%>
			<tr>
				<td><%=ub.getUserId()%></td>
				<td><%=ub.getUsername()%></td>
				<td><%=ub.getPasswd()%></td>
				<td><%=ub.getGrade()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<%
			
			if (pageNow != 1) {
				out.println("<a href=UserClServlet?pageNow=" + (pageNow - 1)
						+ ">上一页</a>");
			}
			int pageCount = (int) request.getAttribute("pageCount");
			for (int i = 1; i <= pageCount; i++) {
				out.println("<a href=UserClServlet?pageNow=" + i + ">[" + i
						+ "]</a>");
			}
			if (pageNow != pageCount) {
				out.println("<a href=UserClServlet?pageNow=" + (pageNow + 1)
						+ ">下一页</a>");
			}
		%>
	</center>
</body>
</html>
