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
table {
	border: 1px #000000 solid;
	border-bottom-width: 0px;
	width: 100%;
}

table tr td {
	border-right: 1px #000000 solid;
	border-bottom: 1px #000000 solid;
	text-align: center
}
</style>
</head>

<body>
	<div align="right">
		<input type="button" name="back" value="返回"
			onclick="location.href='javascript:history.go(-1);'" />
	</div>
	<div>&nbsp;</div>
	<div>
		<table cellspacing="0px" cellpadding="10px">
			<tr bgcolor="#6699CC">
				<td>订单编号</td>
				<td>客户名称</td>
				<td>订单日期</td>
				<td>提货日期</td>
				<td>订单类型</td>
				<td>报关方式</td>
				<td>提货方式</td>
				<td>付款方式</td>
				<td>订单状态</td>
				<td>联系人</td>
				<td>收货地址</td>
				<td style="border-right-width:0px">订单备注</td>
			</tr>
			<c:forEach items="${l}" var="bt">
				<tr>
					<td><c:out value="${bt.order_id}"></c:out>
					</td>
					<td><c:out value="${bt.customer.customer_name}"></c:out></td>
					<td><c:out value="${bt.order_date}"></c:out></td>
					<td><c:out value="${bt.tihuo_date}"></c:out></td>
					<td><c:out value="${bt.order_type}"></c:out></td>
					<td><c:out value="${bt.order_baoguan}"></c:out></td>
					<td><c:out value="${bt.tihuo_type}"></c:out></td>
					<td><c:out value="${bt.pay_type}"></c:out></td>
					<td><c:out value="${bt.order_status}"></c:out></td>
					<td><c:out value="${bt.luru_man}"></c:out></td>
					<td><c:out value="${bt.out_address}"></c:out></td>
					<td style="border-right-width:0px"><c:out
							value="${bt.order_beizhu}"></c:out></td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<div>&nbsp;</div>
	<hr>
	<div>&nbsp;</div>
	<div>
	<table cellspacing="0px" cellpadding="10px">
			<tr bgcolor="#6699CC">
				<td>物料编号</td>
				<td>物料名称</td>
				<td>物料规格</td>
				<td>物料重量</td>
				<td>物料单位</td>
				<td style="border-right-width:0px">物料数量</td>
			</tr>
			<c:forEach items="${l1}" var="bt">
				<tr>
					<td><c:out value="${bt.wulaio_id_gjh}"></c:out></td>
					<td><c:out value="${bt.wulaio_name_gjh}"></c:out></td>
					<td><c:out value="${bt.wulaio_norms_gjh}"></c:out></td>
					<td><c:out value="${bt.wulaio_weight_gjh}"></c:out></td>
					<td><c:out value="${bt.wulaio_unit_gjh}"></c:out></td>
					<td style="border-right-width:0px"><c:out
							value="${bt.wulaio_count_gjh}"></c:out></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>
