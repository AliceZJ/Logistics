<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>仓库管理</title>
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
				window.location.href="delinfo?opt=2&id="+t;
			}
		});
		
		$("input[type=button][name=b_change]").click(function() {
			var tr = $(this).parent().parent();
			var t = tr.find("td").eq(1).text();
			window.location.href="changecangku.jsp";
		});
	});
</script>
</head>
<body><em> 
	仓库管理 
	<br></em>
	<hr>
	<form action="" method="post"><em> 
		仓库编号：<input type="text" name="pid"><br><br> 仓库名称：<input type="text" name="pname">&nbsp; <input type="button" name="research_user_btn" onclick="" value="查询"><br><br></em> 
		
		 
		<div align="right" style="background-color:#9CF">
			<em><input type="button" name="add_btn" value="新增" onclick="window.location.href='addinfo?opt=2'"><input type="button" name="back_btn" onclick="location.href='javascript:history.go(-1);'" value="返回"></em>  
		</div>
		<em><br></em>
		<div align="right"></div>
		<em><br></em>
		<div><center>
			<table cellspacing="0px" border="1px" bordercolor="#CCCCCC"
				cellpadding="10px">
				<tr bgcolor="#99CCFF">
					<td><em>选择操作</em></td>
					<td><em>仓库编号</em></td>
					<td><em>仓库名称</em></td>
					<td><em>仓库面积</em></td>
					<td><em>仓库类型</em></td>
					<td><em>仓库地址</em></td>
				</tr>
				<c:forEach items="${l }" var="i">
					<tr>
						<td>
						<em><input type="button" name="b_change" value="修改"><input type="button" name="b_del" value="删除"></em> 
						</td>
						<td><c:out value="${i.d_id_hyj}"></c:out></td>
						<td><c:out value="${i.d_name_hyj}"></c:out></td>
						<td><c:out value="${i.d_area_hyj}"></c:out></td>
						<td><c:out value="${i.d_type_hyj}"></c:out></td>
						<td><c:out value="${i.d_addr_hyj}"></c:out></td>
					</tr>
				</c:forEach>

			</table>
		</center>
		</div>
	</form>
</body>
</html>
