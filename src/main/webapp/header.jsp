<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<body>
<center>
    <a href="EmpServlet?method=add" target="mainFrame">增加一个雇员</a>
    <a href="EmpServlet?method=selectAll" target="mainFrame">查看所有雇员信息</a>
    <a href="DeptServlet?method=add" target="mainFrame">增加一个部门</a>
    <a href="DeptServlet?method=select" target="mainFrame">查看所有部门信息</a>
    <a href="DeptServlet?method=manage" target="mainFrame">管理部门员工</a>
</center>
</body>
</html>
