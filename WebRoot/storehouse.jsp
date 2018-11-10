<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="zh">
<head>
	<meta charset="UTF-8">	
	<jsp:include page="toolbar.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="jqeasyui/themes/gray/easyui.css">
</head>
<body>

<div id="main">

<div id="realman">
<div id="datagrid_div" style="position:absolute;top:210px" ></div>
<a href="#" id="insert" style="position:absolute;left:93%;top:177px;margin-right:30px" class="btn3" onclick="insertsh()">新增</a>
<div class="easyui-window" id="mywin" style="height:280px;width:390px" title="新增仓库">
<form id="insert" >
		<div style="position:absolute;top:57px;left:50px">仓库名称：</div>
		<div style="position:absolute;top:55px;left:120px"> <input id="housename" name="housename" type="text" class="easyui-textbox"/></div>
		<div style="position:absolute;top:102px;left:66px">管理者:</div>
		<div style="position:absolute;top:100px;left:120px" > <input id="managerid" name="managerid" class="easyui-textbox"/></div>
		<div style="position:absolute;top:147px;left:50px">是否启用:</div>
		<div style="position:absolute;top:145px;left:120px" > <input id="onoff" name="onoff" style="width:178px" class="easyui-combobox"/></div>
		<div style="position:absolute;top:190px;left:120px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="reset" value="重置"/></div>
		<div style="position:absolute;top:190px;left:200px"><input class="easyui-linkbutton" style="width:60px;height:25px" onClick="check1()" value="提交"></div>
		 
</form>
</div>
<div class="easyui-window" id="mywin2" style="height:280px;width:390px" title="修改仓库">
<form id="edit">
		<div style="position:absolute;top:57px;left:50px">仓库名称：</div>
		<div style="position:absolute;top:55px;left:120px"> <input id="housename2" name="housename2" type="text" class="easyui-textbox"/></div>
		<div style="position:absolute;top:102px;left:66px">管理者:</div>
		<div style="position:absolute;top:100px;left:120px" > <input id="managerid2" name="managerid2" class="easyui-textbox"/></div>
		<div style="position:absolute;top:147px;left:50px">是否启用:</div>
		<div style="position:absolute;top:145px;left:120px" > <input id="onoff2" name="onoff2" style="width:178px" class="easyui-combobox"/></div>
		<div style="position:absolute;top:190px;left:120px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="reset" value="重置"/></div>
		<div style="position:absolute;top:190px;left:200px"><input class="easyui-linkbutton" style="width:60px;height:25px" value="提交" onclick="editdo()"></div>
		 
</form>
</div>

</div> 
	
</div>


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
		url:'selectStorehouse',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			console.log(data);
			var str="<input class='eayui-datagrid' id='mydatagrid'/>";
			$("#datagrid_div").append($(str));
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
	var managerid=$("#managerid").textbox("getValue").trim();
	var onoff=$("#onoff").textbox("getValue").trim();
	
	if(housename==''){err+='仓库名称不能为空<br>'};
	//---检验重复
	aa=$("#mydatagrid").datagrid("getRows");
	for(i=0;i<=aa.length-1;i++){
		if(housename==aa[i].housename.trim()){
			err+='仓库名称不能重复！<br>';
			break;
		}
	}
	if(managerid==''){err+='管理者不能为空<br>'};
	if(onoff==''){err+='是否启用不能为空<br>'};	
	
	if(err!=''){
		$.messager.alert('系统提示',err);
		return false;
	}else {
		createdo(housename,managerid,onoff);
	};
}

function createdo(housename,managerid,onoff){
	var url="insertStorehouse?housename="+housename+"&managerid="+managerid+"&onoff="+onoff;
	//console.log(url);
	$.ajax({
		url:url,
		async:false,
		success:function(){
			
		}
		
	})
	window.location.reload();
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
	var url='updateStorehouse?housename='+$("#housename2").textbox("getValue").trim()+'&managerid='+$("#managerid2").textbox("getValue").trim();
	url+='&onoff='+$("#onoff2").combobox('getText').trim()+'&housename0='+aa.housename.trim();

	/*url=encodeURI(url); 
	url=encodeURI(url); //二次次编码解决url传递中文*/
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
		
		var url='deleteStorehouse?createrid='+aa.createrid+'&housename='+aa.housename
		$.ajax({
			url:url,
			//traditional:true,
			//data:{keyword:"qqqqq"},delete、put这样传不了 
			method:'delete',
			async:false,
			success:function(){alert("删除成功");}
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