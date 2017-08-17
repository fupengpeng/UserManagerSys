<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
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

<title>My JSP 'login.jsp' starting page</title>

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

		<%
			String error = request.getParameter("error");
			if (error != null) {
				if (error.equals("1")) {
					out.println("用户没有正常登录，请登录！");
				}
			}
		%>
		<br> <br>
		<hr>
		<br> <br> <br> 用户登录<br>
		<hr>
		<form action="LoginClServlet" method="post">
			用户名:<input type="text" name="username"><br> <br>
			密&nbsp;&nbsp;码:<input type="password" name="passwd"><br>
			<br> <input type="submit" value="登录"> <input
				type="reset" value="重置">
		</form>
		<br> <br>
		<hr>
		<br> <br>
	</center>

	<img src="imgs/b.png">

</body>
</html>
