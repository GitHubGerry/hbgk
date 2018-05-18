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

    <div class="collapse navbar-collapse" id="navbar-menu">
        <ul class="nav navbar-nav" data-in="fadeInDown" data-out="fadeOutUp">
            <li><a href="home.jsp">主页</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">管理&nbsp</a>
                <ul class="dropdown-menu">
                    <li><a href="#" id="storehouse">仓库</a></li>
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
                    <li><a href="pruchaseorder.jsp">填写进货单</a></li>
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
<div class="easyui-window" id="mywin" style="height:280px;width:390px" title="新增仓库">
<form id="insert" action="postStorehouse" onsubmit="return check1()" method="post">
		<div style="position:absolute;top:57px;left:50px">仓库名称：</div>
		<div style="position:absolute;top:55px;left:120px"> <input id="housename" name="housename" type="text" class="easyui-textbox"/></div>
		<div style="position:absolute;top:102px;left:66px">管理者:</div>
		<div style="position:absolute;top:100px;left:120px" > <input id="managerid" name="managerid" class="easyui-combobox"/></div>
		<div style="position:absolute;top:147px;left:50px">是否启用:</div>
		<div style="position:absolute;top:145px;left:120px" > <input id="onoff" name="onoff" style="width:178px" class="easyui-combobox"/></div>
		<div style="position:absolute;top:190px;left:120px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="reset" value="重置"/></div>
		<div style="position:absolute;top:190px;left:200px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="submit" value="提交"></div>
		 
</form>
</div>
<div class="easyui-window" id="mywin2" style="height:280px;width:390px" title="修改仓库">
<form id="edit">
		<div style="position:absolute;top:57px;left:50px">仓库名称：</div>
		<div style="position:absolute;top:55px;left:120px"> <input id="housename2" name="housename2" type="text" class="easyui-textbox"/></div>
		<div style="position:absolute;top:102px;left:66px">管理者:</div>
		<div style="position:absolute;top:100px;left:120px" > <input id="managerid2" name="managerid2" class="easyui-combobox"/></div>
		<div style="position:absolute;top:147px;left:50px">是否启用:</div>
		<div style="position:absolute;top:145px;left:120px" > <input id="onoff2" name="onoff2" style="width:178px" class="easyui-combobox"/></div>
		<div style="position:absolute;top:190px;left:120px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="reset" value="重置"/></div>
		<div style="position:absolute;top:190px;left:200px"><input class="easyui-linkbutton" style="width:60px;height:25px" value="提交" onclick="editdo()"></div>
		 
</form>
</div>

</div> 
	
</div>

<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="js/bootsnav.js"></script>


<script>
$(document).ready(function(){

	var source=[{id:'on',text:'on'},{id:'off',text:'off'}];
	$("#onoff").combobox({
		valueField:'id',
		textField:'text',
		data:source,
		editable:false,
		panelHeight:'auto'
	});
	var source=[{id:'on',text:'on'},{id:'off',text:'off'}];
	$("#onoff2").combobox({
		valueField:'id',
		textField:'text',
		data:source,
		editable:false,
		panelHeight:'auto'
	});
	$("#mywin").window('close');
	$("#mywin2").window('close');
	//正式开始......
	$.ajax({
		url:'getStorehouse',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			var str="<input class='eayui-datagrid' id='mydatagrid' style='width:900px;height:500px'/>";
			$("#realman").append($(str));
			$("#mydatagrid").datagrid({
				title: '&nbsp;仓库列表',
				iconCls: "panelIcon",
				width:1500, 
				height:450,
				data:data,
				nowrap: true,
				autoRowHeight: false,
				rownumbers: true,
				striped: true,  //条纹化
				collapsible: true,
				singleSelect: true, 

				columns:[[
							{ title: '管理者', field: 'managerid', width: 350, halign:'center', align: 'center'},
							{ title: '是否启用', field:'on_off', width: 210, halign:'center', align: 'center'},
							{ title: '创建日期', field:'createdate', width: 350, halign:'center', align: 'center'},
							{ title: '操作', field:'operate', width: 300, halign:'center', align: 'center',formatter:operate}
						]],
				frozenColumns: [[{ title:'仓库名称',field: 'housename', width: 250,align: 'center'}]]
			})
			
			
			
		}
		})

})
function operate(val,row,index){  
    return '<a href="#" class="btn2" onclick="editsh('+index+')">修改</a>'+'<label style="width:35px"/>'+'<a href="#" class="btn2" onclick="deletesh('+index+')">删除</a>';
}  
function check1(){
	var err='';
	var housename=$("#housename").textbox("getValue").trim();
	if(housename==''){err+='仓库名称不能为空<br>'};
	//---检验重复
	aa=$("#mydatagrid").datagrid("getRows");
	for(i=0;i<=aa.length-1;i++){
		if(housename==aa[i].housename.trim()){
			err+='仓库名称不能重复！<br>';
			break;
		}
	}
	if($("#managerid").textbox("getValue").trim()==''){err+='管理者不能为空<br>'};
	if($("#onoff").textbox("getValue").trim()==''){err+='是否启用不能为空<br>'};	
	
	if(err!=''){
		$.messager.alert('系统提示',err);
		return false;
	}else return true;
}
function editsh(index){  
	$("#mydatagrid").datagrid("selectRow",index)
	aa=$("#mydatagrid").datagrid("getSelected");
	$("#housename2").textbox("setValue",aa.housename);
	$("#managerid2").textbox("setValue",aa.managerid);
	$("#onoff2").combobox("select",aa.on_off);
	$("#mywin2").window('open');
}  

function editdo(){
	var url='editStorehouse?housename='+$("#housename2").textbox("getValue")+'&managerid='+$("#managerid2").textbox("getValue");
	url+='&onoff2='+$("#onoff2").combobox('getText').trim()+'&hn0='+aa.housename;

	url=encodeURI(url); 
	url=encodeURI(url); //二次次编码解决url传递中文
	$.ajax({
		url:url,
		method:'edit',
		async:false,
		success:function(){
			
		}
	})
	window.location.reload();


}




function deletesh(index){  
	if(window.confirm("确定删除？")){
		$("#mydatagrid").datagrid("selectRow",index)
		var aa=$("#mydatagrid").datagrid("getSelected");
		alert("删除成功");
		var url='deleteStorehouse?createrid='+aa.createrid+'&housename='+aa.housename,
		url=encodeURI(url); 
		url=encodeURI(url); //二次次编码解决url传递中文
		$.ajax({
			url:url,
			//traditional:true,
			//data:{keyword:"qqqqq"},delete、put这样传不了 
			method:'delete',
			async:false,
			success:function(){}
		})
		window.location.reload();
	}

}
function insertsh(){
	
	$("#mywin").window('open');
}
</script>


</body>
</html>