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
<div style="border:1px solid #BDBDBD;height:50px;margin:3px;width:97.5%;border-radius:8px">
	<div style="position:relative;top:10px;left:10px;height:48px;width:500px;display:inline">
		<label style="font-size:16px;">关键字:&nbsp</label> 
		<input id="key" style="width:180px;height:30px" class="easyui-combobox"/>
	</div>
	<div style="position:relative;top:10px;left:10px;height:48px;width:500px;display:inline">
		<label style="font-size:16px;">查找值:&nbsp</label> 
		<input id="value" style="width:180px;height:30px" class="easyui-textbox"/>
	</div>
	<input class="easyui-linkbutton" onclick="search1()" value="模糊查找" style="position:relative;top:9px;left:10px;height:33px;width:70px"/>
	<input class="easyui-linkbutton" onclick="search2()" value="精确查找"style="position:relative;top:9px;left:10px;height:33px;width:70px"/>
	
	<a href="#" id="insert" style="float:right;margin:10px" class="btn3" onclick="insertsh()">新增</a>
	
</div>
<div class="easyui-window" id="mywin" style="height:470px;width:390px" title="新增商品">
<form id="insert" action="postProduct1" onsubmit="return check1()" method="post">
		<div style="position:absolute;top:57px;left:50px">商品编码：</div>
		<div style="position:absolute;top:55px;left:120px"> <input id="productid" name="productid" type="text" class="easyui-textbox"/></div>
		<div style="position:absolute;top:102px;left:50px">商品名称:</div>
		<div style="position:absolute;top:100px;left:120px" > <input id="productname" name="productname" class="easyui-textbox"/></div>
		<div style="position:absolute;top:147px;left:50px">平均进价:</div>
		<div style="position:absolute;top:145px;left:120px" > <input id="apc" name="averagepercost" style="width:178px" class="easyui-numberbox" data-options="precision:2"/></div>
		
		<div style="position:absolute;top:192px;left:82px">品牌:</div>
		<div style="position:absolute;top:190px;left:120px" > <input id="brand" name="brand" class="easyui-textbox"/></div>
		<div style="position:absolute;top:237px;left:82px">种类:</div>
		<div style="position:absolute;top:235px;left:120px" > <input id="category" name="category" class="easyui-textbox"/></div>
		<div style="position:absolute;top:282px;left:76px">规格1:</div>
		<div style="position:absolute;top:280px;left:120px" > <input id="feature1" name="feature1" class="easyui-textbox"/></div>
		<div style="position:absolute;top:327px;left:76px">规格2:</div>
		<div style="position:absolute;top:325px;left:120px" > <input id="feature2" name="feature2" class="easyui-textbox" value=" "/></div>
		<div style="position:absolute;top:372px;left:50px">所存仓库:</div>
		<div style="position:absolute;top:370px;left:120px" > <input id="housename" name="housename" class="easyui-combobox"/></div>		
				
		
		<div style="position:absolute;top:415px;left:120px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="reset" value="重置"/></div>
		<div style="position:absolute;top:415px;left:200px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="submit" value="提交"></div>
		 
</form>
</div>
<div class="easyui-window" id="mywin2" style="height:470px;width:390px" title="修改商品">
<form id="update">
		<div style="position:absolute;top:57px;left:50px">商品编码：</div>
		<div style="position:absolute;top:55px;left:120px"> <input id="productid2" name="productid" type="text" class="easyui-textbox"/></div>
		<div style="position:absolute;top:102px;left:50px">商品名称:</div>
		<div style="position:absolute;top:100px;left:120px" > <input id="productname2" name="productname" class="easyui-textbox"/></div>
		<div style="position:absolute;top:147px;left:50px">平均进价:</div>
		<div style="position:absolute;top:145px;left:120px" > <input id="apc2" name="averagepercost" style="width:178px" class="easyui-numberbox" data-options="precision:2"/></div>
		
		<div style="position:absolute;top:192px;left:82px">品牌:</div>
		<div style="position:absolute;top:190px;left:120px" > <input id="brand2" name="brand" class="easyui-textbox"/></div>
		<div style="position:absolute;top:237px;left:82px">种类:</div>
		<div style="position:absolute;top:235px;left:120px" > <input id="category2" name="category" class="easyui-textbox"/></div>
		<div style="position:absolute;top:282px;left:76px">规格1:</div>
		<div style="position:absolute;top:280px;left:120px" > <input id="feature12" name="feature1" class="easyui-textbox"/></div>
		<div style="position:absolute;top:327px;left:76px">规格2:</div>
		<div style="position:absolute;top:325px;left:120px" > <input id="feature22" name="feature2" class="easyui-textbox"/></div>
		<div style="position:absolute;top:372px;left:50px">所存仓库:</div>
		<div style="position:absolute;top:370px;left:120px" > <input id="housename2" name="housename2" class="easyui-combobox"/></div>		
		
		<div style="position:absolute;top:415px;left:120px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="reset" value="重置"/></div>
		<div style="position:absolute;top:415px;left:200px"><input class="easyui-linkbutton" style="width:60px;height:25px" value="提交"  onclick="editdo()"></div>		 
</form>
</div>
</div>
</div>

<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="js/bootsnav.js"></script>


<script>
$(document).ready(function(){

	$("#mywin").window('close');
	$("#mywin2").window('close');
	$("#key").combobox({
		data:[{"id":"productid","text":"商品编码"},{"id":"productname","text":"名称"},{"id":"housename","text":"所存仓库"},{"id":"brand","text":"品牌"},{"id":"category","text":"种类"},{"id":"feature1","text":"规格1"}],
		valueField:'id',
		textField:'text',
		panelHeight:true,
		editable:false,
		formatter:function(row){
			s='<div style="font-size:15px">';
			s+=row.text;
			s+='</div>'
			return s
		}
	})


	$.ajax({
		url:'getProduct1',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			var str="<input class='eayui-datagrid' id='mydatagrid' style='width:900px;height:500px'/>";
			$("#realman").append($(str));
			$("#mydatagrid").datagrid({
				title: '&nbsp;商品列表',
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
							{ title: '名称', field: 'productname', width: 190, halign:'center', align: 'center'},
							{ title: '所存仓库', field: 'housename', width: 180, halign:'center', align: 'center'},
							{ title: '品牌', field:'brand', width: 140, halign:'center', align: 'center'},
							{ title: '种类', field:'category', width: 148, halign:'center', align: 'center'},	
							{ title: '规格1', field:'feature1', width: 135, halign:'center', align: 'center'},
							{ title: '规格2', field:'feature2', width: 130, halign:'center', align: 'center'},
							{ title: '单价', field:'averagepercost', width: 150, halign:'center', align: 'center'},
							{ title: '操作', field:'operate', width: 200, halign:'center', align: 'center',formatter:operate}
							]],
				frozenColumns: [[{ title:'商品编码',field: 'productid', width:190,align: 'center'}]]

			})		
		}
		})//---------ajax结束
		$.ajax({
			url:'getStorehouse',
			data:{},
			dataType: "json",
			anysc:false,
			method:'get',
			success:function(data){
				$("#housename").combobox({
					data:data,
					textField:"housename",
					valueField:"housename",
					panelHeight:true,
					editable:false
				})
				$("#housename2").combobox({
					data:data,
					textField:"housename",
					valueField:"housename",
					panelHeight:true,
					editable:false
				})
				}	
			})

})
function operate(val,row,index){  
    return '<a href="#" class="btn2" onclick="editsh('+index+')">修改</a>'+'<label style="width:30px"/>'+'<a href="#" class="btn2" onclick="deletesh('+index+')">删除</a>';
}  
function check1(){
	var err='';
	var productid=$("#productid").textbox("getValue").trim();
	if(productid==''){err+='商品编码不能为空<br>'};
	//---检验重复id
	aa=$("#mydatagrid").datagrid("getRows");
	for(i=0;i<=aa.length-1;i++){
		if(productid==aa[i].productid.trim()){
			err+='商品编码不能重复！<br>';
			break;
		}
	}
	if($("#productname").textbox("getValue").trim()==''){err+='商品名称不能为空<br>'};
	if($("#apc").numberbox("getValue").trim()==''){err+='商品进价不能为空<br>'};
	if($("#brand").textbox("getValue").trim()==''){err+='商品品牌不能为空<br>'};
	if($("#category").textbox("getValue").trim()==''){err+='商品种类不能为空<br>'};
	if($("#feature1").textbox("getValue").trim()==''){err+='商品规格1不能为空<br>'};	
	if($("#housename").textbox("getValue").trim()==''){err+='所存仓库不能为空<br>'};	
	if(err!=''){
		$.messager.alert('系统提示',err);
		return false;
	}else return true;
}
function editsh(index){  
//------------------------别忘记form 只有get和post
	$("#mydatagrid").datagrid("selectRow",index)
	aa=$("#mydatagrid").datagrid("getSelected");
	$("#productid2").textbox("setValue",aa.productid.trim());
	$("#productid2").textbox({readonly:true});
	$("#productname2").textbox("setValue",aa.productname.trim());
	$("#housename2").textbox("setValue",aa.housename.trim());
	$("#apc2").numberbox("setValue",aa.averagepercost.trim());
	$("#brand2").textbox("setValue",aa.brand.trim());
	$("#category2").textbox("setValue",aa.category.trim());
	$("#feature12").textbox("setValue",aa.feature1.trim());
	$("#feature22").textbox("setValue",aa.feature2.trim());	
	$("#mywin2").window('open');
	
}  

function editdo(){
	var flag=1;
	var err='';
	if($("#productname2").textbox("getValue").trim()==''){err+='商品名称不能为空<br>'};
	if($("#apc2").numberbox("getValue").trim()==''){err+='商品进价不能为空<br>'};
	if($("#brand2").textbox("getValue").trim()==''){err+='商品品牌不能为空<br>'};
	if($("#category2").textbox("getValue").trim()==''){err+='商品种类不能为空<br>'};
	if($("#feature12").textbox("getValue").trim()==''){err+='商品规格1不能为空<br>'};	
	if($("#housename2").textbox("getValue").trim()==''){err+='所存仓库不能为空<br>'};	
	if(err!=''){
		$.messager.alert('系统提示',err);
	}else flag=2;
	if(flag==2){
		var url='editProduct1?productid='+$("#productid2").textbox("getValue")+'&productname='+$("#productname2").textbox("getValue")+'&housename='+$("#housename2").textbox("getValue");
		url+='&averagepercost='+$("#apc2").numberbox('getValue')+'&brand='+$("#brand2").textbox("getValue")+'&category='+$("#category2").textbox("getValue");
		url+='&feature1='+$("#feature12").textbox("getValue")+'&feature2='+$("#feature22").textbox("getValue");
		url=encodeURI(url); 
		url=encodeURI(url); //二次次编码解决（url）ajax提交传递中文,表单postservlet写一句request.setCharacterEncoding("utf-8");就行。
		$.ajax({
			url:url,
			method:'edit',
			async:false,
			success:function(){
				
			}
		})
		window.location.reload();
	}
}




function deletesh(index){  
	if(window.confirm("确定删除？")){
		$("#mydatagrid").datagrid("selectRow",index)
		var aa=$("#mydatagrid").datagrid("getSelected");
		alert("删除成功");
		var url='deleteProduct1?productid='+aa.productid;
		$.ajax({
			url:url,
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

function search1(){
	key=$("#key").combobox('getValue');
	value=$("#value").textbox('getValue');
	url='getProduct1?key='+key+'&value1='+value;
	url=encodeURI(url); 
	url=encodeURI(url);
	$.ajax({
		url:url,
		method:'get',
		async:false,
		success:function(data){
			data=eval(data);
			$("#mydatagrid").datagrid('loadData',data);
		}
	})
}
function search2(){
	key=$("#key").combobox('getValue');
	value=$("#value").textbox('getValue');
	url='getProduct1?key='+key+'&value2='+value;
	url=encodeURI(url); 
	url=encodeURI(url);
	$.ajax({
		url:url,
		method:'get',
		async:false,
		success:function(data){
			data=eval(data);
			$("#mydatagrid").datagrid('loadData',data);
		}
	})
}


</script>


</body>
</html>