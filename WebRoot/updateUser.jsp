<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="pink">
	<!-- 引入图片 -->
	<img src="imgs/t.png">
	<center>
		<br> <br>
		<hr>
		<h1>请输入用户信息</h1>
		<br> <br />
		<form action="UserClServlet?flag=updateUser" method="post">
			<table border="1">
			    <tr bgcolor="silver">
					<td>用户名</td>
					<td><input type="text" name="userid" readonly="readonly" value="<%=request.getParameter("userid") %>"/></td>
				</tr>
				<tr bgcolor="pink">
					<td>用户名</td>
					<td><input type="text" name="username" value="<%=request.getParameter("username") %>"/></td>
				</tr>
				<tr bgcolor="silver">
					<td>密码</td>
					<td><input type="text" name="passwd" value="<%=request.getParameter("passwd") %>"/></td>
				</tr>
				<tr bgcolor="pink">
					<td>电子邮箱地址</td>
					<td><input type="text" name="email" value="<%=request.getParameter("email") %>"/></td>
				</tr>
				<tr bgcolor="silver">
					<td>用户级别</td>
					<td><input type="text" name="grade" value="<%=request.getParameter("grade") %>"/></td>
				</tr>
				<tr bgcolor="pink">
					<td><input type="submit" value="修改用户" /></td>
					<td><input type="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
		<br /> <br /> <br />
		<hr>
		<br /> <br />
	</center>
	<img src="imgs/b.png">
  </body>
</html>
