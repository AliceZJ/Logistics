<%@page language="java" contentType="text/html; charset=gb18030"
	pageEncoding="GB18030"
	import="java.util.List, java.util.ArrayList,com.admin.gl_v.User_v,com.admin.gl_v.Page1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>用户管理</title>
</head>
<body bgcolor="#E7E7E7">
	<%
		List<User_v> l1 = (ArrayList<User_v>) request.getAttribute("l1");
			//Page1 p = (Page1)request.getAttribute("p");
	%>
	<form action="Btn_optServlet?opt=look_btn" method="post">
		用户名：<input name="c_name" type="text"> <br> <br>
		状态：&nbsp; <select name="c_state">
			<option value=10>全部</option>
			<option value=1>正常</option>
			<option value=0>删除</option>
		</select>&nbsp; 
		<input type="submit" value="查询"> 
    </form>
    
    <br> <br>
		<div align="right">
			<input name="add_btn" type="button" onClick="window.location.href='addUser_v.jsp'" value="新增"> <input
				name="back_btn" type="button"  value="返回" onclick="location.href='right.jsp'">
		</div>

		<div align="right">
			共<%=session.getAttribute("sum")%>条记录 每页显示3 条 第<%=request.getAttribute("currentPage")%>页/共${p.totalPage}页 <a
				href="UserinfoServlet?currentPage=1">首页</a> <a
				href="UserinfoServlet?currentPage=${currentPage==1?1:currentPage-1 }">上一页</a> <a
				href="UserinfoServlet?currentPage=${currentPage==7?7:currentPage+1 }">下一页</a>
			<a href="UserinfoServlet?currentPage=${p.totalPage}">尾页</a><br><br>
		</div>
        <br>
		<div align="center">
			<table width="561" border="1" cellspacing="10">
				<tr>
					<td>用户编号</td>
					<td>用户名称</td>
					<td>用户密码</td>
					<td>用户角色</td>
					<td>用户状态</td>
					<td>选择操作</td>
				</tr>
				<%for (User_v u : l1) {%>
				<tr>
					<td ><%=u.getUid()%></td>
					<td ><%=u.getUname()%></td>
					<td >*****</td>
					<td ><%=u.getUrole()%></td>
					<td><%=u.getUstate()%></td>
				    <td>
                        <a href="updateUser.jsp?uid=<%=u.getUid()%>">编辑</a> 
					    <a href="Btn_optServlet?opt=del_btn&uid=<%=u.getUid()%>">删除</a>
					</td>
				</tr>
				<%}%>
			</table>
		</div>
</body>
</html>