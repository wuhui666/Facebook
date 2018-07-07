<%@ page language="java" import="java.util.*,Bean.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyInformation.jsp' starting page</title>
    
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
  <%
  
			User user=new UserDAO().get(request.getParameter("account"));
			log(request.getParameter("account"));
			
   %>
   <div class="jumbotron"style="width:100%;height:580px">   <!--  放大     -->
		<div style="text-align: center;">
			<p  class="text-info"style="font:italic bolder 100px '微软雅黑';">Facebook</p>
			<br />
			<br />
			<p class="text-muted"style="font:italic bolder 30px '微软雅黑';">Please complete what you have changed!</p>
			<br />
			<br />
	         <form style="display: inline-block;text-align: center;"action="modify?account=<%=request.getParameter("account")%>"method="post">
  	         <table style="text-align:center;">
  		         <tr>
  			       <td>账户：</td>
  			       <td><%=user.account %></td>
  		        </tr>
  		        <tr>
  			      <td>学号：</td>
  			      <td><%=user.number %></td>
  		       </tr>
  		       <tr>
  		 	     <td>性别：</td>
  			     <td><input type="text"class="form-control"name="sex"value='<%=user.sex %>'/></td>
  		      </tr>
  		      <tr>
  		   	     <td>年龄：</td>
  			     <td><input type="text"class="form-control"name="age"value='<%=user.age %>'/></td>
  		      </tr>
  		      <tr>
  		  	     <td>姓名：</td>
  			     <td><input type="text"class="form-control"name="name2"value='<%=user.name %>'/></td>
  		       </tr>
  		
  	     </table>
  	     <button class="btn btn-success">立即修改</button>
  	  </form>
  	 
  	  <a href="selfcenter.jsp?account=<%=request.getParameter("account") %>"><button class="btn btn-success btn-xs"id="back">返回</button></a>
  	 
  	  
  	         <%if(request.getAttribute("ismodified")==null){
              	request.setAttribute("ismodified", "false");
  	            }
  	          %>
  	           <div style="text-align:center;color:green">
  	              <span>
  	                 <%=request.getAttribute("ismodified").equals("true")?"修改成功":""%>
  	              </span>
  	           </div>
        </div>
  </div>

   
  </body>
</html>

