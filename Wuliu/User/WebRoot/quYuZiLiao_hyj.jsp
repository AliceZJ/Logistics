
<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>仓库区域资料</title>
<style type="text/css">
input {
	width: 70px
}
</style>
<script language="javascript" src="res/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("input[type=button][name=b_del]").click(function() {
			if (confirm("确定删除？")) {
				var tr = $(this).parent().parent();
				tr.remove();
				//获取主键的值
				var t = tr.find("td").eq(1).text();
				window.location.href="delinfo?opt=3&id="+t;
			}
		});
		
		$("input[type=button][name=b_change]").click(function() {
			var tr = $(this).parent().parent();
			var t = tr.find("td").eq(1).text();
			window.location.href="changequyu.jsp";
		});
	});
</script>
</head>
<body>
	仓库区域资料
	<br>
	<hr>
	<form action="" method="post">
		仓库区域编号：<input name="pid" type="text"> <br>
		<br> 仓库区域名称：<input name="pname" type="text">&nbsp; <input
			name="research_user_btn" type="button" onClick="" value="查询">
		<br> <br>
		<div align="right" style="background-color:#9CF">
			<input name="add_btn" type="button" value="新增" onClick="window.location.href='addinfo?opt=3'">  <input
				name="back_btn" type="button" onClick="location.href='javascript:history.go(-1);'" value="返回">
		</div>
		<br>
		<div align="right">
			
		</div>
		<br>
		<div>
			<center>
				<table cellspacing="0px" border="1px" bordercolor="#CCCCCC"
					cellpadding="10px">
					<tr bgcolor="#99CCFF">
						<td>选择操作</td>
						<td>区域编号</td>
						<td>区域名称</td>
						<td>所属仓库</td>
						<td>区域面积</td>
					</tr>
					<c:forEach items="${l }" var="i">
						<tr>
							<td>
							<input
				name="b_change" type="button" value="修改"> <input
				name="b_del" type="button" value="删除">
							</td>
							<td><c:out value="${i.r_id_hyj}"></c:out>
							</td>
							<td><c:out value="${i.r_name_hyj}"></c:out>
							</td>
							<td><c:out value="${i.depot.d_name_hyj}"></c:out>
							</td>
							<td><c:out value="${i.r_area_hyj}"></c:out>
							</td>
						</tr>
					</c:forEach>
				</table>
			</center>
		</div>
	</form>
</body>
</html>

