<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script>

<!-- 
第二个的login.jsp
 -->

</head>
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>

<div class="logintop">    
    <span>ETF黄金白银投资服务站</span>    
    <ul>
    <li><a href="login.jsp">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    
    <ul>
    <li><input name="" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
    <li><input name="" type="password" class="loginpwd" value="123" onclick="JavaScript:this.value=''"/></li>
     
    <li><input name="" type="button" class="loginbtn" value="登录"  onclick="javascript:window.location='main.jsp'"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="forget.jsp">忘记密码？</a></label></li>     
    <!--
    <li><button id="btn_login" type="button" class="btn btn-primary" style="width: 120px;">登录</button></li>
    -->
    </ul>
        
    </div>
    
    </div>
          
    <div class="loginbm">版权所有  2013  <a href="http://www.mycodes.net">源码之家</a> </div>	
    
</body>
</html>