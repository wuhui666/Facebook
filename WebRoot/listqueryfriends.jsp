<%@ page language="java" import="java.util.*,Bean.*,dao.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listfriend.jsp' starting page</title>
    
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
    button{
    margin-right:8%;
     margin-left:8%;
     margin-top:10px;
   
    }
    </style>
  <body>
  
  <div class="panel panel-success">
		<div class="panel-heading"style="text-align:center"><p style="font:italic bolder 50px '微软雅黑';color:lightblue"><%=request.getParameter("account") %>的个人中心</p></div>
		<div class="panel-body"style="background-color:aliceblue;height:73%;margin-bottom:0px;">
		<div >
			<span class="text-muted"style="font:italic bolder 30px '微软雅黑';">
			该用户的好友如下：
			</span>
	    </div>
    <table style="text-align:center" border='0' cellspacing='0'class="table table-striped">
    <tr>
        <td>账户名</td>
        <td>学号</td>
        <td>性别</td>
        <td>姓名</td>
        <td>年龄</td>
       
    </tr>
    
    <c:forEach items="${users}" var="user" varStatus="st">
        <tr>
            <td>${user.account}</td>
            
            <td>${user.number}</td>
            <td>${user.sex}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            
        </tr>
    </c:forEach>
    <tr>
    <td colspan='5'>
    <a href="listqueryfriends?start=0&account=<%=request.getParameter("account")%>&querynumber=<%=request.getParameter("querynumber")%>"><button class="btn btn-default">首页</button></a>
    <a href="listqueryfriends?start=${pre}&account=<%=request.getParameter("account")%>&querynumber=<%=request.getParameter("querynumber")%>"><button class="btn btn-default">上一页</button></a>
    <a href="listqueryfriends?start=${next}&account=<%=request.getParameter("account")%>&querynumber=<%=request.getParameter("querynumber")%>"><button class="btn btn-default">下一页</button></a>
    <a href="listqueryfriends?start=${last}&account=<%=request.getParameter("account")%>&querynumber=<%=request.getParameter("querynumber")%>"><button class="btn btn-default">末页</button></a>
    </td>
    </tr>
</table>
<div style="text-align:center">
<a href="home.jsp?account=<%=request.getParameter("account")%>">
<button class="btn btn-success btn-lg"style=" margin-top:40px;">主页</button>
</a>
<a href="friendcircle.jsp?account=<%=request.getParameter("account")%>">
<button class="btn btn-success btn-lg"style=" margin-top:40px;">返回</button>
</a>
</div>
        </div>
  </div>
   <div class="panel-footer"style="background-color: #dff0d8;text-align:center">
		<span>© 2018-2020 All Rights Reserved</span>
	</div>
  
        
  </body>
</html>
