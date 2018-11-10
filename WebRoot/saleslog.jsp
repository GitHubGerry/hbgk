<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>何不管库</title>	
	<jsp:include page="toolbar.jsp"/>
	<link rel="stylesheet" type="text/css" href="jqeasyui/themes/default/easyui.css">	
	
</head>
<body>

<div id="main">
<div id="realman" style="">
<div id="datagrid_div" style="position:absolute;top:200px">


</div>
</div>
</div>

<script>
$(document).ready(function(){
	$.ajax({
		url:'selectSalesOrder',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			console.log(data);
			var str="<input class='eayui-datagrid' id='mydatagrid' style='width:900px;height:500px'/>";
			$("#datagrid_div").append($(str));
			$("#mydatagrid").datagrid({
				title: '&nbsp;进货记录',
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
							{ title: '商品信息', field: 'productid', width: 192, halign:'center', align: 'center'},
							{ title: '顾客信息', field:'buyerid', width: 192, halign:'center', align: 'center'},
							{ title: '存入仓库', field:'housename', width: 192, halign:'center', align: 'center'},
							{ title: '单价', field:'perprice', width: 158, halign:'center', align: 'center'},	
							{ title: '数量', field:'quantity', width: 158, halign:'center', align: 'center'},
							{ title: '总金额', field:'amount', width: 168, halign:'center', align: 'center'},
							{ title: '订单日期', field:'orderdate', width: 175, halign:'center', align: 'center'},
							]],
				frozenColumns: [[{ title:'收货单编号',field: 'orderid', width:210,align: 'center'}]]

			})		
		}
		})//---------ajax结束
})




</script>
</body>
</html>