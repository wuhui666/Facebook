<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
			<br />
			<br />
			<%if(request.getAttribute("ispasswordwrong")==null)
			     request.setAttribute("ispasswordwrong", "");
			   
			  if(request.getAttribute("userNotExist")==null)
			     request.setAttribute("userNotExist", "");
			  if(request.getAttribute("issignup")==null)
			     request.setAttribute("issignup", "");
			 %>
			<form action="checklogin"style="display: inline-block;"id="form">
			账户:<input type="text"class="form-control" name="account"id="account"value="<%=request.getParameter("account")==null?"":request.getParameter("account")%>"/>
			<div>
			<span id="passwordsapn"style="color:red"><%=request.getAttribute("userNotExist").equals("true")?"用户不存在":""%></span>
			</div>
			
			密码:<input type="password"class="form-control" name="password"id="password"value="<%=request.getParameter("password")==null?"":request.getParameter("password")%>"/>
			<div>
			<span id="namesapn"style="color:red"><%=request.getAttribute("ispasswordwrong").equals("true")?"密码错误":""%></span>
			</div>
			<button class="btn btn-success btn-lg" id="login"onclick="return check()">login in</button>
			
			</form>
			<form action="signup.jsp"style="">
				<button class="btn btn-info btn-xs"id="signup">sign up</button>
			</form>
			<br>
			<div>
			<%=request.getAttribute("issignup").equals("true")?"注册成功，请登陆！":""%>
			</div>
		</div>
	</div>
	<script>
		$(function(){
			
		});
		function check(){
			var str=document.getElementById("account").value;
			var str2=document.getElementById("password").value;
			if(str.length==0){
				
				alert("账户不能为空！");
				return false;
			}
			else if(str2.length==0){
				alert("密码不能为空！");
				return false;
			}
		}
	</script>
  </body>
</html>
