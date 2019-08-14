<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>
<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>ETF投资站</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>管理信息
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="index.jsp" target="rightFrame">首页模版</a><i></i></li>
        <li class="active"><cite></cite><a href="right.html" target="rightFrame">数据列表</a><i></i></li>
        <li><cite></cite><a href="imgtable.html" target="rightFrame">图片数据表</a><i></i></li>
        <li><cite></cite><a href="form.html" target="rightFrame">添加编辑</a><i></i></li>
               
        </ul>    
    </dd>        
    
    <dd>
    <div class="title"><span><img src="images/leftico02.png" /></span>TEF黄金</div>
    <ul class="menuson">
    
        <li><cite></cite><a href="http://www.dyhjw.com/dyhjw/etf.html" target="rightFrame">第一黄金网TEF黄金存储信息链接</a><i></i></li>
        <li><cite></cite><a href="test/Etf_jinHandler_getEdit.action" target="rightFrame">手动获取更新数据</a><i></i></li>        
        <li><cite></cite><a href="test/Etf_jinHandler_findAll.action" target="rightFrame">查询ETF黄金数据</a><i></i></li>     
        <li><cite></cite><a href="test/Etf_jinHandler_autoEdit.action" target="rightFrame">自动获取更新数据开始-开始</a><i></i></li>
        <li><cite></cite><a href="test/Etf_jinHandler_autoEdit2.action" target="rightFrame">自动获取更新数据开始-使用文件缓存-开始</a><i></i></li>
   
    </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>TEF白银</div>
    <ul class="menuson">
        <li><cite></cite><a href="http://www.dyhjw.com/dyhjw/slv_etf.html" target="rightFrame">第一黄金网TEF白银存储信息链接</a><i></i></li>
        <li><cite></cite><a href="test/Etf_yinHandler_getEdit.action" target="rightFrame">手动获取更新数据</a><i></i></li>
        <li><cite></cite><a href="test/Etf_yinHandler_findAll.action" target="rightFrame">查询ETF白银数据</a><i></i></li>
        <li><cite></cite><a href="test/Etf_yinHandler_autoEdit.action" target="rightFrame">自动获取更新数据开始-开始</a><i></i></li>
        <li><cite></cite><a href="test/Etf_yinHandler_closeEdit.action" target="rightFrame">停止获取更新数据</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>    
    </dd>     
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>备用</div>
    <ul class="menuson">
        <li><cite></cite><a href="addMessage.jsp" target="rightFrame">分析师喊单操作</a><i></i></li>
        <li><cite></cite><a href="test/Messagehandler_findAll.action" target="rightFrame">查看分析师操作建议</a><i></i></li>
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">更多服务</a><i></i></li>
    </ul>    
    </dd>   
    
    </dl>
    
</body>
</html>