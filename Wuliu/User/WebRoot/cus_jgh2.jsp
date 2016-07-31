<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户管理</title>

<style type="text/css">
table{
	border:0.5px #000000 solid;
	width: 100%;
}
table td{
	border-right:0.5px #000000 solid;
	text-align:center
}
</style>

</head>
<body>

<form action="" method="post">
  订单编号：<input name="cus_id" type="text">   
  <br><br>
  客户名称：<input name="cus_short" type="text">&nbsp;    
  &nbsp; 
  <input name="research_cus_btn" type="button" onClick="" value="查询">
  <br> <br>
  
  
  <div align="right">
  <input name="add_btn" type="button" onClick="" value="新增">
  <input name="edit_btn" type="button" onClick="" value="修改">
  <input name="back_btn" type="button" onClick="" value="返回">
  </div>
  
  <div align="right">
      <a>首页</a>|<a>上页</a>|<a>下页</a>|<a>尾页</a> 
       <input name="back_btn" type="button" onClick="" value="转到">
  </div>
  <div>&nbsp;</div>
  
  <div>
      <table cellspacing="0px" cellpadding="10px">
  <tr>
    <td>选择操作</td>
    <td>订单编号</td>
    <td>客户名称</td>
    <td>订单类型</td>
    <td>订单报关</td>
    <td>付款方式</td>
    <td>订单状态</td>
    <td>订单日期</td>
    <td>提货日期</td>
    <td style="border-right-width:0px">联系人</td>
  </tr>
  
</table>

  </div>
</form>
</body>
</html>