<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Etf_金</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
       
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>Admin早上好，欢迎使用信息管理系统</b>(admin@uimaker.com)
    <a href="#">帐号设置</a>
    </div>
 
     <div class="welinfo">
    <span><img src="images/time.png" alt="时间" /></span>
    <i>您上次登录的时间：2013-10-09 15:22</i> （不是您登录的？<a href="#">请点这里</a>）
    </div>
       
<h1 align="center">ETF_黄金数据爬虫应用--msg.jsp</h1>
<hr>
<h3><a href="<%=request.getContextPath() %>/index.jsp">首页</a></h3>
<h3 align="center">${msg }</h3>
</body>
</html>