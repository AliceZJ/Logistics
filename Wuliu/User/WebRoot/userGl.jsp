<%@page language="java" contentType="text/html; charset=gb18030"
	pageEncoding="GB18030"
	import="java.util.List, java.util.ArrayList,com.admin.gl_v.User_v,com.admin.gl_v.Page1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>�û�����</title>
</head>
<body bgcolor="#E7E7E7">
	<%
		List<User_v> l1 = (ArrayList<User_v>) request.getAttribute("l1");
			//Page1 p = (Page1)request.getAttribute("p");
	%>
	<form action="Btn_optServlet?opt=look_btn" method="post">
		�û�����<input name="c_name" type="text"> <br> <br>
		״̬��&nbsp; <select name="c_state">
			<option value=10>ȫ��</option>
			<option value=1>����</option>
			<option value=0>ɾ��</option>
		</select>&nbsp; 
		<input type="submit" value="��ѯ"> 
    </form>
    
    <br> <br>
		<div align="right">
			<input name="add_btn" type="button" onClick="window.location.href='addUser_v.jsp'" value="����"> <input
				name="back_btn" type="button"  value="����" onclick="location.href='right.jsp'">
		</div>

		<div align="right">
			��<%=session.getAttribute("sum")%>����¼ ÿҳ��ʾ3 �� ��<%=request.getAttribute("currentPage")%>ҳ/��${p.totalPage}ҳ <a
				href="UserinfoServlet?currentPage=1">��ҳ</a> <a
				href="UserinfoServlet?currentPage=${currentPage==1?1:currentPage-1 }">��һҳ</a> <a
				href="UserinfoServlet?currentPage=${currentPage==7?7:currentPage+1 }">��һҳ</a>
			<a href="UserinfoServlet?currentPage=${p.totalPage}">βҳ</a><br><br>
		</div>
        <br>
		<div align="center">
			<table width="561" border="1" cellspacing="10">
				<tr>
					<td>�û����</td>
					<td>�û�����</td>
					<td>�û�����</td>
					<td>�û���ɫ</td>
					<td>�û�״̬</td>
					<td>ѡ�����</td>
				</tr>
				<%for (User_v u : l1) {%>
				<tr>
					<td ><%=u.getUid()%></td>
					<td ><%=u.getUname()%></td>
					<td >*****</td>
					<td ><%=u.getUrole()%></td>
					<td><%=u.getUstate()%></td>
				    <td>
                        <a href="updateUser.jsp?uid=<%=u.getUid()%>">�༭</a> 
					    <a href="Btn_optServlet?opt=del_btn&uid=<%=u.getUid()%>">ɾ��</a>
					</td>
				</tr>
				<%}%>
			</table>
		</div>
</body>
</html>