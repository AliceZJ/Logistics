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
    
    <title>My JSP 'seat_pro_check.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <script type="text/javascript">
function add_check_info_p(obj){
    var d_id=obj.value;
    //alert(d_id);
	window.location.href="pcservlet?p=d_id";
}
</script>
  <body>
     <form action="pro_check_servlet" method="post" >
  仓位编号：<input type="text" name="d_iid"></input>
       <input type="submit" value="查询"></input>
  </form>
  
  <table border="1" width="600" align="center">
       <tr>
          <th>选择</th>
          <th>仓位编号</th>
          <th>仓位名称</th>
          <th>物料编号</th>
          <th>物料名称</th>
       </tr>

     <c:forEach items="${requestScope.l}" var="sw" >
       <tr>
          <td><input  type="radio" name="radio"  id="r" onclick="add_check_info_p(this)"></input></td>
          <td>${sw.sp_seatid}</td>
          <td>${sw.sp_sname}</td>
          <td>${sw.sp_proid}</td>
          <td>${sw.sp_pname}</td>
       </tr>
       </c:forEach>
     </table>
  </body>
</html>
