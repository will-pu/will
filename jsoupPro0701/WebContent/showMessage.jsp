<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Etf_金</title>
</head>
<script type="text/javascript">
var XMLHttpReq,pid; 
//创建XMLHttpRequest对象
function createXMLHttpRequest()
{
	if(window.XMLHttpRequest)
	{                               
		//Mozilla浏览器
     XMLHttpReq = new XMLHttpRequest();
 }else if(window.ActiveXObject)
 {                           
 	//IE浏览器
     try
     {
         XMLHttpReq = new ActiveXObject( "Msxm12.XMLHTTP" );
     }catch(e)
     {
         try
         {
            XMLHttpReq = new ActiveXObject( "Microsoft.XMLHTTP" );
         }catch(e)
         {}
      }
   }
}  
//发送Ajax请求
function sendAjaxRequest(url)
{
 //  alert("sendAjaxRequest");
   createXMLHttpRequest();                         //创建XMLHttpRequest对象
   XMLHttpReq.open("post",url,true);
   XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
   XMLHttpReq.send(null);
}
//回调函数processResponse
function processResponse()
{
//	alert("回写1");
    if(XMLHttpReq.readyState == 4)
    {
    	 if(XMLHttpReq.status == 200)
    	 {
    	//	alert("回写ok");
    	 	var id=XMLHttpReq.responseXML.getElementsByTagName("id")[0].firstChild.data;
    		var username=XMLHttpReq.responseXML.getElementsByTagName("userName")[0].firstChild.data;
    		var title=XMLHttpReq.responseXML.getElementsByTagName("title")[0].firstChild.data;
    		var message=XMLHttpReq.responseXML.getElementsByTagName("message")[0].firstChild.data;
    		var time=XMLHttpReq.responseXML.getElementsByTagName("time")[0].firstChild.data;
		//	alert(res);
    	 	<!--
    	 	var str=id+"&nbsp;&nbsp;"+
    	 			username+"&nbsp;&nbsp;"+
    	 			title+"&nbsp;&nbsp;"+
    	 			message+"&nbsp;&nbsp;"+
    	 			time;
    	 			 -->
    	 	id1.innerHTML =id;
    	 	name1.innerHTML =username;
    	 	title1.innerHTML =title;
    	 	time1.innerHTML =time;
    	 	message1.innerHTML =message;
    	 }
    }
}
function a(){
//	alert("ok");
	//  var url = "ThreeLink?father_id="+father_id;
	//var name=document.getElementById("name").value;
	var url="Messagehandler_findNewMessage.action";
  	sendAjaxRequest(url);
}
function start(){
	window.setInterval("a()", 5000);				
}
</script>
<body onload="start()">
<h1 align="center">ETF_黄金数据爬虫应用--showMessage.jsp</h1>
<hr>
<h3><a href="<%=request.getContextPath() %>/index.jsp">首页</a></h3>
<hr>

<h2 align="center">分析师最新操作建议</h2>
<h2 align="center"><input type="button" name="btn" value="刷新" onclick="a()"/></h2>
<div id="returnMsg" style="color:red;">提示信息</div>
<div id="id1" style="color:red;"></div>
<div id="name1" style="color:red;"></div>
<div id="title1" style="color:red;"></div>
<div id="time1" style="color:red;"></div>
<div id="message1" style="color:red;"></div>
<hr>
<h2 align="center">以下信息为分析师操作建议</h2>
<hr>
</body>
</html>