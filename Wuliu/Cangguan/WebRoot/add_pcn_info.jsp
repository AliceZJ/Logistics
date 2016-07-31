<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_pcn_info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function redirect(){
	window.location.href="pro_num_show.jsp";
}
</script>
  </head>
  
  <body>
    <span>库存盘点</span>
    <form action="add_pcn_servlet" method="post">
     <table align="center" border="1" width="600">
     <tr>
       <th>盘点人：</th><td>cangguan</td>
     </tr>
      <tr>
          <th>检查日期:</th>
          <td><input type="text"></input></td>
          
       </tr>
       <tr>
          <th>检查时间:</th>
          <td><input type="text">--<input type="text"></input></td>
       </tr>
       <tr><th>盘点数目：</th> <td><input type="text" name="pcn"></input></td></tr>
       <tr>
       <td><br></td>
        <td><input type="button" onclick="redirect()" value="返回"><input type="submit" onclick="redirect()" value="提交" ><td>
        </tr>
    </table>
    </form>
  </body>
</html>
