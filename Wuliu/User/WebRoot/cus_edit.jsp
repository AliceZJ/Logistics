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

<title>My JSP 'cus_add.jsp' starting page</title>

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
	border-right-width: 0px;
	width: 100%;
}

table tr td {
	border-right: 1px #000000 solid;
	border-bottom: 1px #000000 solid;
	text-align: center
}

.td1 {
	text-align: right
}

.td2 {
	text-align: center
}

.td3 {
	text-align: left
}
</style>

<script type="text/javascript">
var flag = 1;
	function showmessage1() {
		var td31 = document.getElementById("td31");
		td31.innerHTML = "为必填项，请输入合法信息";
	}
	function showmessage2() {
		var td32 = document.getElementById("td32");
		td32.innerHTML = "为必填项，请输入合法信息";
	}
	function showmessage3() {
		var td33 = document.getElementById("td34");
		td33.innerHTML = "为必填项，请输入合法信息";
	}
	function showmessage4() {
		var td34 = document.getElementById("td35");
		td34.innerHTML = "为必填项，请输入合法信息";
	}
	function showmessage5() {
		var td35 = document.getElementById("td36");
		td35.innerHTML = "为必填项，请输入合法信息";
	}
	function showmessage6() {
		var td36 = document.getElementById("td37");
		td36.innerHTML = "为必填项，请输入合法信息";
	}
	function showmessage7() {
		var td37 = document.getElementById("td38");
		td37.innerHTML = "为必填项，请输入合法信息";
	}
	function comeback1() {
		var td31 = document.getElementById("td31");
		td31.innerHTML = "<font color='red'>*</font>";
		var t1 = document.getElementById("t1");
		if(null == t1.value || t1.value == ""){
			td31.innerHTML = "<font color='red'>必填</font>";
			flag = 0;
		}
	}
	function comeback2() {
		var td32 = document.getElementById("td32");
		td32.innerHTML = "<font color='red'>*</font>";
		var t2 = document.getElementById("t2");
		if(null == t2.value || t2.value == ""){
			td32.innerHTML = "<font color='red'>必填</font>";
			flag = 0;
		}
	}
	function comeback3() {
		var td33 = document.getElementById("td34");
		td33.innerHTML = "<font color='red'>*</font>";
		var t3 = document.getElementById("t3");
		if(null == t3.value || t3.value == ""){
			td33.innerHTML = "<font color='red'>必填</font>";
			flag = 0;
		}
	}
	function comeback4() {
		var td34 = document.getElementById("td35");
		td34.innerHTML = "<font color='red'>*</font>";
		var t4 = document.getElementById("t4");
		if(null == t4.value || t4.value == ""){
			td34.innerHTML = "<font color='red'>必填</font>";
			flag = 0;
		}
	}
	function comeback5() {
		var td35 = document.getElementById("td36");
		td35.innerHTML = "<font color='red'>*</font>";
		var t5 = document.getElementById("t5");
		if(null == t5.value || t5.value == ""){
			td35.innerHTML = "<font color='red'>必填</font>";
			flag = 0;
		}
	}
	function comeback6() {
		var td36 = document.getElementById("td37");
		td36.innerHTML = "<font color='red'>*</font>";
		var t6 = document.getElementById("t6");
		if(null == t6.value || t6.value == ""){
			td36.innerHTML = "<font color='red'>必填</font>";
			flag = 0;
		}
	}
	function comeback7() {
		var td37 = document.getElementById("td38");
		td37.innerHTML = "<font color='red'>*</font>";
		var t7 = document.getElementById("t7");
		if(null == t7.value || t7.value == ""){
			td37.innerHTML = "<font color='red'>必填</font>";
			flag = 0;
		}
	}
	function checkCus() {
		if(flag==1){
			//用户填写正确，可以提交
			return true;
		}
		else
			return false;
	}
</script>
</head>

<body>
	<form action="cus_deal_servlet?opt=realedit" method="post"
		onsubmit="return checkCus();">
		<div align="right">
			<input type="submit" name="save" value="保存修改" /> <input type="button"
				name="back" value="返回"
				onclick="location.href='javascript:history.go(-1);'" />
		</div>
		<div>
			<font color="#FF0000">注：“*”为必填或必选项</font>
		</div>

		<table>
			<tr>
				<td class="td1">客户名称：</td>
				<td class="td2"><input type="text" onfocus="showmessage1()"
					onblur="comeback1()" id="t1" name="t1"
					value="${cst.customer_name }" /></td>
				<td class="td3" id="td31"><font color="#FF0000">*</font></td>
			</tr>
			<tr>
				<td class="td1">客户简称：</td>
				<td class="td2"><input type="text" onfocus="showmessage2()"
					onblur="comeback2()" id="t2" name="t2"
					value="${cst.customer_short}" /></td>
				<td class="td3" id="td32"><font color="#FF0000">*</font></td>
			</tr>
			<tr>
				<td class="td1">所属行业：</td>
				<td class="td2"><select name="hangye">
				<option value="${cst.hangye.hangye_id_gjh }">
								${cst.hangye.hangye_name_gjh}
							</option>
						<c:forEach items="${l }" var="i">
							<option value="${i.hangye_id_gjh }">
								<c:out value="${i.hangye_name_gjh}"></c:out>
							</option>
						</c:forEach>
				</select>
				</td>
				<td class="td3" id="td33"><font color="#FF0000">*</font></td>
			</tr>
			<tr>
				<td class="td1">客户电话：</td>
				<td class="td2"><input type="text" onfocus="showmessage3()"
					onblur="comeback3()" id="t3" name="t3"
					value="${cst.customer_phone}" /></td>
				<td class="td3" id="td34"><font color="#FF0000">*</font></td>
			</tr>
			<tr>
				<td class="td1">联系人：</td>
				<td class="td2"><input type="text" onfocus="showmessage4()"
					onblur="comeback4()" id="t4" name="t4" value="${cst.customer}" />
				</td>
				<td class="td3" id="td35"><font color="#FF0000">*</font></td>
			</tr>
			<tr>
				<td class="td1">电子邮箱：</td>
				<td class="td2"><input type="text" onfocus="showmessage5()"
					onblur="comeback5()" id="t5" name="t5"
					value="${cst.customer_email}" /></td>
				<td class="td3" id="td36"><font color="#FF0000">*</font></td>
			</tr>
			<tr>
				<td class="td1">信用额度：</td>
				<td class="td2"><input type="text" onfocus="showmessage6()"
					onblur="comeback6()" id="t6" name="t6"
					value="${cst.customer_credit}" /></td>
				<td class="td3" id="td37"><font color="#FF0000">*</font></td>
			</tr>
			<tr>
				<td class="td1">客户地址：</td>
				<td class="td2"><input type="text" onfocus="showmessage7()"
					onblur="comeback7()" id="t7" name="t7"
					value="${cst.customer_address}" /></td>
				<td class="td3" id="td38"><font color="#FF0000">*</font></td>
			</tr>
		</table>
	</form>
</body>
</html>
