<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editRuku.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
   <form action="PurServlet?opt=${requestScope.opt}" method="post">
    <c:forEach  items="${l }" var="a">
    <table width="400" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" align="center">入库单操作页面</td>
    </tr>
  <tr>
    <td align="center">采购申请编号:</td>
    <td align="center"><input type="text" name="as_id" id="as_id" value=""></td>
  </tr>
  <tr>
    <td align="center">申请日期:</td>
    <td align="center"><input type="text" name="as_date" id="as_date" value=""></td>
  </tr>
  <tr>
    <td align="center">申请人:</td>
    <td align="center"><input type="text" name="as_man" id="as_man" value=""></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input type="submit" name="button" id="button" value="提交">
      &nbsp; &nbsp; &nbsp; <input type="reset" name="button2" id="button2" value="重置"></td>
    </tr>
</table>
</c:forEach>
  </form>
  </body>
</html>
