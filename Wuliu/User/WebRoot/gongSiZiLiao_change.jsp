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

<title>公司资料的修改</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#save,#back {
	width: 100px
}
</style>
<script type="text/javascript">
var flag=0;
function checkname(){
	var id = document.getElementById("name").value;
	if(null == id||"" == id){
		document.getElementById("show2").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else{
		document.getElementById("show2").innerHTML="  ";
		flag=1;
	}
	
}
function checktime(){
	var id = document.getElementById("time").value;
	if(null == id||"" == id){
		document.getElementById("show4").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else{
		document.getElementById("show4").innerHTML="  ";
		flag=1;
	}
	
}
function checklegal(){
	var id = document.getElementById("legal").value;
	if(null == id||"" == id){
		document.getElementById("show5").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else{
		document.getElementById("show5").innerHTML="  ";
		flag=1;
	}
	
}
function checkhy(){
	var hy = document.getElementById("hangye").value;
	if(0 == hy){
		document.getElementById("show3").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else{
		document.getElementById("show3").innerHTML="  ";
		flag=1;
	}
}
function checkall(){
	if(flag == 0){
		return false;
	}
	else{
		return true;
	}
}
</script>
</head>

<body>
	物流公司资料
	<hr>
	<br>
	<div style="color:#F00">注：每一项均为必填项！</div>
	<br>
	<div>
		<center>
        <form action="servlet/saveChange" method="post" onsubmit="return checkall();">
			<table border="1" bordercolor="#99CCCC" cellspacing="0"
				cellpadding="5">
				<tr>
					<td>公司编号：</td>
					<td><input name="id" id="id" type="text" style=" background-color:#CCC;font-size:16px"
					 value="${c.c_id_hyj }" readonly></td>
					<td width="200" id="show1">&nbsp;公司编号不能修改</td>
				</tr>
				<tr>
					<td>公司名称</td>
					<td><input value="${c.c_name_hyj }" name="name" id="name" type="text" style="font-size:16px" onblur="checkname()"></td>
					<td width="200" id="show2">&nbsp;</td>

				</tr>
				<tr>
					<td>所属行业</td>
					<td><select name="hangye" style="width:190" id="hangye" onblur="checkhy()">
							<option value="${c.hy.hangye_id_gjh}">${c.hy.hangye_name_gjh }</option>
							<c:forEach items="${l }" var="i">
								<option value="${i.hangye_id_gjh }">
								<c:out value="${i.hangye_name_gjh}"></c:out>
								</option>
							</c:forEach>

					</select></td>
					<td width="200" id="show3">&nbsp;</td>
				</tr>
				<tr>
					<td>成立时间</td>
					<td><input value="${c.c_time_hyj}" name="time" id="time" type="text" style="font-size:16px" onblur="checktime()"></td>
					<td width="200" id="show4">&nbsp;</td>
				</tr>
				<tr>
					<td>法人代表</td>
					<td><input value="${c.c_legal_hyj}" name="legal" id="legal" type="text" style="font-size:16px" onblur="checklegal()"></td>
					<td width="200" id="show5">&nbsp;</td>
				</tr>
                <tr align="center">
                	<td colspan="3">
                    	<input type="submit" value="保存修改" id="save" onClick="checkall()"> &nbsp; 
                    	<input type="button" value="返回" id="back" onClick="location.href='javascript:history.go(-1);'">
            
                    </td>
                  
                </tr>
			</table>
            </form>
		</center>
		
	</div>
</body>
</html>
