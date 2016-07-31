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
		document.getElementById("show2").innerHTML="ok";
		flag=1;
	}
	
}
function checknorms(){
	var id = document.getElementById("norms").value;
	if(null == id||"" == id){
		document.getElementById("show3").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else{
		document.getElementById("show3").innerHTML="ok";
		flag=1;
	}
	
}
function checkweight(){
	var id = document.getElementById("weight").value;
	if(null == id||"" == id){
		document.getElementById("show4").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else{
		document.getElementById("show4").innerHTML="ok";
		flag=1;
	}
	
}
function checkunit(){
	var id = document.getElementById("unit").value;
	if(null == id||"" == id){
		document.getElementById("show5").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else{
		document.getElementById("show5").innerHTML="ok";
		flag=1;
	}
	
}

function checkvolume(){
	var id = document.getElementById("volume").value;
	if(null == id||"" == id){
		document.getElementById("show6").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else{
		document.getElementById("show6").innerHTML=" ok";
		flag=1;
	}
	
}
function checkcount(){
	var id = document.getElementById("count").value;
	if(null == id||"" == id){
		document.getElementById("show7").innerHTML="<font color='red'>必填，内容不能为空</font>";
		flag=0;
	}
	else{
		document.getElementById("show7").innerHTML="ok";
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
物料管理
<hr>
	<br>
	<div style="color:#F00">注：每一项均为必填项！</div>
	<br>
	<div>
		<center>
        <form action="changeinfo?opt=1" method="post" onsubmit="return checkall();">
			<table border="1" bordercolor="#99CCCC" cellspacing="0"
				cellpadding="5">
				<tr>
					<td>产品编号</td>
					<td><input value="${w.wulaio_id_gjh }" name="id" id="id" type="text" style="font-size:16px background-color:#CCC;" readonly="readonly"></td>
					<td width="200" id="show1">&nbsp;</td>
				</tr>
				<tr>
					<td>产品名称</td>
					<td><input value="${w.wulaio_name_gjh }" name="name" id="name" type="text" style="font-size:16px" onblur="checkname()"></td>
					<td width="200" id="show2">&nbsp;</td>

				</tr>
				<tr>
					<td>规格</td>
					<td><label for="textfield"></label>
				    <input value="${w.wulaio_norms_gjh }" name="norms" id="name2" type="text" style="font-size:16px" onblur="checknorms()"></td>
					<td width="200" id="show3">&nbsp;</td>
				</tr>
				<tr>
					<td>重量</td>
					<td><input value="${w.wulaio_weight_gjh }" name="weight" id="weight" type="text" style="font-size:16px" onblur="checkweight()"></td>
					<td width="200" id="show4">&nbsp;</td>
				</tr>
				<tr>
				  <td>单位</td>
				  <td><input value="${w.wulaio_unit_gjh }" name="unit" id="unit" type="text" style="font-size:16px" onblur="checkunit()"></td>
				  <td id="show5">&nbsp;</td>
			  </tr>
				<tr>
				  <td>体积</td>
				  <td><input value="${w.wulaio_volume_gjh }" name="volume" id="volume" type="text" style="font-size:16px" onblur="checkvolume()"></td>
				  <td id="show6">&nbsp;</td>
			  </tr>
				<tr>
				  <td>物料数量</td>
				  <td><input value="${w.wulaio_count_gjh }" name="count" id="count" type="text" style="font-size:16px" onblur="checkcount()"></td>
				  <td id="show7">&nbsp;</td>
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
