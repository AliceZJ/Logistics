<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
function $(id){
  return document.getElementById(id);
}
function yz1(){
        var name = $("uid").value;
        var s = $("o");
		if(null==name || name == ""){
			s.innerHTML = "<font color='red'>用户id必填</font>";
			return false;
		}else s.innerHTML = " ";
		return true;
}
function yz2(){
        var name = $("uname").value;
        var s = $("tw");
		if(null==name || name == ""){
			s.innerHTML = "<font color='red'>姓名必填</font>";
			return false;
		}else s.innerHTML = " ";
		return true;
}
function yz3(){
        var name = $("uroleid").value;
        var s = $("th");
		if(null==name || name == ""){
			s.innerHTML = "<font color='red'>角色id必填</font>";
			return false;
		}else s.innerHTML = " ";
		return true;
}
function yz(){
		if(yz1()&&yz2()&&yz3()){		
		return true;
		}else return false;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
body {
	background-color: #E7E7E7;
}
</style>
</head>
<body>
	<a href="UserinfoServlet?currentPage=1">返回</a>

	<form
		action="Btn_optServlet?opt=update_btn&uid=<%=request.getParameter("uid")%>"
		 onsubmit="return yz();" method="post">
		<br> 用户id：<input id="uid" name="uid" type="text" onblur="yz1()"><span
			id="o"></span> <br>
		<br> 用户名称：<input id="uname" name="uname" type="text"
			onblur="yz2()"><span id="tw"></span><br> <br> 用户角色：
		<input id="uroleid" name="uroleid" type="text" onblur="yz3()"><span id="th"></span>请输入代码：1000
		1001 1004 <br>
		<div align="center">
			<input type="submit" value="提交"> <input type="reset"
				value="重置">
		</div>
	</form>
</body>
</html>