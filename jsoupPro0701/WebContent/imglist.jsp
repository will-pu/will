<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>

       <script type="text/javascript">			
			window.onload=function(){
				var date = new Date();
				var year = date.getFullYear();
		        var month = date.getMonth() + 1;
		        var strDate = date.getDate();		        
		        var currentdate = "今天"+ ":" + year + "年" + month + "月" + strDate + "日";
				document.getElementById("a1").innerHTML = currentdate;				
			}	
		</script>
		
		<style type="text/css">
		    #div2{
		       width: 18%;
			   height: 350px;
			   border-right: 0px solid #000;
		       float: left;
		    }
		</style>

		<style type="text/css">
		    #div3{
		       width: 18%;
			   height: 350px;
			   border-right: 0px solid #000;
		       float: left;
		    }
		</style>
		
		<style type="text/css">
		    #div4{
		       width: 18%;
			   height: 350px;
			   border-right: 0px solid #000;
		       float: left;
		    }		
		</style>
		
		<style type="text/css">
		    #div5{
		       width: 18%;
			   height: 350px;
			   border-right: 0px solid #000;
		       float: left;
		    }		
		</style>
		
		<style type="text/css">
		    #div6{
		       width: 18%;
			   height: 350px;
			   border-right: 0px solid #000;
		       float: left;
		    }		
		</style>		
		


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">模块设计</a></li>
    <li><a href="#">图片</a></li>
    </ul>
    </div>
    <!--
    <div class="rightinfo">
    -->
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    <!--
    <ul class="imglist">
    
    <li class="selected">
    <span><img src="images/img01.png" /></span>
    <h2><a href="#">软件界面设计下载</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="images/img02.png" /></span>
    <h2><a href="#">界面样式素材下载</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="images/img03.png" /></span>
    <h2><a href="#">弹出小窗口界面设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="images/img04.png" /></span>
    <h2><a href="#">羽毛图标设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="images/img05.png" /></span>
    <h2><a href="#">日历组件样式设计</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="images/img06.png" /></span>
    <h2><a href="#">羽毛图标设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="images/img07.png" /></span>
    <h2><a href="#">弹出小窗口界面设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="images/img08.png" /></span>
    <h2><a href="#">弹出小窗口界面设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="images/img09.png" /></span>
    <h2><a href="#">弹出小窗口界面设计教程</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    <li>
    <span><img src="images/img10.png" /></span>
    <h2><a href="#">软件界面设计下载</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></p>
    </li>
    
    </ul>
    
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
        
        
    </div>
    -->
    
    <div style="text-align: center;color: coral;height: 30px;">
			<h3>住院登记管理</h3>
		</div>
		<div id ="tital">
			   <a href=""></a>
			   			   
		</div>
		
		<div id="chaxun" style="text-align: center;height: 30px;">		
			<label>患者姓名</label><input type="text"/><input type="button" value="查询"/>			
		</div>	
		<div id="div1" style="text-align: right;width:200px;">
			身份证号<input type="text"/><label id="a1"></label>
		</div>
	<div id="divv" class="col-md-1 column">		
		<div id="div2" class="col-md-5 column">
			<span>患者id<input type="text"/></span><br />
			<span>住院科室<select>
					    <option value=""></option>
					    <option value="脑科">脑科</option>
						<option value="儿科">儿科</option>
						<option value="外科">外科</option>	
						<option value="神经科">神经科</option>	
						<option value="妇科">妇科</option>	
			        </select>
			</span><br />        
			<span>床位类别<select id="sel1" onchange="test2();">
					    <option value=""></option>
					    <option value="1">A类</option>
						<option value="2">B类</option>
						<option value="3">C类</option>							
			        </select>
			</span><br />
		</div>
		<div id="div3" class="col-md-5 column">	
			<span>姓名<input type="text"/></span><br />
			<span>身份证号<input type="text"/></span><br />
			<span>床位价格<input type="text" id="sp2" name="sp2"/></span><br />
		</div>
		<div id="div4" class="col-md-4 column">	
			<span>性别<select>
				    <option value=""></option>
					<option value="男">男</option>
					<option value="女">女</option>						
		         </select>
			</span><br />
			<span>结算类别<select>
					    <option value=""></option>
						<option value="自费">自费</option>
						<option value="公费">公费</option>						
			        </select>
			</span><br />
			<span>生成床位<input type="text" id="sp3" name="sp3"/></span><br />
		</div>
		<div id="div5" class="col-md-4 column">	
			<span>家庭住址<input type="text"/></span><br />
			<span>医疗证号<input type="text"/></span><br />
			<span>押金<input type="text" id="sp4" name="sp4"/></span><br />			
		</div>
		
		<div id="div6" class="col-md-4 column">					
			<span>出生日期<input type="date" name="birthday"  /></span><br />			
			<span>医疗类别<select>
					     <option value=""></option>
						 <option value="市保">市保</option>
						 <option value="公务员">公务员</option>						
			           </select>
			</span><br />           
		</div>
				
		</div>
		<br />
		<br />
		<!--
        	联动列表    床位价格、生成床位、押金
        -->
                
		<script type="text/javascript">
			
			var a = 0;
			//患者ID
			
			function test2(){																				
				var s = document.getElementById("sel1");
				//获得所有option标记组成的数组
				var ops = s.options;
				//获得选中项的下标
				var idx = s.selectedIndex;
				//选中项					
				if(idx == 1){
					var bed = 10;
					var deposit = 100;
				}else if(idx == 2){
					var bed = 20;
					var deposit = 150;
				}else if(idx == 3){
					var bed = 30;
					var deposit = 200;
				}else{
					var bed = "";
					var deposit = "";
				}
				
				a += 1;
				
				document.getElementById("sp2").value=bed;
				document.getElementById("sp3").value=a;
				document.getElementById("sp4").value=deposit;
				
			}
		</script>
    

</body>

</html>
