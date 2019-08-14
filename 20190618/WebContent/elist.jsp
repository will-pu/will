<%@ page import="com.neuedu.po.Employee"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工列表</title>

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
			#div2, #div3, #div4{
				width: 1100px;				
				border: 0px solid #000;
			}
		</style>

</head>
<body>
	<form name="sform" action="${pageContext.request.contextPath}/emplist" method="post">
		<input type="hidden" name="pagenum" id="pagenum">
		
		<div id="chaxun" >
			患者姓名:<input type="text" name="ename" value="${ename}">			      		
		</div>
		<div id="div1">
			身份证号<input type="text"/> <span id="a1"></span>
		</div>
		<div id="div2" class="col-md-5">
			患者id<input type="text"/>
			姓名<input type="text"/>
			性别<select>
				    <option value=""></option>
					<option value="男">男</option>
					<option value="女">女</option>						
		         </select>
			家庭住址<input type="text"/>
			出生日期<input type="date"/>
		</div>
		
		<div id="div3" class="col-md-5">
			住院科室<select>
					    <option value=""></option>
					    <option value="脑科">脑科</option>
						<option value="儿科">儿科</option>
						<option value="外科">外科</option>	
						<option value="神经科">神经科</option>	
						<option value="妇科">妇科</option>	
			        </select>
			身份证号<input type="text"/>
			结算类别<select>
					    <option value=""></option>
						<option value="自费">自费</option>
						<option value="公费">公费</option>						
			        </select>
			医疗证号<input type="text"/>
			医疗类别<select>
					    <option value=""></option>
						<option value="市保">市保</option>
						<option value="公务员">公务员</option>						
			        </select>
		</div>
		
		<div id="div4" class="col-md-4">
			床位类别<select id="sel1" onchange="test2();">
					    <option value=""></option>
					    <option value="1">A类</option>
						<option value="2">B类</option>
						<option value="3">C类</option>							
			        </select>
			床位价格<input type="text" id="sp2" name="sp2"/>	
			生成床位<input type="text" id="sp3" name="sp3"/>
			押金<input type="text" id="sp4" name="sp4"/>			
		</div>
		
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
		
				
		入住时间:<input type="date" name="b1" value="${b1}"> - <input type="date" name="b2" value="${b2}">
		<input type="submit" value="查询">
		<input type="reset" value="重置">
	</form>
	<input type="button" value="批量删除" onclick="deleteBatch();">
	<hr>
	<table width="1000" border="1">
		<thead>
		    <tr>
		        <th>住院人员列表</th>
		        <th></th>
		        <th></th>
		        <th></th>
		        <th></th>
		        <th></th>
		        <th></th>		        
		        <th>拎包入住</th>
		        <th>出院</th>
		    </tr>
		
			<tr>
				<th>
					<input type="checkbox" id="ckall" name="ckall" onclick="ckall();">全选
				</th>
				<th>住院编号</th>
				<th>患者id</th>
				<th>患者姓名</th>
				<th>患者性别</th>
				<th>患者科室</th>
				<th>入住时间</th>
				<th>床位编号</th>
				<th>床位类别</th>
			</tr>
		</thead>
		<tbody>
			<form name="haha" action="${pageContext.request.contextPath}/deleteUserBatch" method="post">
				<c:forEach var="po" items="${elist}">
					<tr>
						<td><input type="checkbox" name="ckone" value="${po.empid}" onclick="ckone();"></td>
						<td>${po.empid}</td>
						<td>${po.empnum}</td>
						<td>${po.ename}</td>						
						<td>
							<c:choose>
								<c:when test="${po.sex == 1}">
									男
								</c:when>
								<c:otherwise>
									女
								</c:otherwise>
							</c:choose>
						</td>
						<td>${po.department}</td>
						<td><fmt:formatDate value="${po.etime}" pattern="yyyy年MM月dd日"/> </td>
						<td>${po.bedid}</td>
						<td>${po.bedty}</td>
						<td>
							<input type="button" value="修改" onclick="updateUser(${po.empid})">
	 					    <input type="button" value="删除" onclick="delUser(${po.empid})">
						</td>
					</tr>
				</c:forEach>
			</form>
			<tr>
				<td colspan="9" aligin="center">
					<c:choose>
						<c:when test="${pagenum == 1}">
							首页
							上一页
						</c:when>
						<c:otherwise>
							<a href="javascript:doSearch(1);">首页</a>
							<a href="javascript:doSearch(${pagenum-1})">上一页</a>
						</c:otherwise>
					</c:choose>
					${pagenum}
					<c:choose>
						<c:when test="${pagenum == maxpage}">
							下一页
							尾页
						</c:when>
						<c:otherwise>
							<a href="javascript:doSearch(${pagenum+1})">下一页</a>
							<a href="javascript:doSearch(${maxpage})">尾页</a>
						</c:otherwise>
					</c:choose>
					
					&nbsp;
					记录总数：${total},共计${maxpage}页
				</td>
			</tr>
		</tbody>
	</table>
	<script type="text/javascript">
		function delUser(empid){
			if(confirm("确定要删除这条记录吗?")){
				location.href="${pageContext.request.contextPath}/delUser?empid="+empid;
			}	
		}
		function updateUser(empid){
			location.href="${pageContext.request.contextPath}/EntryUpdateUser?empid="+empid;
		}
		function doSearch(p){
			//将参数p赋值至表单的隐藏域，作为页码
			document.getElementById("pagenum").value = p;
			//提交整个查询表单（含有查询条件，页码）
			document.sform.submit();
		}
		function ckall(){
			var d = document.getElementById("ckall").checked;
			var cs = document.getElementsByName("ckone");
			for(var i = 0; i < cs.length; i++){
				cs[i].checked = d;
			}
			
		}
		
		function ckone(){
			var cs = document.getElementsByName("ckone");
			var total = cs.length; //总数
			var count = 0;
			for(var i = 0; i < cs.length; i++){
				if(cs[i].checked){
					count++
				}
			}
			if(count == total){
				document.getElementById("ckall").checked = true;
			}else{
				document.getElementById("ckall").checked = false;
			}
			
		}
		
		function deleteBatch(){
			document.haha.submit();
		}
	</script>
</body>
</html>