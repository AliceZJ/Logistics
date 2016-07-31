<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>物料公司资料</title>
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
				window.location.href="servlet/change_or_del_gongsi?opt=del&id="+t;
			}
		});
		
		$("input[type=button][name=b_change]").click(function() {
			var tr = $(this).parent().parent();
			var t = tr.find("td").eq(1).text();
			window.location.href="servlet/change_or_del_gongsi?opt=change&id="+t;
		});
	});
</script>
</head>
<body>
	物料公司资料
	<br>
	<hr>
	<form action="" method="post">
		公司编号：<input name="cid" type="text"> <br> <br> 公司名称：<input
			name="cname" type="text">&nbsp; <input
			name="research_user_btn" type="button" onClick="" value="查询">
		<br> <br>
		<div align="right" style="background-color:#9CF">
			<input name="b_add" type="button"
				onclick="window.location.href='servlet/getHangye'" value="新增">

			<a><input name="b_back" type="button" value="返回" onClick="location.href='javascript:history.go(-1);'"> </a>
		</div>
		<br>
		<div align="right"><!-- 
			<a>首页</a>&nbsp; 
			<a>上页</a>&nbsp;
			<a>下页</a>&nbsp; 
			<a>尾页</a>  -->
		</div>
		<br>
		<div>
			<center>
				<table cellspacing="0px" border="1px" bordercolor="#CCCCCC"
					cellpadding="10px">
					<tr bgcolor="#99CCFF">
						<td>选择操作</td>
						<td>公司编号</td>
						<td>公司名称</td>
						<td>公司行业</td>
						<td>成立时间</td>
						<td>法人代表</td>
					</tr>
					<c:forEach items="${l }" var="i">
						<tr>
							<td>
								<input name="b_change" type="button" value="修改">
								 
								<input name="b_del" type="button" value="删除">
								
							</td>
                            
							<td>${i.c_id_hyj}</td>
							<td>${i.c_name_hyj}</td>
							<td>${i.hy.hangye_name_gjh}</td>
							<td>${i.c_time_hyj}</td>
							<td>${i.c_legal_hyj}</td>
						</tr>
					</c:forEach>
				</table>

			</center>
		</div>
	</form>
</body>
</html>
