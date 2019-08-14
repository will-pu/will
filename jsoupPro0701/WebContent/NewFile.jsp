<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Etf_金</title>
</head>
<body>
<h1 align="center">ETF_黄金数据爬虫应用</h1>
<hr>
<h3><a href="test/Etf_jinHandler_add.action">1.测试添加一条数据</a></h3>
<h3><a href="http://www.dyhjw.com/dyhjw/etf.html">第一黄金网TEF黄金存储信息链接</a></h3>
<form action="<%=request.getContextPath() %>/test/Etf_jinHandler_addBatch.action" name="form1" method="post">
URL:<input type="text" size="60" name="urlpath" value="http://www.dyhjw.com/dyhjw/etf.html"/><br><br>
字符集:<input type="text" size="10" name="charset" value="utf-8"/><br><br>
数据保存文件地址:<input type="text" size="10" name="path" value="e:/ETF_jin.txt"/><br><br>
<input type="submit"  name="sub" value="爬取数据"/>
</form>
<hr>
<h3><a href="test/Etf_jinHandler_getEdit.action">3.手动获取更新数据</a></h3>
<h3><a href="test/Etf_jinHandler_autoEdit.action">4.自动获取更新数据开始-开始</a></h3>
<h3><a href="test/Etf_jinHandler_autoEdit2.action">5.自动获取更新数据开始-使用文件缓存-开始</a></h3>
<h3><a href="test/Etf_jinHandler_findAll.action">6.查询ETF黄金数据</a></h3>
<h3><a href="addMessage.jsp">7.分析师喊单操作</a></h3>
<h3><a href="test/Messagehandler_findAll.action">8.查看分析师操作建议</a></h3>
</body>
</html>