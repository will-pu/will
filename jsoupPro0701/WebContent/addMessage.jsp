<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Etf_金</title>
</head>
<body>
<h1 align="center">ETF_黄金数据爬虫应用--喊单操作</h1>
<hr>
<h3><a href="<%=request.getContextPath() %>/index.jsp">首页</a></h3>
<h3 align="center">${msg }</h3>
<hr>
<form action="test/Messagehandler_add.action" method="post" name="form1" >
分析师:<input type="text" name="username"/><br><br>
标题:<input type="text" name="title"/><br><br>
操作建议:<textarea name="message" rows="10" cols="50"></textarea><br><br>
<input type="submit" name="sub" value="提交"/>
</form>
</body>
</html>