<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pro_reject_show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript">
function show_pr_table(){
    //var d_id=obj.value;
    //alert(d_id);
	window.location.href="p_r_servlet";
}
</script>
  </head>
  <span>物料报废</span>
   <table border="1" width="800" align="center">
       <tr>
          <th>选择</th>
          <th>物料编号</th>
          <th>物料名称</th>
          
       </tr>

     <c:forEach items="${requestScope.l}" var="p" >
       <tr>
          <td><input  type="radio" name="radio"  id="r" onclick="show_pr_table()"></input></td>
          <td>${p.wulaio_id_gjh}</td>
          <td>${p.wulaio_name_gjh}</td>
       </tr>
       </c:forEach>
     </table>
  </body>
  <body>
   
  </body>
</html>
