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

<title>My JSP 'show-zj1.jsp' starting page</title>

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
采购订单<br>
	<form action="PurServlet?opt=getpurchasebyid" method="post">
		订单编号：<input type="text" name="selid"></input> <input type="submit"></input>
	</form>
	<div>
		<a href="PurServlet?opt=xianshipurchase">新增</a> 
	</div>
	<input type="button" onclick="location.href='javascript:history.go(-1);'" value="返回"/>
	<br>
	共4条记录 
 每页显示3条 
 <a href="PurServlet?opt=getpurchase&currentPageNum=1">首页</a> ｜
 <a href="PurServlet?opt=getpurchase&currentPageNum=${p.currentPageNum==1?1:p.currentPageNum-1 }">上一页</a> ｜ 
 <a href="PurServlet?opt=getpurchase&currentPageNum=${p.currentPageNum==p.totalPage?p.totalPage:p.currentPageNum+1 }">下一页</a> ｜ 
 <a href="PurServlet?opt=getpurchase&currentPageNum=${p.totalPage }">尾页</a>
	<table border="1" width="700">
		<tr>
			<td>采购订单</td>
			<td>供应商</td>
			<td>采购日期</td>
			<td>采购员</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${l }" var="p">
			<tr>
				<td>${p.pur_id}</td>
				<td>${p.pur_com}</td>
				<td>${p.pur_date}</td>
				<td>${p.pur_man}</td>
				<td>${p.pur_status}</td>
				<td><a href="PurServlet?opt=updatepurchase_status&pur_id=${p.pur_id }">修改</a> | <a href="PurServlet?opt=updatepurchase_status&pur_id=${p.pur_id }">删除</a></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>
