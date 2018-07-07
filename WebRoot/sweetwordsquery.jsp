<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryfriends.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
  </head>
  <style>
	.form-control{
  width:200px;
 display: inline-block;
  }
</style>
  <body>
   <div class="jumbotron"style="width:100%;height:580px">   <!--  放大     -->
		<div style="text-align: center;">
			<p  class="text-info"style="font:italic bolder 100px '微软雅黑';">Facebook</p>
			<br />
			<br />
			<p class="text-muted"style="font:italic bolder 30px '微软雅黑';">To find friend here!</p>
			<br />
			<br />
			<%if(request.getAttribute("inputisillegal")==null){
			request.setAttribute("inputisillegal","false");
			}
			 %>
	<form action="sweetwordsquery">
           输入用户学号:<input type="text"class="form-control" name="querynumber"/>
           <input type="hidden" name="account" value='<%=request.getParameter("account")%>'/>
           <button class="btn btn-info">蜜语查询</button>
			<div>
			<span style="color:red;font-size:20px;">
			<%=request.getAttribute("inputisillegal").equals("true")?"请输入正确格式学号!":"" %>
			</span>
			</div>
   </form>
  
  </div>
  </div>
   
  </body>
</html>
