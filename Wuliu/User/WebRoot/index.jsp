<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>物流实验中心管理信息平台</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style type="text/css">
  body {
	background-image: url(picture/hills.jpg);
}
  </style>
  </head>

  <body>
  <div align="center">
  <form action="LoginServlet" method="post">
     用户名：<input name="uname" type="text">
     <br><br><br><br>
     密&nbsp;&nbsp;&nbsp; 码：<input name="upsw" type="password">
       <br><br><br><br>
     <input name="submit" type="submit" value="登陆">
     &nbsp;&nbsp;&nbsp;
     <input name="reset" type="reset" value="重置">
  </form> 
  </div>
  </body>
</html>
