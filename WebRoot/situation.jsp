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



</div>
</div>

<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="js/bootsnav.js"></script>


<script>
$(document).ready(function(){
	$.ajax({
		url:'getSituation',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			//开始搞tab
			var hn=new Array();
			for(i=0;i<=data.length-1;i++){
				for(j=-1;j<=hn.length-1;j++){
					var flag=true;
					if(data[i].housename.trim()==hn[j]){
						flag=false;
						break;
					}
				}
				if(flag==true)hn.push(data[i].housename.trim());
			}
			console.log(hn);//搞定所有库名！
			
			var str="<center><div class='easyui-tabs' id='mytab' style='width:50%;border:1px solid #BDBDBD;margin:20px'>";
			for(i=0;i<=hn.length-1;i++){
				str+="<div id='tab"+i+"' title='"+hn[i]+"'></div>";
			}
			str+="</div></center>";
			$("#realman").append($(str));
			$("#mytab").tabs();
				
			console.log(data);
			for(i=0;i<=hn.length-1;i++){
				var newdata=new Array();
				for(j=0;j<=data.length-1;j++){
					if(data[j].housename.trim()==hn[i]){	
						newdata.push(data[j]);
					}
				}
				console.log(newdata);
				var str="<input class='eayui-datagrid' id='mydatagrid"+i+"' style='width:900px;height:500px'/>";
				$("#tab"+i).append($(str));
				$("#mydatagrid"+i).datagrid({
					title: '',
					iconCls: "panelIcon",
					width:"auto", 
					height:450,
					data:newdata,
					nowrap: true,
					autoRowHeight: true,
					rownumbers: true,
					striped: true,  //条纹化
					collapsible: true,
					singleSelect: true, 
	
					remoteSort: false,
	
					columns:[[
								{ title: '商品名称', field:'productname', width: 187, halign:'center', align: 'center'},
								{ title: '平均价格', field:'averagepercost', width: 177, halign:'center', align: 'center',sortable:true},	
								{ title: '数量', field:'quantity', width: 177, halign:'center', align: 'center',sortable:true},
								]],
					frozenColumns: [[{ title:'商品编码',field: 'productid', width:187,align: 'center'}]]
	
				})		
			}	
		}
		})//---------ajax结束
})


</script>
</body>
</html>