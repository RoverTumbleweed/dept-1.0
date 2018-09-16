<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<frameset rows="10,70,20" frameborder="NO" border="0" framespacing="0">
    <frame src="header.jsp" name="topFrame" scrolling="NO">
    <frame src="body.jsp" name="mainFrame">
    <frame src="tail.jsp" name="bottomFrame" scrolling="NO">
</frameset>
</html>
