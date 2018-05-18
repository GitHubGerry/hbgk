<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>何不管库</title>
	<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
	<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
	<link rel="stylesheet" type="text/css" href="css/bootsnav.css">
	<link rel="stylesheet" type="text/css" href="gywcss/home.css">
	
	<link rel="stylesheet" type="text/css" href="jqeasyui/themes/gray/easyui.css">
	<script type="text/javascript" src="jqeasyui/jquery.min.js"></script>
    <script type="text/javascript" src="jqeasyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jqeasyui/easyui-lang-zh_CN.js"></script>	
	<script type="text/javascript" src="system/easyui_functions.js"></script>
	
	
</head>
<body>

<div id="main">
<div id="daohanglan" class="jq22-container">
	<header class="jq22-header">
		<h1>&nbsp何不管库</h1>
	</header>
<div class="demo" style="padding: 1em 0;height:100px">

<nav class="navbar navbar-default navbar-mobile bootsnav">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
            <i class="fa fa-bars"></i>
        </button>
    </div>
    <div class="collapse navbar-collapse" id="navbar-menu">
        <ul class="nav navbar-nav" data-in="fadeInDown" data-out="fadeOutUp">
            <li><a href="home.jsp">主页</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">管理&nbsp</a>
                <ul class="dropdown-menu">
                    <li><a href="storehouse.jsp" id="storehouse">仓库</a></li>
                    <li><a href="product.jsp">商品</a></li>
                    <li><a href="category.jsp">分类</a></li>
                    <li><a href="brand.jsp">品牌</a></li>
                    <li><a href="feature.jsp">规格</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" >备用</a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Custom Menu</a></li>
                            <li><a href="#">Custom Menu</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" >Sub Menu</a>
                                <ul class="dropdown-menu multi-dropdown">
                                    <li><a href="http://www.jq22.com">Custom Menu</a></li>
                                    <li><a href="#">Custom Menu</a></li>
                                    <li><a href="#">Custom Menu</a></li>
                                    <li><a href="#">Custom Menu</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>

                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">进货&nbsp</a>
                <ul class="dropdown-menu">
                    <li><a href="purchaselog.jsp">进货记录</a></li>
                    <li><a href="supplier.jsp">供应商</a></li>                 
                    <li><a href="purchaseorder.jsp">填写进货单</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">销售&nbsp</a>
                <ul class="dropdown-menu">
                    <li><a href="saleslog.jsp">销售记录</a></li>
                    <li><a href="buyer.jsp">顾客</a></li>                 
                    <li><a href="salesorder.jsp">填写售货单</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">库存&nbsp</a>
                <ul class="dropdown-menu">
                    <li><a href="situation.jsp">库存状况</a></li>
                    <li><a href="flow.jsp">库存流水</a></li>                 
                    <li><a href="transferorder.jsp">调拨</a></li>
                </ul>
            </li>
            <li><a href="#" id="contact">Contact Us</a></li>
        </ul>
    </div>
</nav>

</div>
</div>

<div id="realman" style="fit:auto;">
	<a href="#" id="insert" style="float:right;margin-right:30px" class="btn3" onclick="insertsh()">新增</a>



</div>
</div>

<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="js/bootsnav.js"></script>


<script>
$(document).ready(function(){
	$.ajax({
		url:'SupplierServlet',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			var str="<input class='eayui-datagrid' id='mydatagrid' style='width:900px;height:500px'/>";
			$("#realman").append($(str));
			$("#mydatagrid").datagrid({
				title: '&nbsp;供应商列表',
				iconCls: "panelIcon",
				width:1500, 
				height:450,
				data:data,
				nowrap: true,
				autoRowHeight: true,
				rownumbers: true,
				striped: true,  //条纹化
				collapsible: true,
				singleSelect: true, 

				columns:[[
							{ title: '公司名', field: 'companyname', width: 190, halign:'center', align: 'center'},
							{ title: '联系人1', field:'linkman1', width: 146, halign:'center', align: 'center'},
							{ title: '电话1', field:'tele1', width: 158, halign:'center', align: 'center'},	
							{ title: '联系人2', field:'linkman2', width: 146, halign:'center', align: 'center'},
							{ title: '电话2', field:'tele2', width: 158, halign:'center', align: 'center'},
							{ title: '微信', field:'wechat', width: 150, halign:'center', align: 'center'},
							{ title: '交易次数', field:'volume', width: 120, halign:'center', align: 'center'},
							{ title: '操作', field:'operate', width: 210, halign:'center', align: 'center',formatter:operate}
							]],
				frozenColumns: [[{ title:'供应商编号',field: 'supplierid', width:182,align: 'center'}]]

			})		
		}
		})//---------ajax结束
})
function operate(val,row,index){  
    return '<a href="#" class="btn2" onclick="editsh('+index+')">修改</a>'+'<label style="width:30px"/>'+'<a href="#" class="btn2" onclick="deletesh('+index+')">删除</a>';
} 





</script>
</body>
</html>