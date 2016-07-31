<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>物料管理</title>
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
				window.location.href="delinfo?opt=1&id="+t;
			}
		});
		
		$("input[type=button][name=b_change]").click(function() {
			var tr = $(this).parent().parent();
			var t = tr.find("td").eq(1).text();
			window.location.href="getchangeinfo?opt=1&id="+t;
		});
	});
</script>
</head>
<body>
	物料管理
	<br>
	<hr>
	<form action="" method="post">
		物料编号：<input name="pid" type="text"> <br> <br> 物料名称：<input
			name="pname" type="text">&nbsp; <input
			name="research_user_btn" type="button" onClick="" value="查询">
		<br> <br>
		<div align="right" style="background-color:#9CF">
			<input name="add_btn" type="button" onClick="window.location.href='add_wuliao.jsp'" value="新增"> 
             <input
				name="back_btn" type="button" onClick="location.href='javascript:history.go(-1);'" value="返回">
		</div>
		<br>
		<div align="right"><!-- 
			<a>首页</a>&nbsp; 
			<a>上页</a>&nbsp;
			<a>下页</a>&nbsp; 
			<a>尾页</a> -->
		</div>
		<br>
		<div>
			<center>
				<table cellspacing="0px" border="1px" bordercolor="#CCCCCC"
					cellpadding="10px">
					<tr bgcolor="#99CCFF">
						<td>选择</td>
						<td>编号</td>
						<td>名称</td>
						<td>规格</td>
						<td>重量</td>
						<td>单位</td>
						<td>体积</td>
						<td>数量</td>
					</tr>
					<c:forEach items="${l }" var="i">
						<tr>
							<td>
                            	<input name="b_change" type="button" value="修改">
								 
								<input name="b_del" type="button" value="删除">
								
							</td>
							<td><c:out value="${i.wulaio_id_gjh}"></c:out>
							</td>
							<td><c:out value="${i.wulaio_name_gjh}"></c:out>
							</td>
							<td><c:out value="${i.wulaio_norms_gjh}"></c:out>
							</td>
							<td><c:out value="${i.wulaio_weight_gjh}"></c:out>
							</td>
							<td><c:out value="${i.wulaio_unit_gjh}"></c:out>
							</td>
							<td><c:out value="${i.wulaio_volume_gjh}"></c:out>
							</td>
							<td><c:out value="${i.wulaio_count_gjh}"></c:out>
							</td>
						</tr>
					</c:forEach>
				</table>
			</center>
		</div>
	</form>
</body>
</html>
