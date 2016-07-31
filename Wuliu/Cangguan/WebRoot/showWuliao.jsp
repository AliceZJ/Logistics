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
    
    <title>My JSP 'showWuliao.jsp' starting page</title>
    
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
   <table border="1" width="700">
		<tr>
			<td>物料编号</td>
			<td>名称</td>
			<td>规格</td>
			<td>重量</td>
			<td>单位</td>
			<td>安全库存量</td>
		</tr>
		<c:forEach items="${l }" var="w">
			<tr>
				<td>${w.wulaio_id_gjh }</td>
				<td>${w.wulaio_name_gjh }</td>
				<td>${w.wulaio_norms_gjh }</td>
				<td>${w.wulaio_weight_gjh}</td>
				<td>${w.wulaio_unit_gjh}</td>
				<td>${w.wulaio_count_gjh}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" onclick="location.href='javascript:history.go(-1);'" value="返回"/>
  </body>
</html>
