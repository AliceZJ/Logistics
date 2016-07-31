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

<title>公司资料的添加</title>

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
function checkid(){
	var id = document.getElementById("id").value;
	if(null == id||"" == id){
		document.getElementById("show1").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else
		document.getElementById("show1").innerHTML="";
	
}
function checkname(){
	var id = document.getElementById("name").value;
	if(null == id||"" == id){
		document.getElementById("show2").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else{
		document.getElementById("show2").innerHTML="";
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
		document.getElementById("show4").innerHTML="";
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
		document.getElementById("show5").innerHTML="";
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
		document.getElementById("show3").innerHTML="";
		flag=1;
	}
}
function checkall(){
	if(flag == 0){
		return false;
	}
	else
		return true;
}
</script>
</head>

<body>
仓库管理
<hr>
	<br>
	<div style="color:#F00">注：每一项均为必填项！</div>
	<br>
	<div>
		<center>
        <form action="save_addinfo?opt=2" method="post" onsubmit="return checkall();">
			<table border="1" bordercolor="#99CCCC" cellspacing="0"
				cellpadding="5">
				<tr>
					<td>仓库编号</td>
					<td><input name="id" id="id" type="text" style="font-size:16px" onblur="checkid()"></td>
					<td width="200" id="show1">&nbsp;</td>
				</tr>
				<tr>
					<td>仓库名称</td>
					<td><input name="name" id="name" type="text" style="font-size:16px" onblur="checkname()"></td>
					<td width="200" id="show2">&nbsp;</td>

				</tr>
				<tr>
					<td>仓库面积</td>
					<td><input name="name2" id="name2" type="text" style="font-size:16px" onblur="checkname()"></td>
					<td width="200" id="show3">&nbsp;</td>
				</tr>
				<tr>
					<td>仓库类型</td>
					<td><input name="time" id="time" type="text" style="font-size:16px" onblur="checktime()"></td>
					<td width="200" id="show4">&nbsp;</td>
				</tr>
				<tr>
					<td>仓库地址</td>
					<td><input name="legal" id="legal" type="text" style="font-size:16px" onblur="checklegal()"></td>
					<td width="200" id="show5">&nbsp;</td>
				</tr>
                <tr align="center">
                	<td colspan="3">
                    	<input type="submit" value="保存" id="save" onClick="checkall()"> &nbsp; 
                    	<input type="button" value="返回" id="back" onClick="location.href='javascript:history.go(-1);'">
            
                    </td>
                  
                </tr>
			</table>
            </form>
		</center>
		
	</div>
</body>
</html>
