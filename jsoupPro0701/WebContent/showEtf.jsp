<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Etf_金</title>
</head>
<body>
<h1 align="center">ETF_黄金数据爬虫应用--showEtf.jsp</h1>
<hr>
<h3><a href="<%=request.getContextPath() %>/index.jsp">首页</a></h3>




 <table border="0" align="center" cellpadding="0" cellspacing="0" class="sx_table">
            <tr>
           		<th><strong>ID</strong></th>
                <th><strong>日期（美国）</strong></th>
                <th><strong>净持仓量（吨）</strong></th>
                <th><strong>总价值（美元）</strong></th>
                <th><strong>增减（吨）</strong></th>
                <th><strong>黄金单价</strong></th>
                <th><strong>更新时间</strong></th>
                <th><strong>影响（金银）</strong></th>
            </tr>
 <c:forEach items="${list }" var="e">
             <tr class="green">
             	<td>${e.id }</td>
                <td>${e.time }</td>
                <td><b>${e.jingChiCangLiang }</b></td>
                <td>${e.meiYuan }</td>
                <td>${e.zengJian }</td>
                <td>${e.price }</td>
                <td>${e.time2 }</td>
                <td> <span class="lk">${e.yingXiang }</span></td>
             </tr>
</c:forEach>
    
</table>



</body>
</html>