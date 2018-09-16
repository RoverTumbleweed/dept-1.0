<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>增加雇员</title>

<script type="text/javascript">
	
	function check(){
	
		var name = document.getElementById("name").value;
		var salary = document.getElementById("salary").value;
		var age = document.getElementById("age").value;
		var deptno = document.getElementById("deptId").value;
		
		var reg = /^(([1-9]{1}\d*)|(\d+\.\d{2}))$/;
		
		var reg1 = /^(\d+)$/;
		
		if(name == null || name == ""){
			
			alert("姓名不能为空");
			return;
		} else if(!reg.test(salary)){
			alert("薪水只能为整数或者保留2位小数");
			return;
		} else if(!reg1.test(age)){
			alert("年龄只能为数字");
			return;
		} else if(deptno == 0){
			alert("请选择部门");
			return;
		}
		
		document.myform.submit();
	
	}
	
</script>

</head>
<body bgcolor="#ffffff">
  <center>
     <h1>增加雇员：</h1>
    <br/> ${error}
<form method="Post" action="EmpServlet?method=save" name="myform">
  <table align="center" bgcolor="#008800" border="0" cellspacing="2" cellpadding="5">
      
    <tr  bgcolor="#FFFF88">
     <td> 姓名:</td>
     <td>
       <input type="text" name="name" size="20" id="name">
     </td>
     </tr>


     <tr  bgcolor="#FFFF88">
     <td>薪水:</td>
     <td><input type="text" name="salary" size="20" id="salary">
     </td>
     </tr>

     <tr  bgcolor="#FFFF88">
     <td> 年龄:</td>
     <td><input type="text" name="age" size="20" id="age"><br>
     	 <span id="ageId"></span>
     </td>
     </tr>

     <tr  bgcolor="#FFFF88">
    <td>分配部门:</td>
    <td>
    <select name="deptId" id="deptId">
    	<option value="0">----请选择部门----</option>
		<c:forEach items="${deptList}" var="dept">
			<option value="${dept.id}">${dept.name}</option>
		</c:forEach>
    </select>
    </td>
    </tr>

    <tr  bgcolor="#FFFF88">
    <td colspan="2" align="center">
      <input type="button" value="添加" onclick="check()">
    </td>
    </tr>
  </table>
</form>
  </center>
</body>
</html>
