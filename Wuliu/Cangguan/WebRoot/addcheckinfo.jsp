<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addcheckinfo.jsp' starting page</title>
    
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
	window.location.href="cangkuzhanshi.jsp";
}
</script>
  </head>
       <table align="center" >
       <tr>
       <td></td>
       <th>仓库检查</th>
       <td></td>
       </tr>
    </table>
       <table border="1" width="600" align="center">
        <tr>
          <th>检查人:</th>
          <td>cangguan</td>
       </tr>
        <tr>
          <th>检查日期:</th>
          <td><input type="text"></input></td>
          
       </tr>
       <tr>
          <th>检查时间:</th>
          <td><input type="text">--<input type="text"></input></td>
       </tr>
       
       </table>
        <table align="center">
        <tr>
       <th>检查内容</th>
       </tr>
        </table>
        <table border="1" width="600" align="center">
        <tr>
          <th>湿度检查:</th>
          <td><input type="text"></input></td>
          
       </tr>
       <tr>
          <th>温度检查:</th>
          <td><input type="text"></input></td>
       </tr>
       <tr>
          <th>卫生检查:</th>
          <td><input type="text"></input></td>
       </tr>
        </table>
        <table align="center">
        <tr>
        <td><input type="submit" onclick="redirect()" value="提交" ></input></td>
        <td><input type="button" onclick="redirect()" value="返回"><td>
       </tr>
       </table>
      </body>
 </html>
