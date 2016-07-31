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
    
    <title>My JSP 'pro_num_show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript">
function pc_table(obj){
    var pc_id=obj.value;
    alert("您当前要盘点的是物料编号为"+pc_id+"的数目");
	window.location.href="pc_servlet?op="+pc_id;
}
</script>
  </head>
  
  <body>
   <span>库存盘点</span>
   <table border="1" width="800" align="center">
       <tr>
          <th>选择</th>
          <th>仓位编号</th>
          <th>仓位名称</th>
          <th>物料编号</th>
          <th>物料名称</th>
          <th>盘点数目</th>
       </tr>

     <c:forEach items="${requestScope.l}" var="pc" >
       <tr>
          <td><input  type="radio" name="radio"  id="r" value="${pc.pc_pid}" onclick="pc_table(this)"></input></td>
          <td>${pc.pc_sid}</td>
          <td>${pc.pc_sname}</td>
          <td>${pc.pc_pid}</td>
          <td>${pc.pc_pname}</td>
          <td>${pc.pc_num}</td>
       </tr>
       </c:forEach>
     </table>
  </body>
  <body>  

  </body>
</html>
