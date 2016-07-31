<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_pro_rej.jsp' starting page</title>
    
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
	window.location.href="pro_reject_show.jsp";
}
</script>
  </head>
     <span>物料报废</span>
  <body>
      <table align="center" width="600" border="1">
        <tr>
        <td>报废人：</td><td>cangguan</td>
        </tr>
        <tr>
        <td>报废日期</td><td><input type="text"></input></td>
        </tr>
        <tr>
           <td>报废原因：</td><td><textarea></textarea></td>
        </tr>
        <tr>
       <td><br></td>
        <td><input type="button" onclick="redirect()" value="返回"><input type="submit" onclick="redirect()" value="提交" ><td>
        </tr>
      </table>
  </body>
</html>
