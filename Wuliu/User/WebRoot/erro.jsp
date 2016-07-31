<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'erro.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style type="text/css">
  body,td,th {
	color: #F00;
}
body {
	background-color: #FCFC41;
}
  </style>
  </head>
  
  <body>
 
   <p><br>
   </p>
   <p>&nbsp; </p>
    <div align="center" ><font size="+6" >操作有誤，無法完成請求</font></div> 
    
   <p><br>
   </p>
   <p>&nbsp; </p>
   <div align="right"> <input name="back_btn" type="button"  value="返回" onclick="location.href='javascript:hietory.go(-1);'">
  </div>
  </body>
</html>
