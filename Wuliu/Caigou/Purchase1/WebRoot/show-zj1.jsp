<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'show.jsp' starting page</title>

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
采购申请<br>
	<form action="PurServlet?opt=getapplaysbyid" method="post">
		编号：<input type="text" name="selid"></input> <input type="submit"></input>
	</form>
	<div>
		<a href="PurServlet?opt=xianshiapplays">新增</a> 
	</div>
	<br>
	共4条记录 
 每页显示3条 
 <a href="PurServlet?opt=getapplays&currentPageNum=1">首页</a> ｜
 <a href="PurServlet?opt=getapplays&currentPageNum=${p.currentPageNum==1?1:p.currentPageNum-1 }">上一页</a> ｜ 
 <a href="PurServlet?opt=getapplays&currentPageNum=${p.currentPageNum==p.totalPage?p.totalPage:p.currentPageNum+1 }">下一页</a> ｜ 
 <a href="PurServlet?opt=getapplays&currentPageNum=${p.totalPage }">尾页</a>
	<table border="1" width="700">
		<tr>
			<td>采购申请单</td>
			<td>申请日期</td>
			<td>申请人</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${l }" var="a">
			<tr>
				<td>${a.as_id}</td>
				<td>${a.as_date}</td>
				<td>${a.as_man }</td>
				<td><a href="PurServlet?opt=updateapplays&as_id=${a.as_id }">修改</a> | <a href="PurServlet?opt=deleteapplays&as_id=${a.as_id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
