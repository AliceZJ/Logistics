<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showGoout.jsp' starting page</title>
    
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
   <form action="GooutServlet?opt=getChukubyid" method="post">
		出库单编号：<input type="text" name="chukuid"></input> <input type="submit"></input>
	</form>
	<div>
		<a href="GooutServlet?opt=getinfo">新增</a> 
		<button>返回</button>
	</div>
	<table border="1" width="700">
		<tr>
			<td>出库作业单</td>
			<td>出库时间</td>
			<td>仓管员</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${l }" var="g">
			<tr>
				<td><a href="GooutServlet?opt=showWuliao&goout_id=${g.gt_id_zl }">${g.gt_id_zl }</a></td>
				<td>${g.gt_date_zl }</td>
				<td>${g.cangguan.cg_id_zl }</td>
				<td>${g.ge_state_zl}</td>
				<td><a href="GooutServlet?opt=updateChuku&goout_id=${g.gt_id_zl }">修改</a><a href="GooutServlet?opt=deleteChuku&goout_id=${g.gt_id_zl }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" onclick="location.href='javascript:history.go(-1);'" value="返回"/>
  </body>
</html>
