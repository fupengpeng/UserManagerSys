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
	return window.confirm("ȷ��Ҫɾ����");
	}
	
	</script>

</head>
<body bgcolor="pink">
	<!-- ����ͼƬ -->
	<img src="imgs/t.png">


	<%
		//��ֹ�û��Ƿ���¼ 
		String u = (String) session.getAttribute("username");
		//����û�û�е�¼��ȴ����Ҫ���ʴ�ҳ�棬
		if (u == null) {
			//�û��Ƿ���¼����ʾ�����ص�¼ҳ��
			response.sendRedirect("login.jsp?error=1");
			return;
		}
	%>
	<center>
		��¼�ɹ�����ϲ�㣡<%=u%> 
		<br>
		<a href="login.jsp">���µ�¼</a>
		<br>
		<br>
		<a href="main.jsp">����������</a>
		<br>
		<hr>
		<br>
		<h1>�û���Ϣ</h1>
		<%
			//int pageNow = 0;
			//String s_pageNow = request.getParameter("pageNow");
			//if (s_pageNow != null) {
			//	pageNow = Integer.parseInt(s_pageNow);
			//}
			//����UserBeanCl�еķ���������һ��UserBeanClʵ����Ȼ���������ĳ�������������з�ҳ
			//UserBeanCl ubc = new UserBeanCl();
			//List al = ubc.getUsersByPage(pageNow); 
			//

			List list = (List) request.getAttribute("result");
		%>
		<table border="1">
			<tr>
				<td>�û�ID</td>
				<td>�û���</td>
				<td>�û�����</td>
				<td>�����ַ</td>
				<td>�û�����</td>
				<td>�޸��û�</td>
				<td>ɾ���û�</td>
			</tr>
			<%
			
			//����һ����ɫ����
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
				<td><a href="updateUser.jsp?userid=<%=ub.getUserId() %>&username=<%=ub.getUsername() %>&passwd=<%=ub.getPasswd()%>&email=<%=ub.getEmail()%>&grade=<%=ub.getGrade()%>">�޸��û�</a></td>
				<td><a onclick="return abc()"  href="UserClServlet?flag=delUser&userId=<%=ub.getUserId() %>">ɾ���û�</a></td>
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
						+ "&flag=fenye>��һҳ</a>");
			}
			int pageCount = (int) request.getAttribute("pageCount");
			for (int i = 1; i <= pageCount; i++) {
				out.println("<a href=UserClServlet?pageNow=" + i + "&flag=fenye>[" + i
						+ "]</a>");
			}
			if (pageNow != pageCount) {
				out.println("<a href=UserClServlet?pageNow=" + (pageNow + 1)
						+ "&flag=fenye>��һҳ</a>");
			}
		%>
		<br>
		<hr>
		<br>
		<img src="imgs/b.png">
	</center>
</body>
</html>
