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

<title>My JSP 'cus_detial_gjh.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table{
  border: 1px #000000 solid;
  border-bottom-width: 0px;
  width: 100%;
}
table tr td{
  border-right: 1px #000000 solid;
  border-bottom: 1px #000000 solid;
  text-align: center
}
</style>
</head>

<body>
  <div align="right"><input type="button" name="back" value="返回" onclick="location.href='javascript:history.go(-1);'"/></div>
  <div>&nbsp;</div>
	<table cellspacing="0px" cellpadding="10px">
		<tr bgcolor="#6699CC">
			<td>客户编号</td>
			<td>客户名称</td>
			<td>客户简称</td>
			<td>所属行业</td>
			<td>客户地址</td>
			<td>联系人</td>
			<td>客户电话</td>
			<td>电子邮箱</td>
			<td style="border-right-width:0px">信用额度</td>
		</tr>
		<c:forEach items="${l}" var="bt">
			<tr>
				<td><c:out value="${bt.customer_id}"></c:out></td>
				<td><c:out value="${bt.customer_name}"></c:out></td>
				<td><c:out value="${bt.customer_short}"></c:out></td>
				<td><c:out value="${bt.hangye.hangye_id_gjh}"></c:out></td>
				<td><c:out value="${bt.customer_address}"></c:out></td>
				<td><c:out value="${bt.customer}"></c:out></td>
				<td><c:out value="${bt.customer_phone}"></c:out></td>
				<td><c:out value="${bt.customer_email}"></c:out></td>
				<td style="border-right-width:0px"><c:out value="${bt.customer_credit}"></c:out></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>
