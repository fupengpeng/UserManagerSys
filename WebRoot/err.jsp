<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'err.jsp' starting page</title>
    
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
		<h1>��ϲ�㣬�����ɹ�</h1>
		<br> <br /> 
		<a href="main.jsp">����������</a><br /><br /> 
		<br /> <br />
		<hr>
		<br /> <br />

	</center>

	<img src="imgs/b.png">

</body>
</html>
