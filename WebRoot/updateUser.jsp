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
	<!-- ����ͼƬ -->
	<img src="imgs/t.png">
	<center>
		<br> <br>
		<hr>
		<h1>�������û���Ϣ</h1>
		<br> <br />
		<form action="UserClServlet?flag=updateUser" method="post">
			<table border="1">
			    <tr bgcolor="silver">
					<td>�û���</td>
					<td><input type="text" name="userid" readonly="readonly" value="<%=request.getParameter("userid") %>"/></td>
				</tr>
				<tr bgcolor="pink">
					<td>�û���</td>
					<td><input type="text" name="username" value="<%=request.getParameter("username") %>"/></td>
				</tr>
				<tr bgcolor="silver">
					<td>����</td>
					<td><input type="text" name="passwd" value="<%=request.getParameter("passwd") %>"/></td>
				</tr>
				<tr bgcolor="pink">
					<td>���������ַ</td>
					<td><input type="text" name="email" value="<%=request.getParameter("email") %>"/></td>
				</tr>
				<tr bgcolor="silver">
					<td>�û�����</td>
					<td><input type="text" name="grade" value="<%=request.getParameter("grade") %>"/></td>
				</tr>
				<tr bgcolor="pink">
					<td><input type="submit" value="�޸��û�" /></td>
					<td><input type="reset" value="����" /></td>
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
