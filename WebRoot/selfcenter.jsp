<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selfcenter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

<style>

a.module{
  display: block;
  width:280px;
  height:150px;
  margin: 30px;
  margin-top:120px;
  padding:60px;
  background-color: #d9edf7;
  float:left;
  border-radius: 18px;
  position: relative;
  
}

a.module span.moduleNumber{
  position: absolute;
  top: 120px;
  left: 250px;
  color:#BC8F8F;
  background-color: #F5F5DC; 
  border:1px green silver;
}

a.module span.progressBar{
  display:inline-block;
  position: absolute;
  left: 0px;
  top: 170px;  
  width:100%;
}

a.module:hover{
  background-color: #dff0d8;
}


</style>
  </head>
  
  <body>
  <div class="panel panel-success">
		<div class="panel-heading"style="text-align:center"><p style="font:italic bolder 50px '微软雅黑';color:lightblue"><%=request.getParameter("account") %>的个人中心</p></div>
		<div class="panel-body"style="background-color:aliceblue;height:77%">
		
			
			
			
	        <a href="modifyInformation.jsp?account=<%=request.getParameter("account")%>" class="module" class="module">
			      <div style="text-align:center">
                    <span  class="moduleName"style="font: bolder 25px '微软雅黑';color:gray">修改资料</span>
                  </div>
	              <br/>
	              <br/>
	           <span  class="badge moduleNumber pull-right">1</span>
	        </a>
			
			<a href="login.jsp" class="module" class="module">
			      <div style="text-align:center">
                    <span  class="moduleName"style="font: bolder 25px '微软雅黑';color:gray">退出登录</span>
                  </div>
	              <br/>
	              <br/>
	           <span  class="badge moduleNumber pull-right">2</span>
	        </a>
	      
	        
		</div>
		<div class="panel-footer"style="background-color: #dff0d8;text-align:center">
		<span>© 2018-2020 All Rights Reserved</span>
		</div>
	</div>
    
  </body>
</html>
