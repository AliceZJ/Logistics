
<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�ֿ���������</title>
<style type="text/css">
input {
	width: 70px
}
</style>
<script language="javascript" src="res/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("input[type=button][name=b_del]").click(function() {
			if (confirm("ȷ��ɾ����")) {
				var tr = $(this).parent().parent();
				tr.remove();
				//��ȡ������ֵ
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
	�ֿ���������
	<br>
	<hr>
	<form action="" method="post">
		�ֿ������ţ�<input name="pid" type="text"> <br>
		<br> �ֿ��������ƣ�<input name="pname" type="text">&nbsp; <input
			name="research_user_btn" type="button" onClick="" value="��ѯ">
		<br> <br>
		<div align="right" style="background-color:#9CF">
			<input name="add_btn" type="button" value="����" onClick="window.location.href='addinfo?opt=3'">  <input
				name="back_btn" type="button" onClick="location.href='javascript:history.go(-1);'" value="����">
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
						<td>ѡ�����</td>
						<td>������</td>
						<td>��������</td>
						<td>�����ֿ�</td>
						<td>�������</td>
					</tr>
					<c:forEach items="${l }" var="i">
						<tr>
							<td>
							<input
				name="b_change" type="button" value="�޸�"> <input
				name="b_del" type="button" value="ɾ��">
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

