<%@ page language="java" import="java.util.*,Bean.*,dao.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sweetwords.jsp' starting page</title>
    
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

a.module{
  text-decoration:none;
  display: block;
  width:1200px;
  height:150px;
  margin: 30px;
  padding:0px;
  background-color: #d9edf7;
  float:left;
  border-radius: 18px;
  position: relative;
  
}

a.module span.moduleNumber{
  position: absolute;
  top: 120px;
  left: 1100px;
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
 
    button{
    margin-right:8%;
     margin-left:8%;
     margin-top:10px;
   
    }
  

</style>
  <body>
    <div class="panel panel-success">
		<div class="panel-heading"style="text-align:center"><p style="font:italic bolder 50px '微软雅黑';color:lightblue"><%=request.getParameter("account") %>的蜜语</p></div>
		<div class="panel-body"style="background-color:aliceblue;">
		
		<table style="border='1' cellspacing='0'class="table table-striped">
		
         <c:forEach items="${wordslist}" var="sweetword" varStatus="st">
          <tr>
            <td>
              <a href="" class="module" class="module">
			      <div>
                    <span  class="moduleName"style="font:italic bolder 30px 'Times New Roman';color:gray">${sweetword.words}</span>
                  </div>
	              <br/>
	              <br/>
	           <span  class="badge moduleNumber pull-right">${sweetword.date}</span>
	        </a>
            </td>
        </tr>
    </c:forEach>
    <tr>
    <td colspan='3' style="text-align:center">
    <a href="listsweetwords?start=0&account=<%=request.getParameter("account")%>"><button class="btn btn-default">首页</button></a>
    <a href="listsweetwords?start=${pre}&account=<%=request.getParameter("account")%>"><button class="btn btn-default">上一页</button></a>
    <a href="listsweetwords?start=${next}&account=<%=request.getParameter("account")%>"><button class="btn btn-default">下一页</button></a>
    <a href="listsweetwords?start=${last}&account=<%=request.getParameter("account")%>"><button class="btn btn-default">末页</button></a>
    </td>
    </tr>
   </table>
   <div style="text-align:center">
        <a href="home.jsp?account=<%=request.getParameter("account")%>"><button class="btn btn-success">返回</button></a>
     </div>
  </div>
   <div class="panel-footer"style="background-color: #dff0d8;text-align:center">
		<span>© 2018-2020 All Rights Reserved</span>
		</div>
 </div>
  </body>
</html>
 