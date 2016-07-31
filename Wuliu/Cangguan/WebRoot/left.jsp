<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		var $li2 = $("#data2 li:gt(0)");
		var $li3 = $("#data3 li:gt(0)");
		var $li4 = $("#data4 li:gt(0)");
		$li1.hide();
		$li2.hide();
		$li3.hide();
		$li4.hide();
		$("#a1").click(function() {
			if(!$li2.is(":hidden") || !$li3.is(":hidden")||!$li4.is(":hidden")){
			$li2.hide();
			$li3.hide();
			$li4.hide();
			}
			if ($li1.is(":hidden")) {
				$li1.show();
			} else {
				$li1.hide();
			}
		});
		$("#a2").click(function() {
			if(!$li1.is(":hidden") || !$li3.is(":hidden")||!$li4.is(":hidden")){
			$li1.hide();
			$li3.hide();
			$li4.hide();
			}
			if ($li2.is(":hidden")) {
				$li2.show();
			} else {
				$li2.hide();
			}
		});
		$("#a3").click(function() {
			if(!$li2.is(":hidden") || !$li1.is(":hidden")||!$li4.is(":hidden")){
			$li2.hide();
			$li1.hide();
			$li4.hide();
			}
			if ($li3.is(":hidden")) {
				$li3.show();
			} else {
				$li3.hide();
			}
		});
		$("#a4").click(function() {
			if(!$li1.is(":hidden") || !$li2.is(":hidden")||!$li3.is(":hidden")){
			$li1.hide();
			$li2.hide();
			$li3.hide();
			}
			if ($li4.is(":hidden")) {
				$li4.show();
			} else {
				$li4.hide();
			}
		});
	});
</script>
</head>

<body>
	<table cellpadding="10px" cellspacing="20px" bgcolor="#F4BDEE" >
		<tr>
			<td  id="a0">我的工作</td>
		</tr>
		<tr>
			<td >
				<ul id="data1">
					<li><a href="right.jsp" target="right" id="a1">入库管理</a></li>
					<li><a href="GointoServlet?opt=getRuku" target="right">入库接单</a></li>
					<li><a href="GointoServlet?opt=rukustate" target="right">入库确认</a></li>
				</ul>
			</td>
		</tr>
		<tr>
			<td >
            <ul id="data2">
                    <li><a href="right2.jsp" target="right" id="a2">出库管理</a></li>
					<li><a href="GooutServlet?opt=getChuku" target="right">出库接单</a></li>
					<li><a href="GooutServlet?opt=getChukustate"  target="right">出库确认</a></li>
				</ul>
			</td>
		</tr>
		<tr>
			<td >
            <ul id="data3">
                    <li><a href="right3.jsp" target="right" id="a3">越库管理</a></li>
					<li><a>越库发货</a></li>
					<li><a>出库管理</a></li>
				</ul>
			</td>
		</tr>
		<tr>
			<td >
            <ul id="data4">
                    <li><a href="right4.jsp" target="right" id="a4">库存管理</a></li>
					<li><a href="cangguan_index.jsp" target="right" >仓库检查</a></li>
					<li><a href="pro_check_index.jsp" target="right">物料检查</a></li>
					<li><a href="pro_reject_index.jsp" target="right">物料报废</a></li>
					<li><a href="pro_num_che_index.jsp" target="right">库存盘点</a></li>
				</ul>
			</td>
		</tr>
	</table>
</body>
</html>
