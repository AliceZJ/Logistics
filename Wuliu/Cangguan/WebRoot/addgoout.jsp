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
    
    <title>My JSP 'addgoout.jsp' starting page</title>
    
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
   <form action="GooutServlet?opt=${requestScope.opt}" method="post">
    <table width="400" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" align="center">入库单操作页面</td>
    </tr>
  <tr>
    <td align="center">入库单编号:</td>
    <td align="center"><input type="text" name="gt_id" id="gt_id" value=""></td>
  </tr>
 <tr>
    <td align="center">入库时间</td>
    <td align="center"><input type="text" name="gt_date" id="gt_date" value=""></td>
  </tr>
  <tr>
    <td align="center">入库状态</td>
    <td align="center"><input type="text" name="gt_state" id="gt_state" value=""></td>
  </tr>
  <tr>
    <td align="center">仓管id：</td>
    <td align="center"><select name="cg_id" id="cg_id">
    <c:forEach  items="${requestScope.cg_l }" var="cg">
    	<option value="${cg.cg_id_zl }">${cg.cg_name_zl }</option>
    </c:forEach>
    </select></td>
  </tr>
   <tr>
    <td align="center">订单id:</td>
    <td align="center"><select name="dd_id" id="dd_id">
    <c:forEach  items="${requestScope.dd_l }" var="dd">
    	<option value="${dd.order_id }">${dd.order_id }</option>
    </c:forEach>
    </select></td>
  </tr>
  <td align="center">仓位id:</td>
    <td align="center"><select name="cw_id" id="cw_id">
    <c:forEach  items="${requestScope.cw_l }" var="cw">
    	<option value="${cw.s_id_hyj }">${cw.s_name_hyj }</option>
    </c:forEach>
    </select></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input type="submit" name="button" id="button" value="提交">
      &nbsp; &nbsp; &nbsp; <input type="reset" name="button2" id="button2" value="重置"></td>
    </tr>
</table>
  </form>
  <input type="button" onclick="location.href='javascript:history.go(-1);'" value="返回"/>
  </body>
</html>
