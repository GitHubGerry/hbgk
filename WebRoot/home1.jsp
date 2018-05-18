<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<style type="text/css">
</style>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="jqeasyui/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="jqeasyui/themes/icon.css">

    <script type="text/javascript" src="jqeasyui/jquery.min.js"></script>
    <script type="text/javascript" src="jqeasyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jqeasyui/easyui-lang-zh_CN.js"></script>	
	<script type="text/javascript" src="system/easyui_functions.js"></script>
</head>

<body style="padding:2% 8%">
	<%	
		if(request.getAttribute("info1")!=null){
		session.setAttribute("userid",request.getAttribute("info1"));
		session.setAttribute("nickname",request.getAttribute("info2"));}
	%>
	<div id="main" class="easyui-panel" title="何不管库" style="height:700px;width:1200px">
		<div class="easyui-layout" style="height:670px;width:1198px">
			<div class="easyui-panel" id="toolbar" data-options="region:'north'" style="background-color:#C4C4C4;height:39px">
				<label id="zhuye" style='font-size:18px'>&nbsp&nbsp&nbsp主 页 &nbsp&nbsp</label>
				<a href="#" class="easyui-menubutton" data-options="menu:'#manage', iconCls:'searchIcon'" style="width:100px;">管理</a>		
				<a href="#" class="btn-separator"></a>
				<a href="#" class="easyui-menubutton" data-options="menu:'#buy', iconCls:'searchIcon'" style="width:100px">进货</a>
				<a href="#" class="btn-separator"></a>
				<a href="#" class="easyui-menubutton" data-options="menu:'#sale', iconCls:'searchIcon'" style="width:100px">销售</a>
				<a href="#" class="btn-separator"></a>
				<a href="#" class="easyui-menubutton" data-options="menu:'#store', iconCls:'searchIcon'" style="width:100px">库存</a>
				<a href="#" class="btn-separator"></a>
				<a href="#" class="easyui-menubutton" data-options="menu:'#count', iconCls:'searchIcon'" style="width:100px">账房</a>
			</div>
			<div class="easyui-panel"　id="main1" data-options="region:'center'">	
			<%=session.getAttribute("userid") %><%=session.getAttribute("nickname") %>
			</div> 	
		</div>
		
		
	</div>
	<div id="manage" style="width:100px">
			<div id="man1">仓库</div>
			<div id="man2">商品</div>
			<div id="man3">分类</div>
			<div id="man4">品牌</div>
			<div id="man5">规格</div>
	</div>
	<div id="buy" style="width:100px">
			<div id="buy1">进货记录</div>
			<div id="buy1">供货商</div>
			<div id="buy2">填写进货单</div>
	</div>	
	<div id="sale" style="width:100px">
			<div id="sale1">销售记录</div>
			<div id="sale2">销售商</div>
			<div id="sale3">填写销售单</div>
	</div>	
	<div id="store" style="width:100px">
			<div id="store1">库存状况</div>
			<div id="store2">库存流水</div>
			<div id="store1">调拨</div>
	</div>	
	<div id="count" style="width:100px">
			<div id="count1">销售利润统计</div>
	</div>	
			
	<div id="mymenu" class="easyui-menu"></div>
	
	<script>
	$(document).ready(function(){

		$("#zhuye").on('click',function(){
			window.location.reload();
		})

		$("#mymenu").menu("appendItem",{text:'嘿嘿',id:'hey'});
		$("#mymenu").menu("appendItem",{separator:true});
		$("#mymenu").menu("appendItem",{text:'(･∀･)ﾉﾞ嗨',id:'hi'});
		//触发右击，所以menu的div写哪里无所谓 
		//同样，menubutton指定的menu：'#menuforbutton' 的div也随便写哪里
		$("#main").bind('contextmenu',function(e){
			e.preventDefault();
			$("#mymenu").menu("show",{
				left:e.pageX,
				top:e.pageY,
			})
		})
		
		$("#man1").on('click',function(){
			$.ajax({
				url:'StorehouseServlet',
				data:{},
				anysc:false,
				method:'post'		
			})
		})
		
		
	})

	</script>
</body>
</html>
