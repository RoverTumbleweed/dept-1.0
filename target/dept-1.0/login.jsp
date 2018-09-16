<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>

  </head>
  
  <body>
  <center><font color="red">${error}</font></center>
    <form action="LoginServlet" method="post" >
	      <table align="center" border="1" bgcolor="#FFFF88">
	          <tr>
	             <td>用户名：</td>
	             <td><input type="text" name="username" value="admin"></td>
	          </tr>

	          <%--<tr>--%>
	             <%--<td height="26">验证码：</td>--%>
	             <%--<td valign="center" align="left">--%>
                       <%--&nbsp;<input type="text" name="Random" styleClass="input60">--%>
                       <%--<img align="MIDDLE" src="Image" alt="验证码" onclick="javascript:refresh(this);">--%>
                 <%--</td>--%>
	          <%--</tr>--%>
			  <tr>
	             <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
	             <td><input type="password" name="pwd" value="admin"></td>
	          </tr>
			  <tr>
				  <td>用户类型：</td>
				  <td><input type="text" name="ty" value="2"></td>
			  </tr>
			  <tr>
				  <td>用户年龄：</td>
				  <td><input type="text" name="age" value="3"></td>
			  </tr>
	          <tr>
	            <td colspan="2" align="center">
	              <input type="submit" value="登录" >&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"> 
	            </td>
	          </tr>
	      </table>
    </form>
  
  </body>
</html>
