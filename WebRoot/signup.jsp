<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'signup.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<style>
	.form-control{
  width:200px;
 display: inline-block;
  }
</style>
  </head>
  
  <body>
   <div class="jumbotron"style="width:100%;height:580px">   <!--  放大     -->
		<div style="text-align: center;">
			<p  class="text-info"style="font:italic bolder 100px '微软雅黑';">Facebook</p>
			<br />
			<br />
			<p class="text-muted"style="font:italic bolder 30px '微软雅黑';">To find friend here!</p>
			<br />
			<br />
			
  
  <form style="display: inline-block;text-align: center;"action="signup"method="post">
  	<table style="text-align: right;">
  		<tr>
  			<td>账户：</td>
  			<td><input type="text"class="form-control" name="account"/></td>
  		</tr>
  		<tr>
  			<td>密码：</td>
  			<td><input type="text"class="form-control"name="password"/></td>
  		</tr>
  		
  		<tr>
  			<td>学号：</td>
  			<td><input type="text"class="form-control"name="number"/></td>
  		</tr>
  		<tr>
  			<td>性别：</td>
  			<td><input type="text"class="form-control"name="sex"/></td>
  		</tr>
  		<tr>
  			<td>年龄：</td>
  			<td><input type="text"class="form-control"name="age"/></td>
  		</tr>
  		<tr>
  			<td>姓名：</td>
  			<td><input type="text"class="form-control"name="name2"/></td>
  		</tr>
  		
  	</table>
  	<button class="btn btn-success">立即注册</button>
  	<%if(request.getAttribute("issignup")==null)
  	   request.setAttribute("issignup","");
  	 %>
  	<div style="color:red">
  	<%=request.getAttribute("issignup").equals("false")?"输入有误，请检查重新输入":"" %>
  	</div>
  </form>
  </div>
  </div>
  </body>
</html>
