<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>何不管库</title>
	<jsp:include page="toolbar.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="jqeasyui/themes/gray/easyui.css">
	
</head>
<body>

<div id="main">

<div id="realman">
<div style="border:1px solid #BDBDBD;height:50px;margin:3px;width:97.5%;border-radius:8px;position:absolute;top:170px">
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
<div id="datagrid_div" style="position:absolute;top:240px" ></div>
<div class="easyui-window" id="mywin" style="height:470px;width:390px" title="新增商品">
<form id="insert" >
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
		<div style="position:absolute;top:415px;left:200px"><input class="easyui-linkbutton" style="width:60px;height:25px" onclick="check1()" value="提交"></div>
		 
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
		url:'selectProduct',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			var str="<input class='eayui-datagrid' id='mydatagrid' style='width:900px;height:500px'/>";
			$("#datagrid_div").append($(str));
			$("#mydatagrid").datagrid({
				title: '&nbsp;商品列表',
				iconCls: "panelIcon",
				width:1500, 
				height:400,
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
			url:'selectStorehouse',
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
	var productname=$("#productname").textbox("getValue").trim();
	var apc=$("#apc").numberbox("getValue").trim();
	var brand=$("#brand").textbox("getValue").trim();
	var category=$("#category").textbox("getValue").trim();
	var feature1=$("#feature1").textbox("getValue").trim();
	var feature2=$("#feature2").textbox("getValue").trim();
	var housename=$("#housename").textbox("getValue").trim();
	
	if(productid==''){err+='商品编码不能为空<br>'};
	//---检验重复id
	aa=$("#mydatagrid").datagrid("getRows");
	for(i=0;i<=aa.length-1;i++){
		if(productid==aa[i].productid.trim()){
			err+='商品编码不能重复！<br>';
			break;
		}
	}
	if(productname==''){err+='商品名称不能为空<br>'};
	if(apc==''){err+='商品进价不能为空<br>'};
	if(brand==''){err+='商品品牌不能为空<br>'};
	if(category==''){err+='商品种类不能为空<br>'};
	if(feature1==''){err+='商品规格1不能为空<br>'};	
	if(housename==''){err+='所存仓库不能为空<br>'};	
	if(err!=''){
		$.messager.alert('系统提示',err);
		return false;
	}else {
		insertdo(productid,productname,apc,housename,brand,category,feature1,feature2);
	};
}
function insertdo(productid,productname,apc,housename,brand,category,feature1,feature2){
	var url="insertProduct?productid="+productid+"&productname="+productname+"&apc="+apc;
	url+="&housename="+housename+"&brand="+brand+"&category="+category+"&feature1="+feature1+"&feature2="+feature2;
	console.log(url);
	$.ajax({
		url:url,
		async:false,
		success:function(){
			window.location.reload();
		}
		
	})
}

function editsh(index){  
//------------------------别忘记form 只有get和post
	$("#mydatagrid").datagrid("selectRow",index)
	aa=$("#mydatagrid").datagrid("getSelected");
	$("#productid2").textbox("setValue",aa.productid.trim());
	$("#productid2").textbox({readonly:true});
	$("#productname2").textbox("setValue",aa.productname.trim());
	$("#housename2").textbox("setValue",aa.housename.trim());
	$("#apc2").numberbox("setValue",aa.averagepercost);
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
		var url='updateProduct?productid='+$("#productid2").textbox("getValue")+'&productname='+$("#productname2").textbox("getValue")+'&housename='+$("#housename2").textbox("getValue");
		url+='&apc='+$("#apc2").numberbox('getValue')+'&brand='+$("#brand2").textbox("getValue")+'&category='+$("#category2").textbox("getValue");
		url+='&feature1='+$("#feature12").textbox("getValue")+'&feature2='+$("#feature22").textbox("getValue");

		$.ajax({
			url:url,
			method:'edit',
			async:false,
			success:function(){
				window.location.reload();	
			}
		})
		
	}
}




function deletesh(index){  
	if(window.confirm("确定删除？")){
		$("#mydatagrid").datagrid("selectRow",index)
		var aa=$("#mydatagrid").datagrid("getSelected");
		alert("删除成功");
		var url='deleteProduct?productid='+aa.productid;
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
	url='MHselect?key='+key+'&value='+value;
	console.log(url)

	$.ajax({
		url:url,
		method:'get',
		async:false,
		success:function(data){
			console.log("data---"+data)
			data=eval(data);
			$("#mydatagrid").datagrid('loadData',data);
		}
	})
}
function search2(){
	key=$("#key").combobox('getValue');
	value=$("#value").textbox('getValue');
	url='JQselect?key='+key+'&value='+value;

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