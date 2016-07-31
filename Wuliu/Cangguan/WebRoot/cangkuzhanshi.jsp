<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script language="javascript" src="res/jquery-1.7.2.js"></script>
 <script type="text/javascript">
function add_check_info(obj){
    var d_id=obj.value;
    //alert(d_id);
	window.location.href="dcservelt?p=d_id";
}
</script>

    <base href="<%=basePath%>">
    
    <title>My JSP 'cangkuzhanshi.jsp' starting page</title>
    
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
  <form action="depotservlet" method="post" >
  仓库编号：<input type="text" name="d_iid"></input>
       <input type="submit" value="查询"></input>
  </form>
      
     <table border="1" width="600" align="center">
       <tr>
          <th>选择</th>
          <th>仓库编号</th>
          <th>仓库名称</th>
          <th>仓库地址</th>
       </tr>

     <c:forEach items="${requestScope.l}" var="d" >
       <tr>
          <td><input  type="radio" name="radio" value="${d.d_id_hyj}" id="r" onclick="add_check_info(this)"></input></td>
          <td>${d.d_id_hyj}</td>
          <td>${d.d_name_hyj}</td>
          <td>${d.d_addr_hyj} </td>
       </tr>
       </c:forEach>
     </table>
  </body>
</html>
