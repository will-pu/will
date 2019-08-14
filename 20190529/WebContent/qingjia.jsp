<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申请休假</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function (){
		$("#asktype").change(function (){
			var typeid = $(this).val();
			//将typeid发给servlet
			$.ajax({
				url: "${pageContext.request.contextPath}/AjaxGetRestDaysServlet",
				data: {"t":typeid,"a":"哈哈"},
				type: "post",
				dataType: "text",
				async : true,
				error : function (XMLHttpRequest, textStatus, errorThrown){
					alert("Ajax出错")
				},
				success : function (data){
					if(data == -1){
						data = "无限制";
					}
					$("#days").html(data);
				}
			});
		});
	});
</script>
</head>
<body>
	休假类型：
	<select id="asktype">
		<option value="-1">=请选择=</option>
		<c:forEach var="a" items="${alist}">
			<option value="${a.atypeid}">${a.atype}</option>
		</c:forEach>
	</select>
	<br>
	可用天数：<span id="days">无限制</span>
</body>
</html>