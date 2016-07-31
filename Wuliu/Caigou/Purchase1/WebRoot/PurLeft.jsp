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

<title>My JSP 'left.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
<style type="text/css">
body {
	background-color: #CCC
}

ul li {
	margin-left:-40px;
	list-style-type: none;
	text-align: center
}
#a0,#a1,#a2,#a3{
	font-size:18px;
	font-weight:bolder
}
</style>

<script language="javascript" src="res/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		var $li1 = $("#data1 li:gt(0)");
		$li1.hide();
		$("#a1").click(function() {
			if ($li1.is(":hidden")) {
				$li1.show();
			} else {
				$li1.hide();
			}
		});
	});
</script>
</head>

<body>
	<table cellpadding="10px" cellspacing="20px">
		<tr>
			<td bgcolor="#9999FF" id="a0">我的工作</td>
		</tr>
		<tr>
			<td bgcolor="#FFCC99">
				<ul id="data1">
					<li><a href="right1.jsp" target="right" id="a1">采购管理</a></li>
					<li><a href="PurServlet?opt=getapplays&currentPageNum=1" target="right">采购申请</a></li>
					<li><a href="PurServlet?opt=getpurchase&currentPageNum=1" target="right">采购订单</a></li>
					<li><a href="PurServlet?opt=getpurchase_send&currentPageNum=1" target="right">订单发送</a></li>
					<li><a href="PurServlet?opt=getpurchase_receive&currentPageNum=1" target="right">订单接收</a></li>
					<li><a>到货接收</a></li>
					<li><a>到货处理</a></li>
				</ul>
			</td>
		</tr>
		<tr>
			<td>图片</td>
		</tr>
	</table>
</body>
</html>