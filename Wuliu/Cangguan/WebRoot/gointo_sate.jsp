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
    
    <title>My JSP 'gointo_sate.jsp' starting page</title>
    
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
    <form action="GointoServlet?opt=getRukubyid" method="post">
		入库单编号：<input type="text" name="rukuid"></input> <input type="submit"></input>
	</form>
	<table border="1" width="700">
		<tr>
			<td>入库作业单</td>
			<td>仓管人员</td>
			<td>入库状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${l }" var="g">
			<tr>
				<td><a href="GointoServlet?opt=showWuliao&go_id=${g.go_id_zl }">${g.go_id_zl }</a></td>
				<td>${g.cangguan.cg_id_zl }</td>
				<td>${g.go_state}</td>
				<td><a href="GointoServlet?opt=updateRukustate&go_id=${g.go_id_zl }">入库确认</a></td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" onclick="location.href='javascript:history.go(-1);'" value="返回"/>
</body>
</html>
