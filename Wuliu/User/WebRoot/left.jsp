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
	background-color: #CCC
}

ul li {
	margin-left: -40px;
	list-style-type: none;
	text-align: center
}

#a0,#a1,#a2,#a3 {
	font-size: 18px;
	font-weight: bolder
}
</style>

<script language="javascript" src="res/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		var $li1 = $("#data1 li:gt(0)");
		var $li2 = $("#data2 li:gt(0)");
		var $li3 = $("#data3 li:gt(0)");
		$li1.hide();
		$li2.hide();
		$li3.hide();
		$("#a1").click(function() {
			if (!$li2.is(":hidden") || !$li3.is(":hidden")) {
				$li2.hide();
				$li3.hide();
			}
			if ($li1.is(":hidden")) {
				$li1.show();
			} else {
				$li1.hide();
			}
		});
		$("#a2").click(function() {
			if (!$li1.is(":hidden") || !$li3.is(":hidden")) {
				$li1.hide();
				$li3.hide();
			}
			if ($li2.is(":hidden")) {
				$li2.show();
			} else {
				$li2.hide();
			}
		});
		$("#a3").click(function() {
			if (!$li2.is(":hidden") || !$li1.is(":hidden")) {
				$li2.hide();
				$li1.hide();
			}
			if ($li3.is(":hidden")) {
				$li3.show();
			} else {
				$li3.hide();
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
					<li><a href="right1.jsp" target="right" id="a1">情景数据</a>
					</li>
					<li><a href="hangYeJieShao_hyj.jsp" target="right">行业介绍</a>
					</li>
					<li><a href="gongSiZiLiaoSL_hyj" target="right">物料公司资料</a>
					</li>
					<li><a href="wuLiaoGuanLiSL_hyj" target="right">物料管理</a>
					</li>
					<li><a href="cangKuGuanLiSL_hyj" target="right">仓库管理</a>
					</li>
					<li><a href="quYuZiLiaoSL_hyj" target="right">区域资料</a>
					</li>
					<li><a href="cangWeiZiLiaoSL_hyj" target="right">仓位资料</a>
					</li>
				</ul></td>
		</tr>
		<tr>
			<td bgcolor="white">
				<ul id="data2">
					<li><a href="right2.jsp" target="right" id="a2">客户服务</a>
					</li>
					<li><a href="cus_deal_servlet?currentPage=1&opt=manage"
						target="right">客户管理</a>
					</li>
					<li><a href="order_deal_servlet?currentPage=1&opt=manage"
						target="right">订单录入</a>
					</li>
					<li><a href="order_rece_servlet?currentPage=1&opt=manage"
						target="right">订单接收</a>
					</li>
					<li><a href="order_handle_servlet?currentPage=1&opt=manage"
						target="right">订单处理</a>
					</li>
					<li><a href="cus_rece_servlet?currentPage=1&opt=manage"
						target="right">客户签收</a>
					</li>
				</ul></td>
		</tr>
		<tr>
			<td bgcolor="#FF9999">
				<ul id="data3">
					<li><a href="UserinfoServlet?currentPage=1" target="right"
						id="a3">权限管理</a>
					</li>
					<li><a>用户管理</a>
					</li>

				</ul></td>
		</tr>
		<tr>
			<td>图片</td>
		</tr>
	</table>
</body>
</html>
