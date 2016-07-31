<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户管理</title>

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
<script type="text/javascript" src="res/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$("input[type=button][name=delete]").click(function(e){
		if(confirm("确定删除？")){
			var tr = $(this).parent().parent();
		    tr.remove();
		    var num = tr.find("td").eq(1).text();
		    window.location.href="cus_deal_servlet?opt=delete&num="+num;
		}			
	});
	
	$("input[type=button][name=edit]").click(function(e){
			var tr = $(this).parent().parent();
		    var num = tr.find("td").eq(1).text();
		    window.location.href="cus_deal_servlet?opt=edit&num="+num;		
	});	
});

</script>
</head>
<body>

	<form action="" method="post">
		客户编号：<input name="cus_id" type="text"> <br> <br>
		客户简称：<input name="cus_short" type="text">&nbsp; &nbsp; <input
			name="research_cus_btn" type="button" onClick="" value="查询">
		<br> <br>
<hr>

		<div align="right">
			<input name="add_btn" type="button"
				onClick="window.location.href='cus_deal_servlet?opt=getHangye'"
				value="增加"> 
				<input name="back_btn" type="button"
				onclick="location.href='javascript:history.go(-1);'" value="返回">
		</div>

		<div align="right">
			<a href="cus_deal_servlet?currentPage=1&opt=manage">首页</a> ｜ <a
				href="cus_deal_servlet?currentPage=${p.currentPageNum==1?1:p.currentPageNum-1 }&opt=manage">上页</a>
			｜ <a
				href="cus_deal_servlet?currentPage=${p.currentPageNum==p.totalPage?p.totalPage:p.currentPageNum+1 }&opt=manage">下页</a>
			｜ <a href="cus_deal_servlet?currentPage=${p.totalPage }&opt=manage">尾页</a>

		</div>
		<div>&nbsp;</div>

		<div>
			<table cellspacing="0px" cellpadding="10px">
				<tr bgcolor="#6699CC">
					<td>选择操作</td>
					<td>客户编号</td>
					<td>客户名称</td>
					<td>客户简称</td>
					<td>所属行业</td>
					<td>联系人</td>
					<td style="border-right-width:0px">信用额度</td>
				</tr>

				<c:forEach items="${l}" var="bt">
					<tr>
						<td><input type="button" value="删除" name="delete"/>
						    <input type="button" value="修改" name="edit"/>
						</td>
						<td><a href="cus_detial_servlet?id=${bt.customer_id}"
							target="right"><c:out value="${bt.customer_id}"></c:out> </a></td>
						<td><c:out value="${bt.customer_name}"></c:out></td>
						<td><c:out value="${bt.customer_short}"></c:out></td>
						<td><c:out value="${bt.hangye.hangye_name_gjh}"></c:out></td>
						<td><c:out value="${bt.customer}"></c:out></td>
						<td style="border-right-width:0px"><c:out
								value="${bt.customer_credit}"></c:out></td>
					</tr>

				</c:forEach>

			</table>

		</div>
	</form>
</body>
</html>